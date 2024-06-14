import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OPT (Optimal) page replacement algorithm.
 * Extends the abstract class ReplacementAlgorithm.
 */
public class OPT extends ReplacementAlgorithm {
    // List to hold the current pages in memory.
    private List<Integer> pages;
    // Index to track the current position in the reference string.
    private int currentIndex;
    // List to hold the reference string.
    private List<Integer> referenceString;

    /**
     * Constructor for OPT class.
     * Initializes the list of pages, the reference string, and sets the number of page frames.
     *
     * @param pageFrameCount  - the number of physical page frames.
     * @param referenceString - the reference string used for optimal replacement.
     */
    public OPT(int pageFrameCount, List<Integer> referenceString) {
        super(pageFrameCount);
        pages = new ArrayList<>();
        this.referenceString = referenceString;
        this.currentIndex = 0;
    }

    /**
     * Inserts a page number into the memory.
     * If the page is not already in memory and the memory is full,
     * the page that will not be used for the longest period of time is replaced.
     * Increments the page fault count if a new page is added.
     *
     * @param pageNumber - the page number to be inserted.
     */
    @Override
    public void insert(int pageNumber) {
        // Check if the page is not already in memory.
        if (!pages.contains(pageNumber)) {
            // If the memory is full, replace the page that will not be used for the longest period of time.
            if (pages.size() == pageFrameCount) {
                int farthest = findFarthestPage();
                pages.set(farthest, pageNumber);
            } else {
                // If the memory is not full, simply add the new page.
                pages.add(pageNumber);
            }
            // Increment the page fault count as a new page is added.
            pageFaultCount++;
        }
        // Move to the next position in the reference string.
        currentIndex++;
    }

    /**
     * Finds the page that will not be used for the longest period of time.
     *
     * @return the index of the page to be replaced.
     */
    private int findFarthestPage() {
        // Map to store the distance of each page from the current position in the reference string.
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < pages.size(); i++) {
            distanceMap.put(pages.get(i), Integer.MAX_VALUE);
        }

        // Update the distance of each page based on its next occurrence in the reference string.
        for (int i = currentIndex + 1; i < referenceString.size(); i++) {
            if (distanceMap.containsKey(referenceString.get(i)) && distanceMap.get(referenceString.get(i)) == Integer.MAX_VALUE) {
                distanceMap.put(referenceString.get(i), i);
            }
        }

        // Find the page with the farthest distance (or the page that will not be used for the longest period of time).
        int farthest = 0;
        int farthestIndex = -1;

        for (Map.Entry<Integer, Integer> entry : distanceMap.entrySet()) {
            if (entry.getValue() > farthestIndex) {
                farthestIndex = entry.getValue();
                farthest = pages.indexOf(entry.getKey());
            }
        }

        return farthest;
    }
}
