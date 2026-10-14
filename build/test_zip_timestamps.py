from datetime import datetime, timezone
from pathlib import Path
import struct
import tempfile
import unittest
import zipfile

from zip_timestamps import stamp_groovy_timestamps


class ExportTimestampsTest(unittest.TestCase):
    def setUp(self):
        self.directory = tempfile.TemporaryDirectory()
        self.addCleanup(self.directory.cleanup)
        self.archive = Path(self.directory.name) / "client.zip"
        self.script = "overrides/groovy/postInit/recipe.groovy"
        self.helper = "overrides/groovy/classes/Helper.groovy"
        self.build_time = datetime(2026, 10, 14, 12, 0, 4, tzinfo=timezone.utc)

    def write_archive(self, scripts=True):
        with zipfile.ZipFile(self.archive, "w") as archive:
            archive.comment = b"archive comment"
            directory = zipfile.ZipInfo("overrides/")
            archive.writestr(directory, b"")
            directory.external_attr = 0
            archive.writestr("manifest.json", b'{"manifestVersion":1}')
            archive.writestr("overrides/config/example.cfg", b"unchanged config")
            if scripts:
                info = zipfile.ZipInfo(self.script, (1980, 0, 0, 0, 0, 0))
                info.compress_type = zipfile.ZIP_DEFLATED
                info.external_attr = 0o100644 << 16
                info.comment = b"entry comment"
                info.extra = struct.pack("<HHBI", 0x5455, 5, 1, 0) + struct.pack("<HH2s", 0xCAFE, 2, b"ok")
                archive.writestr(info, b"println 'recipe'")
                archive.writestr(self.helper, b"class Helper {}")

    def test_preserves_contents_and_unrelated_metadata(self):
        self.write_archive()
        with zipfile.ZipFile(self.archive) as archive:
            before = {i.filename: (archive.read(i), i.date_time, i.extra, i.compress_type,
                                   i.external_attr, i.comment) for i in archive.infolist()}
        self.assertEqual(stamp_groovy_timestamps(self.archive, self.build_time), 2)
        with zipfile.ZipFile(self.archive) as archive:
            self.assertIsNone(archive.testzip())
            self.assertEqual(archive.comment, b"archive comment")
            self.assertEqual(archive.namelist(), list(before))
            for entry in archive.infolist():
                content, date, extra, compression, attributes, comment = before[entry.filename]
                self.assertEqual(archive.read(entry), content)
                self.assertEqual((entry.compress_type, entry.external_attr, entry.comment),
                                 (compression, attributes, comment))
                if entry.filename in (self.script, self.helper):
                    self.assertEqual(entry.date_time, self.build_time.timetuple()[:6])
                    self.assertIn(struct.pack("<HHBI", 0x5455, 5, 1, int(self.build_time.timestamp())), entry.extra)
                else:
                    self.assertEqual((entry.date_time, entry.extra), (date, extra))
            self.assertIn(struct.pack("<HH2s", 0xCAFE, 2, b"ok"), archive.getinfo(self.script).extra)

    def test_next_export_advances_unchanged_helper_timestamp(self):
        self.write_archive()
        stamp_groovy_timestamps(self.archive, self.build_time)
        later = datetime(2026, 10, 15, 12, 0, 4, tzinfo=timezone.utc)
        stamp_groovy_timestamps(self.archive, later)
        with zipfile.ZipFile(self.archive) as archive:
            self.assertEqual(archive.getinfo(self.helper).date_time, later.timetuple()[:6])

    def test_missing_scripts_leaves_original_archive_intact(self):
        self.write_archive(scripts=False)
        original = self.archive.read_bytes()
        with self.assertRaisesRegex(ValueError, "no Groovy scripts"):
            stamp_groovy_timestamps(self.archive, self.build_time)
        self.assertEqual(self.archive.read_bytes(), original)
        self.assertEqual(list(Path(self.directory.name).iterdir()), [self.archive])


if __name__ == "__main__":
    unittest.main()
