import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1; // Primary stack for push operation
    private Stack<Integer> stack2; // Secondary stack for pop and peek operation

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean push(int x) {
        stack1.push(x);
        return false;
    }

    public int pop() {
        if (stack2.isEmpty()) {
            transferElements();
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            transferElements();
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void transferElements() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        System.out.println(myQueue.push(1)); // Output: null
        System.out.println(myQueue.push(2)); // Output: null

        System.out.println(myQueue.peek()); // Output: 1

        System.out.println(myQueue.pop()); // Output: 1

        System.out.println(myQueue.empty()); // Output: false
    }
}
