import java.math.BigInteger;
import java.util.Arrays;

public class DevilSpect {
    public static int[] spectrum(int k) {
        int[] ans = new int[10];
        BigInteger seven = new BigInteger("7");
        BigInteger num = seven.pow(k);
        String loop = num.toString();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < loop.length(); j++) {
                if (i == Character.getNumericValue(loop.charAt(j))) {
                    ans[i] += 1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] testCases = {7, 99, 123, 208, 1502};
        int[][] expectedAnswers = {
                {0, 0, 1, 2, 1, 1, 0, 0, 1, 0},
                {10, 4, 11, 8, 9, 13, 7, 6, 9, 7},
                {9, 12, 9, 13, 11, 9, 9, 9, 13, 10},
                {15, 31, 16, 14, 17, 19, 17, 18, 12, 17},
                {127, 132, 129, 110, 142, 148, 119, 129, 122, 112}
        };
        for (int index = 0; index < testCases.length; index++) {
            int[] yourAnswer = spectrum(testCases[index]);
            System.out.printf("tease(%d) ==> %s", testCases[index], Arrays.toString(yourAnswer));
            String verdict = Arrays.equals(expectedAnswers[index], yourAnswer) ? "ok" : "nope";
            System.out.printf(" -- [%s]\n", verdict);
        }


        System.out.println(Arrays.toString(spectrum(7))); // [0, 0, 1, 2, 1, 1, 0, 0, 1, 0]
        System.out.println(Arrays.toString(spectrum(99))); // [10, 4, 11, 8, 9, 13, 7, 6, 9, 7]
        System.out.println(Arrays.toString(spectrum(123))); // [9, 12, 9, 13, 11, 9, 9, 9, 13, 10]
        System.out.println(Arrays.toString(spectrum(208))); // [15, 31, 16, 14, 17, 19, 17, 18, 12, 17]
        System.out.println(Arrays.toString(spectrum(1502))); // [127, 132, 129, 110, 142, 148, 119, 129, 122, 112]

    }
}
