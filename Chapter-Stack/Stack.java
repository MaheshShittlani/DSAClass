public class Stack {
    private int[] stk;
    private int top;
    private int capacity;
    
    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        stk = new int[this.capacity];
    }

    public Stack() {
        this(16);   
    }

    public boolean isFull() {
        if(top == capacity - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }
        return false;
    }

    public void push(int element) throws StackOverflowException{
        if(this.isFull()) {
            throw new StackOverflowException();
        }
        ++top;
        stk[top] = element; 
    }

    public int pop() throws StackUnderflowException{
        if(this.isEmpty()) {
           throw new StackUnderflowException();
        }
        
        int element = stk[top];
        top--;
        return element;
    }

    public int peep() {
        if(top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int element = stk[top];
        return element;
    }
} 