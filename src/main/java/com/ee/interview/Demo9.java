package com.ee.interview;

public class Demo9 {

    public static class Stack {
        private static final int MAX_LEN = 100;

        private final int[] store = new int[MAX_LEN];
        private int pointer = 0;

        public void push(int e) {
            if (pointer == MAX_LEN) {
                throw new RuntimeException("Stack is full");
            }
            store[pointer ++] = e;
        }

        public int pop() {
            if (pointer == 0) {
                throw new RuntimeException("Stack is empty");
            }
            return store[-- pointer];
        }

    }

    private final Stack stack1 = new Stack();
    private final Stack stack2 = new Stack();

    public void appendTail(int e) {

    }

    public int deleteHead() {
        return 0;
    }
}
