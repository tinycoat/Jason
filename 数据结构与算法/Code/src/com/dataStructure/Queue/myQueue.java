package com.dataStructure.Queue;

/*
* 队列实现
*
* 变量： 最大容量、头指针、尾指针、存储数组
*
* 方法： 判空、判满、存、取、显示
*
* */
public class myQueue {
    private int maxSize;
    private int front;
    private int rear;
    private final int[] arr;

    public myQueue(int queueSize) {
        setFront(-1);
        setRear(-1);
        setMaxSize(queueSize);
        arr = new int[maxSize];
    }

    public void showQueue() {
        if (isQueueEmpty()) {
            System.out.println("队列为空，暂无数据");
            return;
        }
        System.out.println("队列信息如下：");
        for (int i = front + 1; i < maxSize; i++) {
            System.out.printf("%d\t%d\n", i, arr[i]);
        }
    }

    public boolean isQueueFull() {
        return rear == maxSize - 1;
    }

    public int showFirstElement() {
        if (isQueueEmpty()) {
            throw new RuntimeException("错误！无法显示头部数据，队列为空");
        } else {
            return arr[rear];
        }
    }

    public boolean isQueueEmpty() {
        return rear == front;
    }

    public void putElement(int newElement) {
        // 向队列存放数据
        if (isQueueFull()) {
            throw new RuntimeException("error: the queue is full!");
        } else {
            rear++;
            arr[rear] = newElement;
        }
    }

    public int getElement() {
        // 从队列取出数据
        if (isQueueEmpty()) {
            throw new RuntimeException("error: the queue is empty!");
        } else {
            front++;
            return arr[front];
        }
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
