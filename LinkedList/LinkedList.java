public class LinkedList {
    Node start;

    public LinkedList() {
        start = null;
    }


    public void addFirst(int item) {
        Node newItem = new Node(item);
        newItem.setNext(start);
        start = newItem;
    }

    public void append(int item) {
        Node newItem = new Node(item);
        if(start == null) {
            start = newItem;
            return;
        }

        Node ptr = start;
        while(ptr.getNext() != null) {
            ptr = ptr.getNext();
        }

        ptr.setNext(newItem);
    }

    public void traverse() {
        Node ptr = start;
        while(ptr != null) {
            System.out.print(ptr.getData()+ " ");
            ptr = ptr.getNext();
        }
    }
}
