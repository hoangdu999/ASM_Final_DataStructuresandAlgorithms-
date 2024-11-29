class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {
    private Node front;
    private Node rear;

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            int temp = front.data;
            front = front.next;
            if (front == null) {
                rear = null;  // If the queue is empty, reset rear
            }
            return temp;
        }
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return front.data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}
