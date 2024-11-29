 class QueueExample {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: "
                + queue.peekFront());  // Output: 10

        // Dequeue elements
        queue.dequeue();  // Removes 10
        System.out.println("Front element after dequeue: "
                + queue.peekFront());  // Output: 20

        // Add more elements
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);  // Queue is now full

        // Try dequeuing again
        queue.dequeue();  // Removes 20
        System.out.println("Front element after second dequeue: "
                + queue.peekFront());  // Output: 30
    }
}
