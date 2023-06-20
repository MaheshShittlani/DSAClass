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
    /**
     * This algorithm adds an item in an unsorted list. It adds the item on the given position.
     * @param item
     * @param pos
     */

    public void addPosition(int item, int pos) {
        Node ptr = start;
        if(pos == 1) {
            Node newItem = new Node(item);
            newItem.setNext(start);
            start = newItem;
            return;
        }
        for(int i = 1; ptr!= null && i < pos - 1; i++) {
            ptr = ptr.getNext();
        }
        if(ptr == null) {
            System.out.println("Such position doesn't exist");
            return;
        }
        Node newItem = new Node(item);
        newItem.setNext(ptr.getNext());
        ptr.setNext(newItem);
    }
    /**
     * This methods inserts the item into a sorted list
     * @param item
     */
    public void insert(int item) {
        Node newItem = new Node(item);

        // If list is empty.
        if(start == null) {
            newItem.setNext(start);
            start = newItem;
            return;
        }
        // item should be added as first node
        if(item < start.getData()) {
            newItem.setNext(start);
            start = newItem;
            return;
        }

        Node prev, ptr;
        prev = start;
        ptr = start.getNext();
        // Item should be added in between
        while(ptr != null) {
            if(item < ptr.getData()) {
                newItem.setNext(ptr);
                prev.setNext(newItem);
                return;
            }
            prev = ptr;
            ptr = ptr.getNext();
        }

        // item should be added at the end
        prev.setNext(newItem);
    }

    public void delete(int item) {
        if(start == null) {
            System.out.println("List is empty");
            return;
        }
        if(item < start.getData()) {
            System.out.println("Item not exist in the list");
            return;
        }
        if(item == start.getData()) {
            Node ptr = start;
            start = start.getNext();
            ptr.setNext(null);
            return;
        }

        Node prev, ptr;
        prev = start;
        ptr = start.getNext();

        while(ptr!=null) {
            if(item == ptr.getData()) {
                prev.setNext(ptr.getNext());
                ptr.setNext(null);
                return;
            }
            prev = ptr;
            ptr = ptr.getNext();
        }
        System.out.println("Item doesn't exists in the list");
    }

    public void traverse() {
        Node ptr = start;
        while(ptr != null) {
            System.out.print(ptr.getData()+ " ");
            ptr = ptr.getNext();
        }
        System.out.println();
    }
}
