public class Queue {
    private int front;
    private int rear;
    private int[] data;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = -1;
        this.rear = -1;
        this.data = new int[this.capacity];
    }

    public Queue() {
        this(16);
    }

    public void enqueue(int item) throws IllegalStateException {
        if(this.rear == this.capacity) {
            throw new IllegalStateException("Queue is full");
        }

        if(this.front == -1) {
            this.front = 0;
            this.rear = 0;
        } else {
            this.rear++;
        }
        
        this.data[this.rear] = item;
    }

    public int dequeue() throws IllegalStateException{
        if(this.front == -1) {
            throw new IllegalStateException("Queue is empty");
        }
        
        int item = data[this.front];

        if(this.front == this.rear) {
            this.front = -1;
            this.rear = -1;
        }else {
            this.front++;
        }
        return item;
    }
    @Override
    public String toString() {
        String output = "[";
        for(int i = 0 ; i <= this.rear; i++) {
            if(i != 0) {
                output += ", ";
            }
            output+= this.data[i];
        }
        output+= "]";
        return output;
    }
}








