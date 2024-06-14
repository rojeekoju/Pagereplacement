# Page Replacement Algorithms

This project implements three page-replacement algorithms: FIFO, LRU, and OPT. The algorithms are tested with specific reference strings and random page-reference strings.

##  Algorithms Performance
- **FIFO (First-In-First-Out)**: Replaces the oldest page. Its performance varied based on the reference string and page frame count.
- **LRU (Least Recently Used)**: Replaces the least recently used page. It performed well across all configurations.
- **OPT (Optimal)**: Replaces the page that will not be used for the longest time in the future.

# Best Performing Combination
The best combination was likely using LRU with 3 or 5 page frames. LRU's smart page replacement decisions based on recent accesses resulted in fewer page faults. 

# Big O Runtime Analysis
FIFO: Generally fast, but can be slower in worst-case scenarios.

LRU: Efficient most of the time with constant time operations, but managing access history adds some complexity.

OPT: Theoretically optimal but can be slower in practice due to scanning the entire reference string.