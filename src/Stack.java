import java.util.EmptyStackException;
public class Stack {
    private int[] elements;
    private int top;
    private int maxSize;

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        this.maxSize = size;
        this.elements = new int[maxSize];
        this.top = -1; // Indicates an empty stack
    }
    public void push(int element) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push element.");
        } else {
            elements[++top] = element;
        }
    }
    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        } else {
            return elements[top--];
        }
    }
    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        } else {
            return elements[top];
        }
    }
    public boolean isEmpty() {
        return top == -1;
    }

}
