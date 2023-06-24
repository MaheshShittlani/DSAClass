public class QueueLinkedList {
    private Node front, rear;

    public QueueLinkedList() {
        front = null;
        rear = null;
    }

    public void enqueue(int item) {
        Node newItem = new Node(item);

        if(front == null) {
            front = newItem;
            rear = newItem;
        } else {
            rear.setNext(newItem);
            rear = newItem;
        }
    }

    public int dequeue() {
        if(front == null) {
            throw new IllegalStateException("Queue is empty");
        }

        int data = front.getData();

        if(front == rear) {
            front = null;
            rear = null;
        }else {
            Node ptr = front;
            front = front.getNext();
            ptr.setNext(null); // Unlink the node
        }
        return data;
    }

    @Override
    public String toString() {
        String output = "[";
        Node ptr = this.front;
        while(ptr != null) {
            if(ptr != this.front) {
                output += ", ";
            } 
            output +=  ptr.getData();
            ptr = ptr.getNext();
        }
        output+= "]";
        return output;
    }
}






