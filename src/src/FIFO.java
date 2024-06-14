import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rosie
 * FIFO (First-In-First-Out) page replacement algorithm.
 * Extends the abstract class ReplacementAlgorithm.
 */
public class FIFO extends ReplacementAlgorithm {
    // Queue to hold the page numbers in the order they were added.
    private Queue<Integer> queue;

    /**
     * Constructor for FIFO class.
     * Initializes the FIFO queue and sets the number of page frames.
     *
     * @param pageFrameCount - the number of physical page frames.
     */
    public FIFO(int pageFrameCount) {
        super(pageFrameCount);
        queue = new LinkedList<>();
    }

    /**
     * Inserts a page number into the FIFO queue.
     * If the page is not already in the queue and the queue is full,
     * the oldest page (head of the queue) is removed.
     * Increments the page fault count if a new page is added.
     *
     * @param pageNumber - the page number to be inserted.
     */
    @Override
    public void insert(int pageNumber) {
        // Check if the page is not already in the queue.
        if (!queue.contains(pageNumber)) {
            // If the queue is full, remove the oldest page.
            if (queue.size() == pageFrameCount) {
                queue.poll();
            }
            // Add the new page to the queue.
            queue.add(pageNumber);
            // Increment the page fault count as a new page is added.
            pageFaultCount++;
        }
    }
}
