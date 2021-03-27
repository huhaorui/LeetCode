package test;

import java.util.ArrayList;
import java.util.EmptyStackException;

class MyStack<T> {
    private final ArrayList<T> obj = new ArrayList<>();
    private int length = 0;

    public static void main(String[] args) throws Exception {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(123);
        stack.push(1234);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

    }

    T pop() {
        if (obj.isEmpty()) {
            throw new EmptyStackException();
        }
        T pop = obj.get(length - 1);
        obj.remove(length - 1);
        length--;
        return pop;
    }

    void push(T input) {
        obj.add(input);
        length++;
    }

    int size() {
        return length;
    }

    T peek() {
        if (obj.isEmpty()) {
            throw new EmptyStackException();
        }
        return obj.get(length - 1);
    }
}
