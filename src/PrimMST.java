import java.util.*;

class PrimMST {

    // Hàm tìm cây khung nhỏ nhất (MST) của đồ thị sử dụng thuật toán Prim
    public static void primMST(int graph[][], int V) {
        // Mảng lưu chi phí của các đỉnh
        int[] key = new int[V];

        // Mảng lưu các đỉnh đã có trong MST
        boolean[] mstSet = new boolean[V];

        // Mảng lưu đỉnh cha của mỗi đỉnh trong MST
        int[] parent = new int[V];

        // Khởi tạo tất cả các chi phí là vô hạn và các đỉnh chưa được thêm vào MST
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Chọn đỉnh đầu tiên làm đỉnh bắt đầu
        key[0] = 0;
        parent[0] = -1; // Đỉnh đầu tiên không có cha

        // Duyệt qua tất cả các đỉnh
        for (int count = 0; count < V - 1; count++) {
            // Chọn đỉnh có chi phí nhỏ nhất từ tập các đỉnh chưa được thêm vào MST
            int u = minKey(key, mstSet, V);

            // Đánh dấu đỉnh u đã được thêm vào MST
            mstSet[u] = true;

            // Cập nhật chi phí và cha của các đỉnh kề
            for (int v = 0; v < V; v++) {
                // Nếu v chưa được thêm vào MST và có một cạnh nối từ u đến v
                // và chi phí của cạnh đó nhỏ hơn chi phí hiện tại của v
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // In kết quả cây khung nhỏ nhất (MST)
        printMST(parent, graph, V);
    }

    // Hàm tìm đỉnh có chi phí nhỏ nhất trong tập các đỉnh chưa được thêm vào MST
    public static int minKey(int[] key, boolean[] mstSet, int V) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Hàm in cây khung nhỏ nhất (MST)
    public static void printMST(int[] parent, int graph[][], int V) {
        System.out.println("Cây khung nhỏ nhất (MST):");
        for (int i = 1; i < V; i++) {
            System.out.println("Đỉnh " + parent[i] + " - Đỉnh " + i + ": " + graph[i][parent[i]]);
        }
    }


}
