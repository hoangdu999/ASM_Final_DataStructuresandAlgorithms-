public class StackEH {
    private int[] array;
    private int top;
    private int capacity;

    public StackEH(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be positive");
        }
        if (size > 1000000) { // Set a reasonable upper limit for stack size
            throw new IllegalArgumentException("Stack size too large. Max size allowed: 1,000,000");
        }
        array = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int value) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack overflow: cannot push " + value);
        }
        array[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow: cannot pop from empty stack");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty: cannot peek");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }


}
