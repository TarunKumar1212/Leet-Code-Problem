import java.util.Stack;

class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    // Push an element into the queue
    public void push(int x) {
        st1.push(x);
    }

    // Pop the front element from the queue
    public int pop() {
        if (!st2.empty()) {  // Check if st2 has elements
            return st2.pop();
        } else {
            // Transfer elements from st1 to st2 to reverse the order
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
            return st2.pop();
        }
    }

    // Get the front element of the queue
    public int peek() {
        if (!st2.empty()) {  // If st2 has elements, return the top element
            return st2.peek();
        } else {
            // Transfer elements from st1 to st2 to reverse the order
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
            return st2.peek();
        }
    }

    // Check if the queue is empty
    public boolean empty() {
        // The queue is empty only if both stacks are empty
        return st1.empty() && st2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
