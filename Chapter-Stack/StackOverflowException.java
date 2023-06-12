public class StackOverflowException extends Exception {
    public StackOverflowException(String msg) {
        super(msg);
    }
    public StackOverflowException() {
        this("Stack is Full");
    }
}
