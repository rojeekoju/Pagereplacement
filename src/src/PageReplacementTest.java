import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author rosie
 * Test class for different page replacement algorithms.
 */
public class PageReplacementTest {
    public static void main(String[] args) {
        // Three example reference strings for testing the algorithms.
        int[] referenceString1 = {7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1};
        int[] referenceString2 = {8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3};
        int[] referenceString3 = {4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4};

        // Array containing the reference strings to test.
        int[][] testStrings = {referenceString1, referenceString2, referenceString3};

        // Test the algorithms with the provided reference strings and a page frame count of 3.
        testAlgorithms(testStrings, 3);

        // Generate and test random reference strings with different page frame counts.
        generateAndTestRandomStrings(15, new int[]{3, 5, 7});
    }

    /**
     * Tests the FIFO, LRU, and OPT algorithms with the given reference strings and page frame count.
     *
     * @param testStrings     - array of reference strings.
     * @param pageFrameCount  - the number of page frames.
     */
    private static void testAlgorithms(int[][] testStrings, int pageFrameCount) {
        for (int[] referenceString : testStrings) {
            // Test FIFO algorithm.
            testAlgorithm(new FIFO(pageFrameCount), referenceString);
            // Test LRU algorithm.
            testAlgorithm(new LRU(pageFrameCount), referenceString);
            // Test OPT algorithm.
            testAlgorithm(new OPT(pageFrameCount, toList(referenceString)), referenceString);
        }
    }

    /**
     * Runs a given page replacement algorithm with a reference string and prints the page fault count.
     *
     * @param algorithm        - the page replacement algorithm to test.
     * @param referenceString  - the reference string.
     */
    private static void testAlgorithm(ReplacementAlgorithm algorithm, int[] referenceString) {
        for (int page : referenceString) {
            // Insert each page number from the reference string into the algorithm.
            algorithm.insert(page);
        }
        // Print the algorithm's class name and the total page fault count.
        System.out.println(algorithm.getClass().getSimpleName() + " - Page Faults: " + algorithm.getPageFaultCount());
    }

    /**
     * Generates random reference strings and tests the page replacement algorithms with them.
     *
     * @param referenceStringSize - the size of the random reference strings.
     * @param pageFrameCounts     - array of different page frame counts to test.
     */
    private static void generateAndTestRandomStrings(int referenceStringSize, int[] pageFrameCounts) {
        Random random = new Random();
        for (int pageFrameCount : pageFrameCounts) {
            int[] randomString = new int[referenceStringSize];
            // Generate a random reference string.
            for (int i = 0; i < referenceStringSize; i++) {
                randomString[i] = random.nextInt(10); // Random page numbers between 0 and 9.
            }
            System.out.println("Random String - Page Frames: " + pageFrameCount);
            // Test FIFO algorithm with the random reference string.
            testAlgorithm(new FIFO(pageFrameCount), randomString);
            // Test LRU algorithm with the random reference string.
            testAlgorithm(new LRU(pageFrameCount), randomString);
            // Test OPT algorithm with the random reference string.
            testAlgorithm(new OPT(pageFrameCount, toList(randomString)), randomString);
        }
    }

    /**
     * Converts an array of integers to a list of integers.
     *
     * @param array - the array to convert.
     * @return a list containing the elements of the array.
     */
    private static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }
}
