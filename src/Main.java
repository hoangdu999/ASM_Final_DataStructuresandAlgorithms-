
//import java.lang.classfile.instruction.SwitchCase;
import java.util.*;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        // Test 1: Stack Overflow
        try {
            Stack stack = new Stack(2);
            stack.push(1);
            stack.push(2);
            stack.push(3); // Exceeds capacity
        } catch (StackOverflowError e) {
            System.out.println("Test 1 Passed: " + e.getMessage());
        }

        // Test 2: Stack Underflow
        try {
            Stack stack = new Stack(2);
            stack.pop(); // Empty stack
        } catch (RuntimeException e) {
            System.out.println("Test 2 Passed: " + e.getMessage());
        }

        // Test 3: Invalid Stack Size
        try {
            Stack invalidStack = new Stack(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 Passed: " + e.getMessage());
        }

        // Test 4: Peek on Empty Stack
        try {
            Stack stack = new Stack(2);
            stack.peek(); // Empty stack
        } catch (RuntimeException e) {
            System.out.println("Test 4 Passed: " + e.getMessage());
        }



    }

}
