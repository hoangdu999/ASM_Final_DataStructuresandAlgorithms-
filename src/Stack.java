import java.util.EmptyStackException;

public class Stack {
    private Student1[] elements;
    private int top;
    private int maxSize;

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        this.maxSize = size;
        this.elements = new Student1[maxSize];
        this.top = -1; // Indicates an empty stack
    }

    // Push a student onto the stack
    public void push(Student1 student) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot push student.");
        } else {
            elements[++top] = student;
        }
    }

    // Pop a student from the stack
    public Student1 pop() {
        if (top == -1) {
            throw new EmptyStackException();
        } else {
            return elements[top--];
        }
    }

    // Peek the top student in the stack
    public Student1 peek() {
        if (top == -1) {
            throw new EmptyStackException();
        } else {
            return elements[top];
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Update student details in the stack
    public void updateStudent(int id, Student1 newStudent) {
        for (int i = 0; i <= top; i++) {
            if (elements[i].getId() == id) {
                elements[i] = newStudent;
                break;
            }
        }
    }

    // Print all students in the stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(elements[i]);
        }
    }
    public void clearStack() {
        this.top = -1; // Reset the stack to be empty
        System.out.println("Stack has been cleared.");
    }
}
