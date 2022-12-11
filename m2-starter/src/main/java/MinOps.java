import java.util.*;
import java.util.List;

public class MinOps {
    static class UndirectedAdjMap<Vertex> {
        Map<Vertex, Set<Vertex>> graph;
        int edges;

        public UndirectedAdjMap() {
            this.graph = new HashMap<>();
            this.edges = 0;
        }

        public Iterable<Vertex> adj(Vertex v) {
            return graph.get(v);
        }


        public void addVertex(Vertex v) {
            graph.put(v, new HashSet<>());
        }

        public void addEdge(Vertex u, Vertex v) {
            graph.get(u).add(v);
            graph.get(v).add(u);
            edges++;
        }

        public void removeEdge(Vertex u, Vertex v) {
            graph.remove(u);
            graph.remove(v);
        }
    }

    UndirectedAdjMap<ArrayList<Integer>> graph = new UndirectedAdjMap<>();

    public int minimumOps(List<Integer> S, List<Integer> T) {
        ArrayList<Integer> s = new ArrayList<>(S);
        ArrayList<Integer> t = new ArrayList<>(T);
        HashSet<ArrayList<Integer>> allSequence = new HashSet<>();
        HashSet<ArrayList<Integer>> currentLayer = new HashSet<>();
        currentLayer.add(s);
        for (ArrayList<Integer>current : currentLayer) {
            graph.addVertex(current);

            ArrayList<Integer> rotate = rotate(current);
            ArrayList<Integer> reverse = reverse(current);

            graph.addVertex(rotate);  allSequence.add(rotate); graph.addEdge(current,rotate);
            graph.addVertex(reverse); allSequence.add(reverse); graph.addEdge(current, reverse);
            if (allSequence.contains(t)){ break;}
            current.clear();
            currentLayer.add(rotate); currentLayer.add(reverse);
        }
        int count = 0;
        Set<ArrayList<Integer>> frontier = new HashSet<>(List.of(s));
        Set<ArrayList<Integer>> visited = new HashSet<>(List.of(s));

        while (!frontier.isEmpty()) {
            if (frontier.contains(t)) return count;
            frontier = nbrs(graph, frontier);
            count++;
            frontier.removeAll(visited);
            visited.addAll(frontier);
        }
        return -1;
    }

    Set<ArrayList<Integer>> nbrs(UndirectedAdjMap<ArrayList<Integer>> G, Set<ArrayList<Integer>> F) {
        Set<ArrayList<Integer>> nbrSet = new HashSet<>();
        for (ArrayList<Integer> src : F) {
            // function to find adj vertex to the source
            for (ArrayList<Integer> dst : G.adj(src)) {
                nbrSet.add(dst);
            }
        }
        return nbrSet;
    }


    public static ArrayList<Integer> rotate(ArrayList<Integer> lst) {
        ArrayList<Integer> nlst = new ArrayList<>(lst);
        System.out.println(nlst.size());
        System.out.println(nlst);
        int lastIndex = lst.size()-1;
        int lastNumber = lst.get(lastIndex);
        nlst.remove(lastIndex);
        nlst.add(0, lastNumber);
        return nlst;
    }

    public static ArrayList<Integer> reverse(ArrayList<Integer> lst)
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
