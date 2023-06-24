public class TestQueueLinkedList {
    public static void main(String[] args) {
        QueueLinkedList list = new QueueLinkedList();

        list.enqueue(10);
        list.enqueue(20);
        list.enqueue(30);

        System.out.println(list);

        System.out.println("Delete item: "+ list.dequeue());
        System.out.println("Delete item: "+ list.dequeue());
        System.out.println("Delete item: "+ list.dequeue());
        System.out.println("Delete item: "+ list.dequeue());
    }
}
