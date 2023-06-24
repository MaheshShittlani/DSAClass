public class TestDoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.append(10);
        list.append(20);
        list.append(30);
        list.insert(5);
        list.insert(25);
        list.insert(40);

        list.deleteItem(5);
        list.deleteItem(25);
        list.deleteItem(40);
        list.deleteItem(10);
        list.deleteItem(20);
        list.deleteItem(30);
        
        list.traverse();
        list.reverseTraverse();
    }
}
