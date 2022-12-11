import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kruskals {
    static class DisjointSet {
        private final int[] p;
        private final int[] sz;

        DisjointSet(int n) {
            this.p = new int[n];
            this.sz = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i; // establish the   roots, points to itself
                sz[i] = 1; // establish size of each root which is 1.
            }
        }

        public void link(int x, int y) {
            int rootX = root(x), rootY = root(y);
            if (sz[rootX] <= sz[rootY]) {
                p[rootX] = rootY;
                sz[rootY] += sz[rootX];
            } else {
                p[rootY] = rootX;
                sz[rootX] += sz[rootY];
            }
        }


        boolean isConnected(int x, int y) {
            return root(x) == root(y);
        }

        int root(int x) {
            while (p[x] != x) {
                x = p[x];
            }
            return x;
        }
    }

    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        ArrayList<List<Integer>> map = new ArrayList<>();
        int totalCost = 0;
        for (int i = 0; i < gWeight.size(); i++) {
            map.add(Arrays.asList(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }
        map.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                Integer weight1 = o1.get(2);
                Integer weight2 = o2.get(2);
                return weight1.compareTo(weight2);
            }
        });

        DisjointSet disjointSets = new DisjointSet(gNodes + 1);
        for (List<Integer> lst : map) {
            int x = lst.get(0);
            int y = lst.get(1);
            int weight = lst.get(2);
            if (!disjointSets.isConnected(x, y)) {
                disjointSets.link(x, y);
                totalCost += weight;
            }
        }
        return totalCost;
    }
}
