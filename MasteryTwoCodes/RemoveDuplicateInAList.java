import java.util.*;

public class RemoveDuplicateInAList {
    static List<Integer> removeDuplicate(List<Integer> xs) {
        List<Integer> elements = new ArrayList<>(xs);
        Collections.sort(elements);
        List<Integer> out = new ArrayList<>();

        Integer prev = null;
        for (Integer elt : elements) {
            if (!elt.equals(prev)) {
                prev = elt;
                out.add(elt);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicate(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 9, 3, 5, 7, 2, 7, 69)));
    }

}
