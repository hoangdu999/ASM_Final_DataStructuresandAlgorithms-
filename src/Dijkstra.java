import java.util.*;

class Dijkstra {
    // Hàm tìm đỉnh có chi phí nhỏ nhất trong các đỉnh chưa được kiểm tra
    public static int minDistance(int[] dist, boolean[] visited, int V) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Hàm cài đặt Dijkstra's Algorithm
    public static void dijkstra(int graph[][], int src, int V) {
        int[] dist = new int[V];  // Mảng lưu chi phí từ nguồn đến các đỉnh
        boolean[] visited = new boolean[V]; // Mảng kiểm tra xem đỉnh đã được kiểm tra chưa

        // Khởi tạo tất cả các chi phí ban đầu là vô hạn và tất cả các đỉnh chưa được kiểm tra
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Lặp qua các đỉnh
        for (int count = 0; count < V - 1; count++) {
            // Lấy đỉnh có chi phí nhỏ nhất từ các đỉnh chưa kiểm tra
            int u = minDistance(dist, visited, V);
            visited[u] = true;

            // Cập nhật chi phí cho các đỉnh kề của đỉnh u
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // In kết quả
        printSolution(dist, V);
    }

    // Hàm in kết quả
    public static void printSolution(int[] dist, int V) {
        System.out.println("Độ dài đường đi ngắn nhất từ nguồn đến các đỉnh:");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Đỉnh " + i + ": Không thể tiếp cận");
            } else {
                System.out.println("Đỉnh " + i + ": " + dist[i]);
            }
        }
    }
}
