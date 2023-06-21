public class TestDoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.insert(5);
        list.insert(25);
        list.insert(40);
        
        list.traverse();
        list.reverseTraverse();
    }
}
