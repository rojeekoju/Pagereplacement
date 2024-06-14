import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplacementAlgorithmTest {

    @Test
    public void testFIFO() {
        int[] referenceString = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        FIFO fifo = new FIFO(3);
        for (int page : referenceString) {
            fifo.insert(page);
        }
        assertEquals(15, fifo.getPageFaultCount());
    }

    @Test
    public void testLRU() {
        int[] referenceString = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        LRU lru = new LRU(3);
        for (int page : referenceString) {
            lru.insert(page);
        }
        assertEquals(12, lru.getPageFaultCount());
    }

    @Test
    public void testOPT() {
        int[] referenceString = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        OPT opt = new OPT(3, toList(referenceString));
        for (int page : referenceString) {
            opt.insert(page);
        }
        assertEquals(9, opt.getPageFaultCount());
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }
}
