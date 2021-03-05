import java.util.Stack;

class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!input.empty()) {
            output.push(input.pop());
        }
        int pop = output.pop();
        while (!output.empty()) {
            input.push(output.pop());
        }
        return pop;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!input.empty()) {
            output.push(input.pop());
        }
        int pop = output.peek();
        while (!output.empty()) {
            input.push(output.pop());
        }
        return pop;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return input.isEmpty();
    }
}

/*
  Your MyQueue object will be instantiated and called as such:
  MyQueue obj = new MyQueue();
  obj.push(x);
  int param_2 = obj.pop();
  int param_3 = obj.peek();
  boolean param_4 = obj.empty();
 */