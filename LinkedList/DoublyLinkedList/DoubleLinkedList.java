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

        while(ptr != null) {
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

    public void deleteItem(int item) {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        if(item == first.getData() && first == last) {
            first = null;
            last = null;
            return;
        }
        if(item == first.getData()) {
            Node ptr = first;
            first = first.getNext();
            ptr.setNext(null);
            first.setPrev(null);
            return;
        }

        Node prev = first;
        Node ptr = first.getNext();

        while(ptr != null) {
            if(item == ptr.getData()) {
                if(ptr == last) {
                    last = prev;
                    last.setNext(null);
                    ptr.setPrev(null);
                } else {
                    Node next = ptr.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);

                    ptr.setPrev(null);
                    ptr.setNext(null);
                }
                return;
            }
            prev = ptr;
            ptr = ptr.getNext();
        }
    }

    public void traverse() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node ptr = first;
        while(ptr != null) {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getNext();
        }
        System.out.println();
    }

    public void reverseTraverse() {
        if(first == null) {
            System.out.println("List is empty");
            return;
        }
        Node ptr = last;
        while(ptr != null) {
            System.out.print(ptr.getData()+" ");
            ptr = ptr.getPrev();
        }
        System.out.println();
    }
}
