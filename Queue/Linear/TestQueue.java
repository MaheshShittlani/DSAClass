public class TestQueue {
    public static void main(String[] args) {
        Queue q1 = new Queue();

        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);

        System.out.println(q1);

        System.out.println("Item deleted: "+q1.dequeue());
        System.out.println("Item deleted: "+q1.dequeue());
        System.out.println("Item deleted: "+q1.dequeue());
        System.out.println("Item deleted: "+q1.dequeue());
    }
}
