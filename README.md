# ExternalSorting

External sorting, also known as disk-based sorting, is an algorithm used to sort data sets that cannot fit entirely in the main memory of a system. When the size of the data set exceeds the capacity of RAM, external sorting techniques are employed to efficiently handle the sorting process.

External sorting involves dividing the data set into smaller blocks that can fit in the RAM and sorting them individually. These blocks are written to disk and then read back for merging and combining the sorted blocks until a fully sorted data set is obtained.

The process of external sorting includes multiple stages, including repeated reading and writing of data to disk. Techniques such as merge sort and polyphase sort are used to efficiently combine and merge the sorted blocks of data.

The main goal of external sorting is to minimize disk access and optimize the use of available resources to sort large data sets. It is particularly useful when working with large files or when the available RAM is limited compared to the size of the data to be sorted.
