public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(10);
        list.append(20);
        list.append(30);

        list.addFirst(5);

        // list.addPosition(22, 1);
        list.insert(25);
        list.insert(1);
        list.insert(35);
        list.traverse();
        list.delete(30);
        list.delete(35);
        list.traverse();
    }
}
