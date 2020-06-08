# Hashinator
An executable jar that generates a file's MD5, SHA-1 and CRC32 checksums. It takes 2.06 minutes30 seconds on a 1.35Gb file.

## Changelog
V.12: Reduced computing time on a 1.35Gb file from 2:06 minutes to 0:30 by calculating all three hashes at the same time instead of opening the file and calculating the hashes one-by-one

V1.1b: Changed the number version of the jar

V1.1: Hashinator can now generate SHA-1 and CRC32 hash, though the last one has lots of zero-bytes at the beginning

V1.0: Hashinator can generate MD5 hash, SHA-1 is disabled
