import java.util.*;

class UndirectedAdjMap<Vertex> {
    Map<Vertex, Set<Vertex>> graph;
    int edges;

    public UndirectedAdjMap() {
        this.graph = new HashMap<>();
        this.edges = 0;
    }


    public int numEdges() {
        return edges;
    }

    public int numVertices() {
        return graph.size();
    }

    public int deg(Vertex v) {
        return graph.get(v).size();
    }

    public Iterable<Vertex> adj(Vertex v) {
        return graph.get(v);
    }

    public boolean isEdge(Vertex u, Vertex v) {
        return graph.get(u).contains(v);
    }

    public void addVertex(Vertex v) {
        graph.put(v, new HashSet<>());
    }

    public void addEdge(Vertex u, Vertex v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
        edges++;
    }


    public Map<Vertex, Vertex> nbrs(UndirectedAdjMap<Vertex> G,
                                    Set<Vertex> F) {
        Map<Vertex, Vertex> nbrSet = new HashMap<>();
        for (Vertex src : F) {
            for (Vertex dst : G.adj(src))
                nbrSet.put(dst, src);
        }
        return nbrSet;
    }

    public Map<Vertex, Vertex> bfs(UndirectedAdjMap<Vertex> G, Vertex s) {
        Map<Vertex, Vertex> frontier = new HashMap<>();
        Map<Vertex, Vertex> visited = new HashMap<>();
        frontier.put(s, null);
        visited.put(s, null);
        while (!frontier.isEmpty()) {
            // frontier = N(frontier) //adj(frontier)
            frontier = nbrs(G, frontier.keySet());
            // frontier = frontier - visited
            frontier.keySet().removeAll(visited.keySet());
            // put in new frontiers into visited
            visited.putAll(frontier);
        }
        return visited;
    }
}