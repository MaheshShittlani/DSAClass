public class CircularList {
    Node start;

    public CircularList() {
        start = null;
    }

    public void addFirst() {

    }

    public void append(int item) {
        Node newItem = new Node(item);

        if(start == null) {
            start = newItem;
            newItem.setNext(start);
            return;
        }

        Node ptr = start.getNext();
        start.setNext(newItem);
        newItem.setNext(ptr);
        start = newItem;
    }

    public void traverse() {

    }
}
