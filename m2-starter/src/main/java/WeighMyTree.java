public class WeighMyTree {
    public static long weigh(int[] a) {
        return weighHelper(a,1, 1);
    }

    public static long weighHelper(int[] a, int index,   int level ) {
        if (index >= a.length) return 0;
        long left = weighHelper(a, index * 2,level+1);
        long right = weighHelper(a, index * 2+1, level+1);
        return (long) a[index] *level + left + right ;
    }

    public static void main(String[] args) {
        int[] test0 = {0, 1, 2, 3};
        int[] test1 = {0, 1, 5, 3, 7};
        int[] test2 = {0, 7, 9, 3, 5};
        int[] test3 = {0, 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 7, 7, 2};
        int[] test4 = new int[50_000_000];
        long a0 = 11;
        long a1 = 38;
        long a2 = 46;
        long a3 = 204;
        long a4 = 31749399445659349L;
        for (int i=0;i<test4.length;i++) test4[i] = i;
        WeighMyTree wmt = new WeighMyTree();
        long start = System.nanoTime();
        System.out.println(wmt.weigh(test0)==a0);
        System.out.println(wmt.weigh(test1)==a1);
        System.out.println(wmt.weigh(test2)==a2);
        System.out.println(wmt.weigh(test3)==a3);
        System.out.println(wmt.weigh(test4)==a4);
        long finish = System.nanoTime();
        System.out.printf("Took: %d millisecond(s).\n", (finish - start)/1_000_000);
    }
}
