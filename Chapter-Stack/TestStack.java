public class TestStack {
    public static void main(String[] args) {
        Stack s1 = new Stack();
        try {
            s1.push(10);
            s1.push(20);
            s1.push(30);
        } catch(StackOverflowException e) {
            System.out.println(e);
        }

        try {
            System.out.println(s1.pop());
            System.out.println(s1.pop());
            System.out.println(s1.pop());
            System.out.println(s1.pop());
        } catch(StackUnderflowException e) {
            System.out.println(e);
        }
    }   
}
