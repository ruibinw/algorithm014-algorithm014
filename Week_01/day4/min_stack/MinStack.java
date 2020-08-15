package min_stack;

//https://leetcode-cn.com/problems/min-stack/

import java.util.Stack;

/**
 * 方法一：链表
 */
class MinStack1 {

    private class Node {
        int val;
        int min;
        Node down;
        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    private Node top;
    private int size;

    public MinStack1() {
        top = new Node(0, Integer.MAX_VALUE);//dummy node
        size = 0;
    }

    public void push(int x) {
        Node old = top;
        top = new Node(x, Math.min(x, old.min));
        top.down = old;
        size++;
    }

    public void pop() {
        if (size > 0) {
            top = top.down;
            size--;
        }
        else throw new RuntimeException("Stack is empty");
    }

    public int top() {
        if (size > 0) return top.val;
        else throw new RuntimeException("Stack is empty");
    }

    public int getMin() {
        if (size > 0) return top.min;
        else throw new RuntimeException("Stack is empty");
    }

}

/**
 * 方法二：两个栈
 */
class MinStack2 {
    private Stack<Integer> valStack;
    private Stack<Integer> minStack;

    public MinStack2() {
        this.valStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        valStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x)
            minStack.add(x);
    }

    public void pop() {
        int top = valStack.pop();
        if (top == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
