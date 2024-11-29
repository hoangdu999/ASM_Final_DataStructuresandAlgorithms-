import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<int[]>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        adjList[src].add(new int[]{dest, weight});
    }

    public void dijkstra(int start) {
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int vertex = current[0];
            int distance = current[1];

            if (distance > distances[vertex]) continue;

            for (int[] neighbor : adjList[vertex]) {
                int neighborVertex = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = distances[vertex] + edgeWeight;

                if (newDist < distances[neighborVertex]) {
                    distances[neighborVertex] = newDist;
                    pq.offer(new int[]{neighborVertex, newDist});
                }
            }
        }

        System.out.println("Shortest distances from vertex " + start + ": " + Arrays.toString(distances));
    }
}
