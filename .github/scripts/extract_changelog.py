import sys
import re
import os
import uuid

def set_output(name, value):
    with open(os.environ['GITHUB_OUTPUT'], 'a') as fh:
        print(f'{name}={value}', file=fh)


def set_multiline_output(name, value):
    with open(os.environ['GITHUB_OUTPUT'], 'a') as fh:
        delimiter = uuid.uuid1()
        print(f'{name}<<{delimiter}', file=fh)
        print(value, file=fh)
        print(delimiter, file=fh)

def extract_changelog_section(changelog_path, version):
    try:
        with open(changelog_path, 'r', encoding='utf-8') as file:
            content = file.read()
        
        # Create a pattern to match the specific version header and its content
        # up to the next version header (or end of file)
        pattern = fr'# UPDATE {re.escape(version)}.*?(?=# UPDATE |\Z)'
        
        # Use re.DOTALL to match across multiple lines
        match = re.search(pattern, content, re.DOTALL)
        
        if match:
            return match.group(0).strip()
        else:
            print(f"Error: No changelog entry found for version {version}")
            sys.exit(1)
    except Exception as e:
        print(f"Error reading changelog: {e}")
        sys.exit(1)

if __name__ == "__main__":
    # Check if version argument was provided
    version = os.environ.get("VERSION")
 
    # Default changelog path or provided path
    changelog_path = "CHANGELOG.md"
    
    if not os.path.exists(changelog_path):
        print(f"Error: Changelog file not found at {changelog_path}")
        sys.exit(1)
    
    changelog_section = extract_changelog_section(changelog_path, version)
    changelog_section += f"\nDownload the server and client on [GitHub](https://github.com/SymmetricDevs/Supersymmetry/releases/tag/{version})!"
    print(changelog_section)
    set_multiline_output("changelog", changelog_section)
