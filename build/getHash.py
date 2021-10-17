import hashlib
import sys

with open(sys.argv[1], "rb") as file:
    hash = hashlib.sha256(file.read()).hexdigest()
    print(hash)
