package design_circular_deque;

//https://leetcode-cn.com/problems/design-circular-deque/

/**
 *
 */
class MyCircularDeque {

    private int[] data;
    private int capacity;
    private int front;
    private int rear;

    public MyCircularDeque(int k) {
        capacity = k + 1;
        data = new int[capacity];
        front = 0;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        return true;

    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return data[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        //rear指向的位置是空的，最后一个元素的位置是 rear - 1
        return data[(rear - 1 + capacity) % capacity];//rear为0时，防止数组越界
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}