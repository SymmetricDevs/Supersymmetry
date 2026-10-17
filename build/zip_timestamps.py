"""Give exported Groovy scripts a fresh modification time for each build."""

import copy
from datetime import datetime, timezone
from pathlib import Path
import shutil
import struct
import tempfile
import zipfile


def _timestamp_extra(extra, timestamp):
    # Remove competing timestamp fields before adding the UTC modification time.
    fields = []
    offset = 0
    while offset < len(extra):
        if offset + 4 > len(extra):
            raise zipfile.BadZipFile("Truncated ZIP extra field")
        field_id, size = struct.unpack_from("<HH", extra, offset)
        end = offset + 4 + size
        if end > len(extra):
            raise zipfile.BadZipFile("Truncated ZIP extra field")
        if field_id not in (0x5455, 0x000A, 0x5855):
            fields.append(extra[offset:end])
        offset = end
    fields.append(struct.pack("<HHBI", 0x5455, 5, 1, timestamp))
    return b"".join(fields)


def stamp_groovy_timestamps(archive, build_time=None):
    """Stamp client scripts at export time, preserving file contents and metadata."""
    archive = Path(archive)
    build_time = build_time or datetime.now(timezone.utc)
    if build_time.tzinfo is None:
        raise ValueError("build_time must include a timezone")
    build_time = build_time.astimezone(timezone.utc)
    date_time = build_time.timetuple()[:6]
    timestamp = int(build_time.timestamp())

    # Packwiz's override writer omits modification times:
    # https://github.com/packwiz/packwiz/blob/170b22d785959dda5876b54b7f16e1b807a57fb6/cmdshared/downloadutil.go#L68-L95
    # GroovyScript 1.4.3 considers equal/older mtimes cache hits. Use a fresh
    # build time for ALL scripts, including helpers imported by other scripts.
    with tempfile.NamedTemporaryFile(dir=archive.parent, suffix=".zip", delete=False) as temp:
        temporary = Path(temp.name)
    try:
        count = 0
        with zipfile.ZipFile(archive) as source, zipfile.ZipFile(temporary, "w") as target:
            target.comment = source.comment
            for entry in source.infolist():
                updated = copy.copy(entry)
                if entry.filename.startswith("overrides/groovy/") and entry.filename.endswith(".groovy"):
                    updated.date_time = date_time
                    updated.extra = _timestamp_extra(entry.extra, timestamp)
                    count += 1
                with source.open(entry) as src, target.open(updated, "w") as dst:
                    shutil.copyfileobj(src, dst)
                # zipfile supplies default permissions when the original was zero.
                updated.external_attr = entry.external_attr
        if count == 0:
            raise ValueError("Client export contains no Groovy scripts")
        temporary.replace(archive)
        return count
    finally:
        temporary.unlink(missing_ok=True)
