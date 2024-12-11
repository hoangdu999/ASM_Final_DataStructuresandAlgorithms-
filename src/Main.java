import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Tạo danh sách sinh viên giả lập
        List<Student1> Liststudents = generateFakeStudents(10000);

        // Chuyển Liststudents thành mảng để sử dụng trong QuickSort và MergeSort
        Student1[] stackArray1 = Liststudents.toArray(new Student1[0]);
        Student1[] stackArray2 = Liststudents.toArray(new Student1[0]);

        // Tạo một stack với dung lượng tối đa 10000 sinh viên
        Stack stack = new Stack(10000);
        Stack stack2 = new Stack(10000);

        // Thêm tất cả sinh viên vào stack
        for (Student1 student : Liststudents) {
            stack.push(student); // Thêm từng sinh viên vào stack
        }
        for (Student1 student : Liststudents) {
            stack2.push(student); // Thêm từng sinh viên vào stack2
        }

        // In danh sách sinh viên trước khi sắp xếp
//        System.out.println("Students before sorting:");
//        System.out.println("Stack:");
//        stack.printStack();
//        System.out.println("Stack2:");
//        stack2.printStack();

        // QuickSort: Đo thời gian sắp xếp
        long startTime = System.nanoTime();
        QuickSort.quickSort(stackArray1, 0, stackArray1.length - 1);
        long endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;
        System.out.println("QuickSort time: " + quickSortTime + " nanoseconds");

        // MergeSort: Đo thời gian sắp xếp
        startTime = System.nanoTime();
        MergeSort.mergeSort(stackArray2, 0, stackArray2.length - 1);
        endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;
        System.out.println("MergeSort time: " + mergeSortTime + " nanoseconds");

        // In danh sách sinh viên sau khi sắp xếp
//        System.out.println("\nStudents after QuickSort (stack):");
//        for (Student1 student : stackArray1) {
//            System.out.println(student);
//        }
//
//        System.out.println("\nStudents after MergeSort (stack2):");
//        for (Student1 student : stackArray2) {
//            System.out.println(student);
//        }

        // In ra thời gian sắp xếp
        if (quickSortTime < mergeSortTime) {
            System.out.println("\nQuickSort is faster.");
        } else if (quickSortTime > mergeSortTime) {
            System.out.println("\nMergeSort is faster.");
        } else {
            System.out.println("\nBoth sorting algorithms have the same performance.");
        }
    }

    // Phương thức tạo sinh viên giả lập
    public static List<Student1> generateFakeStudents(int count) {
        List<Student1> students = new ArrayList<>();
        Random random = new Random();

        // Tạo ngẫu nhiên sinh viên
        for (int i = 1; i <= count; i++) {
            int id = i;
            String name = "Student " + i;
            String contactNumber = "090" + String.format("%08d", random.nextInt(100000000));
            double marks = 5 + random.nextDouble() * 5; // Điểm ngẫu nhiên từ 5.0 đến 10.0

            Student1 student = new Student1(id, name, contactNumber, marks);
            students.add(student);
        }

        return students;
    }
}
