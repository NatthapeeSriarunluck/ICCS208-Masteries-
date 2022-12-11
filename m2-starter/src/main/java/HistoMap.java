import java.util.*;

public class HistoMap {
    public Long fetchRank(TreeMap<Long, Integer> h, long k) {
        if (h.isEmpty()) {
            return null;
        }
        int count = 0;
        for (Map.Entry<Long, Integer> entry : h.entrySet()) {
            count += entry.getValue();
            if (k < count) return entry.getKey();
        }
        return null;
    }
    public static void main(String[] args) {
        HistoMap histoMap = new HistoMap();
        TreeMap<Long, Integer> example0 = new TreeMap<>(Map.of(1L, 1, 4L, 2, 9L, 3));
        // 1 4 4 9 9 9
        long[] testInput0 = {0L, 1L, 2L, 3L, 4L, 5L, 6L};
        Long[] expected0 =  {1L, 4L, 4L, 9L, 9L, 9L, null};
        int count = 0;
        for (int i=0;i<testInput0.length;i++) {
            Long yourAns = histoMap.fetchRank(example0, testInput0[i]);
            System.out.printf("fetchRank(example0, %d) => %s (expected: %s)\n", testInput0[i], yourAns, expected0[i]);
            count += (yourAns == expected0[i])?1:0;
        }
        System.out.printf("Passed %d/%d cases.\n", count, testInput0.length);
    }
}
