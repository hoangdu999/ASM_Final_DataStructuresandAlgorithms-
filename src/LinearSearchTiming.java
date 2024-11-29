import java.util.Random;

public class LinearSearchTiming {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        // Tạo mảng ngẫu nhiên kích thước lớn
        int size = 1_000_000; // 1 triệu phần tử
        int[] array = new Random().ints(size, 0, 10_000_000).toArray();
        int target = array[size - 1]; // Chọn phần tử cuối cùng làm mục tiêu

        // Đo thời gian chạy
        long startTime = System.nanoTime();
        int result = linearSearch(array, target);
        long endTime = System.nanoTime();

        // Hiển thị kết quả
        System.out.println("Target found at index: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
    }
}
