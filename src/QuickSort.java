import java.util.Arrays;

public class QuickSort {

    // Hàm phân vùng mảng theo pivot
    public static int partition(Student1[] arr, int low, int high) {
        // Chọn phần tử cuối làm pivot
        double pivot = arr[high].getMarks();
        int i = (low - 1); // chỉ số cho phần tử nhỏ hơn pivot

        // Duyệt qua các phần tử từ low đến high-1
        for (int j = low; j < high; j++) {
            // Nếu phần tử hiện tại nhỏ hơn hoặc bằng pivot
            if (arr[j].getMarks() <= pivot) {
                i++; // tăng chỉ số cho phần tử nhỏ hơn pivot
                // Đổi chỗ arr[i] và arr[j]
                Student1 temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Đổi phần tử pivot về đúng vị trí của nó
        Student1 temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Trả về chỉ số của pivot
        return i + 1;
    }

    // Hàm Quick Sort chính
    public static void quickSort(Student1[] arr, int low, int high) {
        if (low < high) {
            // Phân chia mảng thành 2 phần
            int pivotIndex = partition(arr, low, high);

            // Đệ quy sắp xếp 2 phần
            quickSort(arr, low, pivotIndex - 1);  // Sắp xếp phần bên trái của pivot
            quickSort(arr, pivotIndex + 1, high); // Sắp xếp phần bên phải của pivot
        }
    }
}
