import java.util.*;
import java.util.List;

public class MinOps {

    public static int minimumOps(List<Integer> S, List<Integer> T) {
        int count = 0;
        Set<List<Integer>> frontier = new HashSet<>(List.of(S));
        Set<List<Integer>> visited = new HashSet<>(List.of(S));

        while (!frontier.isEmpty()) {
            if (frontier.contains(T)) return count;
            frontier = nbrs(frontier);
            count++;
            frontier.removeAll(visited);
            visited.addAll(frontier);
        }
        return -1;
    }

    public static Set<List<Integer>> nbrs(Set<List<Integer>> F) {
        Set<List<Integer>> nbrSet = new HashSet<>();
        for (List<Integer> src : F) {
            nbrSet.add(rotate(src));
            nbrSet.add(reverse(src));
        }
        return nbrSet;
    }


    public static List<Integer> rotate(List<Integer> lst) {
        ArrayList<Integer> nlst = new ArrayList<>(lst);
        int lastIndex = lst.size()-1;
        int lastNumber = lst.get(lastIndex);
        nlst.remove(lastIndex);
        nlst.add(0, lastNumber);
        return nlst;
    }

    public static List<Integer> reverse(List<Integer> lst)
    {
        ArrayList<Integer> revArrayList = new ArrayList<Integer>();
        for (int i = lst.size() - 1; i >= 0; i--) {
            revArrayList.add(lst.get(i));
        }
        return revArrayList;
    }
    
    public static void main(String[] args) {
        MinOps minOps = new MinOps();
        List<Integer> l1 = List.of(1,2,3,4,5);
        List<Integer> l2 = List.of(2,1,5,4,3);
        List<Integer> l3 = List.of(1,5,4,3,2);
        List<Integer> l4 = List.of(1,2,3,4,5);
        List<Integer> l5 = List.of(5,4,3,2,1);
        System.out.println(l1 + " -> " + l1 + " :: " + minOps.minimumOps(l1,l1)); // 0
        System.out.println(l1 + " -> " + l2 + " :: " + minOps.minimumOps(l1,l2)); // 3
        System.out.println(l1 + " -> " + l3 + " :: " + minOps.minimumOps(l1,l3)); // 2
        System.out.println(l1 + " -> " + l4 + " :: " + minOps.minimumOps(l1,l4)); // 0
        System.out.println(l1 + " -> " + l5 + " :: " + minOps.minimumOps(l1,l5)); // 1
        System.out.println(l5 + " -> " + l3 + " :: " + minOps.minimumOps(l5,l3)); // 1


    }


}
