public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1) return n; // Base case
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        System.out.println("Fibonacci(" + n + "): " + fibonacci(n));
    }
}
