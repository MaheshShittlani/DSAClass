public class StackUnderflowException extends Exception{
    public StackUnderflowException(String msg) {
        super(msg);
    }

    public StackUnderflowException() {
        this("Stack is empty");
    }
}
