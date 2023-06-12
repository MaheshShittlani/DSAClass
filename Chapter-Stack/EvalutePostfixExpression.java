import java.util.Stack;

public class EvalutePostfixExpression {
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch =='^';
    }
    public static int evalute(int operand1, int operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '%':
                return operand1 % operand2;
            default:
                throw new IllegalArgumentException("Invalid postfix expression");
        }
    }
    public static int evalPost(String postfix) {
        int result = -1;
        int i = 0;
        int length = postfix.length();
        Stack<Integer> stack = new Stack<>();
        while(i < length) {
            char ch = postfix.charAt(i);
            if(isOperator(ch)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                
                result = evalute(operand1, operand2, ch);
                stack.push(result);
            }
            if(Character.isDigit(ch)) {
                stack.push(Character.getNumericValue(ch));
            }
            i++;
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String postfix = "235*3/+56*5/+8+";
        int result = evalPost(postfix);
        System.out.println("Result = "+result);
    }
}
