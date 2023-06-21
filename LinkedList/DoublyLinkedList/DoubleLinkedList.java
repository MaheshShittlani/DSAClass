public class DoubleLinkedList {
    private Node first, last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public void addFirst(int data) {
        Node newItem = new Node(data);

        // List is empty
        if(first == null) {
            first = newItem;
            last = newItem;
            return;
        }
        // List is not empty
        newItem.setNext(first);
        first.setPrev(newItem);
        first = newItem;
    }

    public void append(int data) {
        Node  newItem = new Node(data);

        // If list empty
        if(first == null) {
            first = newItem;
            last = newItem;
            return;
        }

        // It list is not empty
        last.setNext(newItem);
        newItem.setPrev(last);
        last = newItem;
    }

    public void insert(int item) {
        Node newItem = new Node(item);

        // List is empty
        if(first == null) {
            first = newItem;
            last = newItem;
            return;
        }

        // Item is smaller than the first node
        if(item < first.getData()) {
            newItem.setNext(first);
            first.setPrev(newItem);
            first = newItem;
            return;
        }

        Node prev = first;
        Node ptr = first.getNext();

        if(ptr != null) {
            if(item < ptr.getData()) {
                prev.setNext(newItem);
                newItem.setPrev(prev);
                newItem.setNext(ptr);
                ptr.setPrev(newItem);
                return;
            }

            prev = ptr;
            ptr = ptr.getNext();
        }
        // Item added at the end
        prev.setNext(newItem);
        newItem.setPrev(prev);
        last = newItem;

    }

    public void traverse() {
        Node ptr = first;
        while(ptr != null) {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getNext();
        }
        System.out.println();
    }

    public void reverseTraverse() {
        Node ptr = last;
        while(ptr != null) {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getPrev();
        }
        System.out.println();
    }
}
