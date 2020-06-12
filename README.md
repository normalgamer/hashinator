# Hashinator
An executable jar that generates a file's MD5, SHA-1 and CRC32 checksums. It takes 30 seconds on a 1.35Gb file.

## Changelog
* V1.3: CRC32 only shows relevant 8 bytes, it used to output 8 zero-bytes at the beginning of the hash

* V1.2: Reduced computing time on a 1.35Gb file from 2:06 to 0:30 by calculating all three hashes at the same time instead of opening the file and calculating the hashes one-by-one

* V1.1b: Changed the number version of the jar

* V1.1: Hashinator can now generate SHA-1 and CRC32 hash, though the last one has lots of zero-bytes at the beginning

* V1.0: Hashinator can generate MD5 hash, SHA-1 is disabled
