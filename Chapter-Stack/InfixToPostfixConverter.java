import java.util.Stack;

public class InfixToPostfixConverter {
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch =='^';
    }

    public static int precedence(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }

    public static String infixToPost(String infix) throws IllegalArgumentException {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int  i = 0;
        int length = infix.length();
        char top;
        while(i < length) {
            char ch = infix.charAt(i);
            if(ch == '(') {
                stack.push(ch);
            } else if(ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if(stack.isEmpty()) {
                    throw new IllegalArgumentException("Invalid infix expression");
                }
            } else if(isOperator(ch)) {
                while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            } else {
                postfix.append(ch);
            }
            i++;
        }

        return postfix.toString();
    }
    public static void main(String[] args) {
        String infix = "(2+3*5/3+5*6/5+8)";

        String postfix = infixToPost(infix);
        System.out.println("Postfix expression : "+ postfix);
    }
}
