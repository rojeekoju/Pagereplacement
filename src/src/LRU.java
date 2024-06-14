import java.util.LinkedHashMap;

/**
 * @author rosie
 * LRU (Least Recently Used) page replacement algorithm.
 * Extends the abstract class ReplacementAlgorithm.
 */
public class LRU extends ReplacementAlgorithm {
    // LinkedHashMap to hold the page numbers and maintain access order.
    private LinkedHashMap<Integer, Integer> cache;

    /**
     * Constructor for LRU class.
     * Initializes the LRU cache and sets the number of page frames.
     *
     * @param pageFrameCount - the number of physical page frames.
     */
    public LRU(int pageFrameCount) {
        super(pageFrameCount);
        // The third parameter `true` specifies that the LinkedHashMap should maintain access order.
        cache = new LinkedHashMap<>(pageFrameCount, 0.75f, true);
    }

    /**
     * Inserts a page number into the LRU cache.
     * If the page is not already in the cache and the cache is full,
     * the least recently used page (first entry in the LinkedHashMap) is removed.
     * Increments the page fault count if a new page is added.
     *
     * @param pageNumber - the page number to be inserted.
     */
    @Override
    public void insert(int pageNumber) {
        // Check if the page is not already in the cache.
        if (!cache.containsKey(pageNumber)) {
            // If the cache is full, remove the least recently used page.
            if (cache.size() == pageFrameCount) {
                // The least recently used page is the first entry in the LinkedHashMap.
                int lru = cache.keySet().iterator().next();
                cache.remove(lru);
            }
            // Increment the page fault count as a new page is added.
            pageFaultCount++;
        }
        // Add the new page to the cache or update its access order.
        cache.put(pageNumber, pageNumber);
    }
}
