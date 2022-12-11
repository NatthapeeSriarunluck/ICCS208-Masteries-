public class DisjointSet {
    int[] p;
    int[] sz;

    DisjointSet(int n) {
        p = new int[n];
        sz = new int[n];
        for (int k = 0; k < n; k++) {
            p[k] = k;
            sz[k] = 1;
        }
    }

    int root(int x) {
        while (p[x] != x) {
            x = p[x];
        }
        return x;
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
}