public class TestCircularQ {
    public static void main(String[] args) {
        CircularQ q1 = new CircularQ();
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        // q1.enqueue(40);
        // q1.enqueue(50);
        
        System.out.println(q1);
        
        System.out.println("Deleted item: "+q1.dequeue());
        System.out.println("Deleted item: "+q1.dequeue());
        System.out.println(q1);

        q1.enqueue(60);
        q1.enqueue(70);
        System.out.println(q1);

        System.out.println("Deleted item: "+q1.dequeue());
        System.out.println("Deleted item: "+q1.dequeue());
        System.out.println(q1);

    }
}
