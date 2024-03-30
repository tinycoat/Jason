package com.dataStructure.Queue;

public class myCircleQueue {
    private int maxSize;    // 数组的最大容量
    private int front;  // 队列头
    private int rear;   // 队列尾
    private int[] arr;  // 储存数据
    public myCircleQueue(int maxQueueSize) {
        maxSize = maxQueueSize + 1;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addElement(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法加入");
            return;
        }
        arr[rear] = n;
        // 环形队列要注意取模
        rear = (rear + 1) % maxSize;
    }

    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取出");
        }
        int value = arr[front];
        // 环形队列要注意取模
        front = (front + 1) % maxSize;
        return value;
    }

    public int countElement() {
        // 计算当前队列有多少个元素
        return (maxSize + rear - front) % maxSize;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列当前为空，无数据");
            return;
        }
        for (int i = front; i < front + countElement(); i++) {
            System.out.printf("arr[%d] = %d\n", (i - front) % maxSize, arr[i % maxSize]);
        }
    }

    public int showFirstElement() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空，无数据");
        }
        return arr[front];
    }
}
