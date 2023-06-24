public class TestQueue {
    public static void main(String[] args) {
        Queue  q1 = new Queue(3, 3);

        q1.enqueue(10, 0);
        q1.enqueue(20, 0);
        q1.enqueue(30, 0);

        q1.enqueue(12, 1);
        q1.enqueue(15, 2);
        q1.enqueue(25, 2);

        System.out.println(q1);

        System.out.println("Top Priority item: "+ q1.dequeue());
        System.out.println("Top Priority item: "+ q1.dequeue());
        System.out.println("Top Priority item: "+ q1.dequeue());
        System.out.println("Top Priority item: "+ q1.dequeue());
        System.out.println(q1);


    }
}
