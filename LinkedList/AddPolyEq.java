import java.security.cert.PolicyNode;
import java.util.LinkedList;

public class AddPolyEq {
    public static void main(String[] args) {
        LinkedList<PolyNode> list1 = new LinkedList<>();
        LinkedList<PolyNode> list2 = new LinkedList<>();

        list1.add(new PolyNode(5, 3));
        list1.add(new PolyNode(3, 2));
        list1.add(new PolyNode(2, 0));


        list2.add(new PolyNode(5, 2));
        list2.add(new PolyNode(3, 1));
        list2.add(new PolyNode(9, 0));

        LinkedList<PolyNode> list3 = addPoly(list1,list2);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

    public static LinkedList<PolyNode> addPoly(LinkedList<PolyNode> list1, LinkedList<PolyNode> list2) {
        LinkedList<PolyNode> list3 = new LinkedList<>();
        int index1 = 0;
        int index2 = 0;
        /**
         * This loop executes until both list have nodes
         */
        while(index1 < list1.size() && index2 < list2.size()) {
            PolyNode item1 = list1.get(index1);
            PolyNode item2 = list2.get(index2);

            if(item1.getPow() > item2.getPow()) {
                list3.add(new PolyNode(item1.getCoff(), item1.getPow()));
                index1++;
            } else if(item1.getPow() < item2.getPow()) {
                list3.add(new PolyNode(item2.getCoff(), item2.getPow()));
                index2++;
            } else {
                list3.add(new PolyNode(item1.getCoff() + item2.getCoff(), item1.getPow()));
                index1++;
                index2++;
            }
        }

        // Reamining of list1
        while(index1 < list1.size()) {
            list3.add(new PolyNode(list1.get(index1).getCoff(), list1.get(index1).getPow()));
            index1++;
        }

        // Reamining of list2
        while(index2 < list2.size()) {
            list3.add(new PolyNode(list2.get(index2).getCoff(), list2.get(index2).getPow()));
            index2++;
        }

        return list3;
    }
}
