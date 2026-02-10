import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class StatsPanelTest {

    private StatsPanel sp;

    @BeforeEach
    void setup() {
        sp = new StatsPanel();
    }

    @Test
    void emptyStats() {
        StatsFileMock sfm = new StatsFileMock(new TreeMap<>());
        ArrayList<Integer> binValues = sp.getBinValues(sfm);
        assertEquals(new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0)), binValues);
    }

    @Test
    void oneStat() {
        SortedMap<Integer, Integer> stats = new TreeMap<>();
        stats.put(5, 3);
        StatsFileMock sfm = new StatsFileMock(stats);
        ArrayList<Integer> binValues = sp.getBinValues(sfm);
        assertEquals(new ArrayList<>(Arrays.asList(0,0,3,0,0,0,0,0)), binValues);
    }

    @Test
    void multipleStats() {
        SortedMap<Integer, Integer> stats = new TreeMap<>();
        stats.put(1, 6);
        stats.put(15, 8);
        stats.put(20, 2);
        stats.put(7, 9);
        StatsFileMock sfm = new StatsFileMock(stats);
        ArrayList<Integer> binValues = sp.getBinValues(sfm);
        assertEquals(new ArrayList<>(Arrays.asList(6,0,0,9,0,0,0,8)), binValues);
    }
}
