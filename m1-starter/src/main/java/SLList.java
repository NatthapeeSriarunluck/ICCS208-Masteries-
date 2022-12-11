import java.sql.Array;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.Arrays;

public class SLList<T> {
    // an inner storage node class
    private class Node {
        T head;
        Node next;
        Node(T head, Node next) {
            this.head = head;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public SLList() { sentinel = new Node(null, null); size = 0; }
    public SLList(List<T> existing) {
        this();
        Node p = sentinel;
        for (T elt: existing) {
            p.next = new Node(elt, null);
            p = p.next; size++;
        }
    }

    // return the first item of the list
    public T getFirst() {
        return sentinel.next.head;
    }

    public T[] toArray() {
        Node current = sentinel;
        //T[] ans = ;
        while (sentinel.next != null)
        return null;
        return null;
    }


    public void deleteIf(Predicate<T> p) {
        // TODO: write me
    }

    public SLList<T> reversed() {
        // TODO: write me
        return null;
    }

    public int size() { return size; }

    static class BanA implements Predicate<String> {
        public boolean test(String t) { return t.equals("a"); }
    }

    public static void main(String[] args) {
        SLList<String> list1 = new SLList<>(List.of("J", "a", "v", "a", "S", "E"));
        SLList<String> list2 = new SLList<>(List.of("J", "a", "v", "a", "S", "E"));

        System.out.println(Arrays.toString(list1.toArray()));    // should print [J, a, v, a, S, E]

        list1.deleteIf((String e) -> e.equals(e.toUpperCase()));
        System.out.println(Arrays.toString(list1.toArray()));
        // list1 should become [a, v, a]
        list2.deleteIf(new BanA());
        System.out.println(Arrays.toString(list2.toArray()));
        // list2 should become [J, v, S, E]
        SLList<String> list3 = list2.reversed();
        System.out.println(Arrays.toString(list3.toArray()));
        // list3 is  [E, S, v, J]
    }
}
