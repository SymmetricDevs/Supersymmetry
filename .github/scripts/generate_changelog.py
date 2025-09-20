#!/usr/bin/env python3
import os
import re
import subprocess
import toml
import logging
import requests
from collections import defaultdict
from datetime import datetime

# Extract current version from the most recent commit or newest tag
def get_current_version():
    # Try to get from the current tag if we're on a tag
    try:
        current_tag = subprocess.check_output(["git", "describe", "--exact-match", "--tags"]).decode().strip()
        if current_tag and current_tag != "latest":
            return current_tag
    except subprocess.CalledProcessError:
        pass
    
    # If no tag, try to extract from a version file or use a timestamp
    return f"next-{datetime.now().strftime('%Y%m%d')}"

# GitHub API configuration
# NOTE: These will need to be set as GitHub secrets and passed to the script
GITHUB_TOKEN = os.environ.get("GITHUB_TOKEN", "")
GITHUB_REPO = "SymmetricDevs/Supersymmetry"  # Format: owner/repo
GITHUB_ORG = os.environ.get("GITHUB_ORGANIZATION", "SymmetricDevs")  # Default organization
VERSION = os.environ.get("VERSION", get_current_version())
GITHUB_API_BASE = "https://api.github.com"
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

# Find the latest tag (excluding "latest")
def get_latest_tag():
    tags = subprocess.check_output(["git", "tag", "-l", "--sort=-v:refname"]).decode().strip().split("\n")
    for tag in tags:
        version_match = re.search("^(?:[0-9]\.?)+", tag)
        if version_match:
            return tag
    return None


# Get mod details from toml file
def parse_mod_file(file_path):
    try:
        data = toml.load(file_path)
        name = data.get("name", "Unknown")
        filename = data.get("filename", "")
        
        # Extract version from filename
        version_match = re.search(r"-([^-]+(?:-[^-]+)*?)\.jar$", filename)
        version = version_match.group(1) if version_match else "Unknown"
        
        return {
            "name": name,
            "version": version,
            "filename": filename
        }
    except Exception as e:
        print(f"Error parsing {file_path}: {e}")
        return None

# Get all mods in a specific git reference
def get_mods_at_ref(ref):
    result = {}
    try:
        # Get list of mod files at the specific ref
        mod_files = subprocess.check_output(
            ["git", "ls-tree", "-r", "--name-only", ref, "mods/"], 
            stderr=subprocess.DEVNULL
        ).decode().strip().split("\n")
        
        for file_path in mod_files:
            if not file_path.endswith(".toml"):
                continue
                
            # Get file content at ref
            file_content = subprocess.check_output(
                ["git", "show", f"{ref}:{file_path}"]
            ).decode()
            
            # Write to temp file for toml parsing
            temp_file = f"/tmp/{os.path.basename(file_path)}"
            with open(temp_file, "w") as f:
                f.write(file_content)
                
            mod_info = parse_mod_file(temp_file)
            if mod_info:
                result[os.path.basename(file_path)] = mod_info
                
            # Clean up temp file
            os.remove(temp_file)
    except subprocess.CalledProcessError:
        print(f"Error getting mod files at ref {ref}")
    
    return result

# Get current mods
def get_current_mods():
    result = {}
    for file_name in os.listdir("mods"):
        if file_name.endswith(".toml"):
            mod_info = parse_mod_file(os.path.join("mods", file_name))
            if mod_info:
                result[file_name] = mod_info
    return result

# Find SusyCore mod versions
def find_susy_core_versions(old_mods, new_mods):
    # Look for SusyCore in both old and new mods
    old_version = None
    new_version = None
    
    for mod_file, mod_info in old_mods.items():
        if "SusyCore" in mod_info["name"]:
            old_version = mod_info["version"]
            break
    
    for mod_file, mod_info in new_mods.items():
        if "SusyCore" in mod_info["name"]:
            new_version = mod_info["version"]
            break
    
    return old_version, new_version

# Generate mod changes section of the changelog
def generate_mod_changelog():
    tag = get_latest_tag()
    if not tag:
        print("No tags found excluding 'latest'")
        return "No previous tag found to compare against.", None, None
    
    print(f"Found latest tag: {tag}")
    
    # Get mods at the tag and current state
    tag_mods = get_mods_at_ref(tag)
    current_mods = get_current_mods()
    
    # Get SusyCore versions for additional changelog
    susy_old_version, susy_new_version = find_susy_core_versions(tag_mods, current_mods)
    
    # Compare mods
    changes = {
        "updates": [],
        "additions": [],
        "removals": []
    }
    
    # Find updates and additions
    for file_name, current_mod in current_mods.items():
        if file_name in tag_mods:
            # Mod exists in both - check if version changed
            if current_mod["version"] != tag_mods[file_name]["version"]:
                changes["updates"].append({
                    "name": current_mod["name"],
                    "old_version": tag_mods[file_name]["version"],
                    "new_version": current_mod["version"]
                })
        else:
            # Mod exists only in current - it's an addition
            changes["additions"].append({
                "name": current_mod["name"],
                "version": current_mod["version"]
            })
    
    # Find removals
    for file_name, tag_mod in tag_mods.items():
        if file_name not in current_mods:
            changes["removals"].append({
                "name": tag_mod["name"]
            })
    
    # Generate markdown
    markdown = "## Mod Changes\n\n"
    
    if changes["updates"]:
        markdown += "### Mod Updates\n"
        for update in changes["updates"]:
            markdown += f"- {update['name']} {update['old_version']} → {update['new_version']}\n"
        markdown += "\n"
    
    if changes["additions"]:
        markdown += "### Mod Additions\n"
        for addition in changes["additions"]:
            markdown += f"- {addition['name']} → {addition['version']}\n"
        markdown += "\n"
    
    if changes["removals"]:
        markdown += "### Mod Removals\n"
        for removal in changes["removals"]:
            markdown += f"- {removal['name']}\n"
        markdown += "\n"
    
    return markdown, susy_old_version, susy_new_version

# Get the date of a git reference
def get_reference_date(ref):
    date_str = subprocess.check_output(
        ["git", "log", "-1", "--format=%ai", ref]
    ).decode().strip()
    return date_str


def get_latest_commit_sha(repo_full_name: str, headers: dict) -> str | None:
    logging.info(f"Fetching repository details for {repo_full_name} to find default branch.")
    repo_url = f"{GITHUB_API_BASE}/repos/{repo_full_name}"
    try:
        response = requests.get(repo_url, headers=headers)
        response.raise_for_status()  # Raise HTTPError for bad responses (4xx or 5xx)
        repo_data = response.json()
        default_branch = repo_data.get("default_branch")
        if not default_branch:
            logging.error(f"Could not determine default branch for {repo_full_name}.")
            return None

        logging.info(f"Default branch for {repo_full_name} is '{default_branch}'. Fetching latest commit.")
        commits_url = f"{GITHUB_API_BASE}/repos/{repo_full_name}/commits/{default_branch}"
        response = requests.get(commits_url, headers=headers)
        response.raise_for_status()
        commit_data = response.json()
        latest_sha = commit_data.get("sha")
        if latest_sha:
            logging.info(f"Latest commit SHA on branch '{default_branch}' is {latest_sha}")
            return latest_sha
        else:
            logging.error(f"Could not get latest commit SHA for {repo_full_name} on branch '{default_branch}'.")
            return None

    except requests.exceptions.RequestException as e:
        logging.error(f"Error fetching repository details or latest commit for {repo_full_name}: {e}")
        if e.response is not None:
            logging.error(f"Response status: {e.response.status_code}")
            logging.error(f"Response body: {e.response.text}")
        return None
    except Exception as e:
        logging.error(f"An unexpected error occurred while fetching latest commit: {e}")
        return None


def get_merged_prs_between_refs(repo_full_name: str, start_ref: str, end_ref: str | None = None) -> list[dict]:
    if not repo_full_name:
        logging.error("Repository name (owner/repo) is required.")
        return []
    if not start_ref:
        logging.error("Starting reference (tag, branch, SHA) is required.")
        return []

    headers = {
        "Authorization": f"token {GITHUB_TOKEN}",
        "Accept": "application/vnd.github.v3+json"
    }

    # Determine the end reference
    effective_end_ref = end_ref
    if not effective_end_ref:
        logging.info(f"No end reference provided for {repo_full_name}. Determining latest commit...")
        effective_end_ref = get_latest_commit_sha(repo_full_name, headers)
        if not effective_end_ref:
            logging.error(f"Could not determine the latest commit for {repo_full_name}. Aborting.")
            return []
        logging.info(f"Using latest commit {effective_end_ref} as the end reference.")
    else:
        logging.info(f"Using provided end reference: {effective_end_ref}")

    logging.info(f"Looking for PRs merged in {repo_full_name} between {start_ref} and {effective_end_ref}")

    # Use the GitHub compare endpoint to get commits between the two refs
    compare_url = f"{GITHUB_API_BASE}/repos/{repo_full_name}/compare/{start_ref}...{effective_end_ref}"
    
    all_commits = []
    page = 1
    while True:
        paginated_url = f"{compare_url}?page={page}&per_page=250"
        logging.info(f"Fetching comparison page {page}: {compare_url}") # Use base url for logging
        try:
            response = requests.get(paginated_url, headers=headers) # No pagination params needed here
            response.raise_for_status()
            compare_data = response.json()
            commits = compare_data.get("commits", [])
            total_commits = compare_data.get("total_commits", len(commits))

            if not commits:
                 logging.info(f"No commits found between {start_ref} and {effective_end_ref} on page {page}.")
                 break # Exit loop if no commits or after handling the single page

            all_commits.extend(commits)
            if (len(all_commits) == total_commits):
                break
            page += 1
        except requests.exceptions.RequestException as e:
            logging.error(f"Error fetching comparison from {compare_url}: {e}")
            if e.response is not None:
                logging.error(f"Response status: {e.response.status_code}")
                logging.error(f"Response body: {e.response.text}")
                if e.response.status_code == 404:
                    logging.error(f"Repository '{repo_full_name}' or refs '{start_ref}'/'{effective_end_ref}' not found.")
            return [] # Stop processing if compare fails
        except Exception as e:
            logging.error(f"An unexpected error occurred during comparison fetch: {e}")
            return []


    # Look through commits to find associated PRs
    logging.info(f"Processing {len(all_commits)} commits to find associated Pull Requests...")
    prs = {} # Use dict to store PRs by ID for automatic deduplication
    commit_pr_association_url_base = f"{GITHUB_API_BASE}/repos/{repo_full_name}/commits"

    for i, commit in enumerate(all_commits):
        commit_sha = commit.get("sha")
        if not commit_sha:
            logging.warning(f"Commit data missing SHA: {commit}")
            continue
        message = commit.get("commit").get("message")
        filter = re.search("Merge pull request #[0-9]+", message)
        if not filter:
            continue
        # Check if this commit is associated with a PR (usually merge commits)
        # Use the commit/pulls endpoint (more reliable for merge commits)
        # This endpoint requires the 'pulls: read' scope if the repo is private.
        pr_url = f"{commit_pr_association_url_base}/{commit_sha}/pulls"
        try:
            # Add header to specifically ask for the gfm description format if needed later,
            # but for now, default json is fine.
            pr_response = requests.get(pr_url, headers=headers)
            # Allow 404s gracefully - commit might not be associated with a PR
            if pr_response.status_code == 404:
                logging.debug(f"Commit {commit_sha} not directly associated with a PR via API.")
                continue
            pr_response.raise_for_status() # Raise for other errors (5xx, 403, etc.)

            commit_prs_data = pr_response.json()

            # This endpoint returns an array of PRs associated with the commit.
            # Usually for a merge commit, it's just one.
            for pr_summary in commit_prs_data:
                pr_number = pr_summary.get("number")
                pr_id = pr_summary.get("id") # Use Github's global PR ID
                if not pr_number or not pr_id:
                    logging.warning(f"PR data associated with commit {commit_sha} is missing number or id: {pr_summary}")
                    continue

                # Check if we already processed this PR
                if pr_id in prs:
                    logging.debug(f"PR #{pr_number} (ID: {pr_id}) already found, skipping duplicate.")
                    continue
                
                logging.info(f"Found PR #{pr_number} associated with commit {commit_sha[:7]}")
                pr_data = pr_summary # Use the summary data directly
                pr_data["repository"] = repo_full_name # Add repository context
                prs[pr_id] = pr_data # Add to dict using unique ID as key

        except requests.exceptions.RequestException as e:
            # Log non-404 errors for the commit/pulls endpoint
            if e.response is None or e.response.status_code != 404:
                 logging.error(f"Error checking PRs for commit {commit_sha}: {e}")
                 if e.response is not None:
                    logging.error(f"Response status: {e.response.status_code}")
                    logging.error(f"Response body: {e.response.text}")
            # Continue to the next commit even if one fails
            continue
        except Exception as e:
            logging.error(f"An unexpected error occurred processing commit {commit_sha}: {e}")
            continue # Continue to next commit

    unique_prs_list = list(prs.values())
    logging.info(f"Found {len(unique_prs_list)} unique PRs merged between {start_ref} and {effective_end_ref}.")

    unique_prs_list.sort(key=lambda pr: pr.get("number"))

    return unique_prs_list
# Categorize a PR based on its labels or title
def categorize_pr(pr):
    # Check for the "internal" label to skip this PR
    labels = [label["name"].lower() for label in pr.get("labels", [])]
    if "internal" in labels:
        return "internal"
    
    # First, check for specific labels
    if any(label in ["feature", "enhancement"] for label in labels):
        return "new_features"
    elif any(label in ["change", "update", "changed"] for label in labels):
        return "changed_features"
    elif any(label in ["fix", "bug", "bugfix"] for label in labels):
        return "fixes"
    
    # If no matching labels, try to categorize based on title
    title = pr.get("title", "").lower()
    if any(keyword in title for keyword in ["add", "new", "feature", "implement"]):
        return "new_features"
    elif any(keyword in title for keyword in ["change", "update", "improve", "refactor"]):
        return "changed_features"
    elif any(keyword in title for keyword in ["fix", "bug", "issue", "resolve", "solve"]):
        return "fixes"
    
    # If we can't categorize, put in uncategorized
    return "uncategorized"

# Generate the PR section of the changelog
def generate_pr_changelog(prs):
    categorized_prs = {
        "new_features": [],
        "changed_features": [],
        "fixes": [],
        "uncategorized": [],
        "internal": []
    }
    
    # Categorize PRs
    for pr in prs:
        category = categorize_pr(pr)
        if category:
            categorized_prs[category].append(pr)
    
    markdown = "## Changes\n\n"

    # Generate categorized sections
    sections = [
        ("### New Features", categorized_prs["new_features"]),
        ("### Changed Features", categorized_prs["changed_features"]),
        ("### Fixes", categorized_prs["fixes"]),
        ("### TODO: Uncategorized Changes (Please Categorize)", categorized_prs["uncategorized"])
    ]
    
    for section_title, section_prs in sections:
        if section_prs:
            markdown += f"{section_title}\n"
            for pr in section_prs:
                title = pr.get("title", "No title")
                number = pr.get("number", "")
                author = pr.get("user", {}).get("login", "Unknown")
                repo = pr.get("repository", "").split("/")[-1]  # Extract repo name from full path
                
                # Include repository name if it's not the main repo
                if repo != GITHUB_REPO.split("/")[-1]:
                    markdown += f"- [{repo}] {title} (#{number} by @{author})\n"
                else:
                    markdown += f"- {title} (#{number} by @{author})\n"
            markdown += "\n"
    
    # Skip internal PRs in the changelog
    
    return markdown

# Generate the complete changelog
def generate_full_changelog():
    tag = get_latest_tag()
    if not tag:
        return "No previous tag found to compare against."
    
    # Get current version
    current_version = VERSION
    
    # Generate mod changes section and get SusyCore versions
    mod_changes, susy_old_version, susy_new_version = generate_mod_changelog()
    
    # Get merged PRs since the last tag from main repo
    main_prs = get_merged_prs_between_refs("SymmetricDevs/Supersymmetry", tag)
    
    # Get merged PRs from SusyCore between relevant versions
    susy_prs = []
    if susy_old_version and susy_new_version:
        susy_prs = get_merged_prs_between_refs("SymmetricDevs/Susy-Core", susy_old_version, susy_new_version)
    
    # Combine PRs from both repositories
    all_prs = main_prs + susy_prs
    
    # Generate PR changelog section
    pr_changes = generate_pr_changelog(all_prs)
    
    # Combine all sections
    header = f"# UPDATE {current_version}\n\n"
    full_changelog = header + mod_changes + pr_changes
    
    return full_changelog

# Main execution
if __name__ == "__main__":
    changelog = generate_full_changelog()
    print(changelog)
    
    # Output the changelog for GitHub Actions if we're in a GitHub Actions environment
    if "GITHUB_OUTPUT" in os.environ:
        with open(os.environ["GITHUB_OUTPUT"], "a") as f:
            delimiter = "EOF" + os.urandom(8).hex()
            f.write(f"changelog<<{delimiter}\n{changelog}\n{delimiter}\n")
    
    # Also write to a file for easier access
    with open("modpack-changelog.md", "w") as f:
        f.write(changelog)
