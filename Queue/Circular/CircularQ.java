import java.util.Arrays;

public class CircularQ {
    private int front;
    private int rear;
    private int capacity;
    private int[] data;

    public CircularQ(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.data = new int[this.capacity];
        Arrays.fill(this.data,-1);
    }

    public CircularQ() {
        this(5);
    }

    public boolean isFull() {
        return (front == 0 && rear == capacity - 1) || (front == rear + 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int item) {
        if(isFull()) {
            throw new IllegalStateException("Queue is full");
        }

        if(front == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        // if(front == -1) {
        //     front = 0;
        //     rear = 0;
        // } else if(rear == capacity - 1){
        //     rear = 0;
        // } else {
        //     rear = rear + 1;
        // }

        this.data[this.rear] = item;
    }

    public int dequeue() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int item = data[front];
        data[front] = -1;

        if(front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        return item;
    }

    public int peek() {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return this.data[this.front];
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}








