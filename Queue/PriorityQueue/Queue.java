import java.util.Arrays;

public class Queue {
    private int[][] data;
    private int[] front, rear;
    
    private int capacity;
    private int maxPriority;

    public Queue(int capacity, int maxPriority) {
        this.capacity = capacity;
        this.maxPriority = maxPriority;

        this.front = new int[this.maxPriority];
        this.rear = new int[this.maxPriority];
        this.data = new int[this.maxPriority][this.capacity];

        Arrays.fill(this.front, -1);
        Arrays.fill(this.rear, -1);
    }

    public boolean isFull(int p) {
        return (front[p] == 0 &&  rear[p] == capacity - 1) || (rear[p] == front[p] -1);
    }

    public boolean isEmpty(int p) {
        return front[p] == -1;
    }

    public void enqueue(int item, int p) {
        if(p >= maxPriority) {
            throw new IllegalStateException("Invalid prioritry");
        }
        if(isFull(p)) {
            throw new IllegalStateException("Priority Queue is full");
        }

        if(isEmpty(p)) {
            front[p] = rear[p] = 0;
        } else {
            rear[p] = (rear[p] + 1) % capacity ;
        }

        data[p][rear[p]] = item;
    }

    public int dequeue() {
        int p = maxPriority - 1;
        while(p >= 0 && isEmpty(p)) {
            p = p - 1;
        }

        if(p < 0) {
            throw new IllegalStateException("Queue is empty");
        }

        int item = data[p][front[p]];
        data[p][front[p]] = 0; // Zero fill the empty position
        if(front[p] == rear[p]) {
            front[p] = rear[p] = -1;
        } else {
            front[p] = (front[p] + 1) % capacity; 
        }

        return item;
    }

    @Override
    public String toString() {
        String output = "[";
        for(int i = 0; i < maxPriority; i++) {
            if(i != 0) {
                output += "\n";
            }
            output += Arrays.toString(data[i]);
        }
        output += "]";

        return output;
    }
}






