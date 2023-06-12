import java.util.Stack;

public class ParenthisisMatcher {

    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while(i < exp.length()) {
            char ch = exp.charAt(i);

            if(ch == '(' || ch=='[' || ch=='{') {
                stack.push(ch);
            } 
            else if(ch == ')' || ch=='}' || ch==']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if( ch==')' && top != '(' || 
                    ch == '}' && top != '{' || 
                    ch == ']' && top != '[' ) {
                    return false;
                }
            }

            i++;
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String exp1 = "((a + b) * (c) + d)";
        String exp2 = "{[(a + b) * (c + d)]}";



        System.out.println("Exp1 is balanced? "+isBalanced(exp1));
        System.out.println("Exp2 is balanced? "+isBalanced(exp2));

    }
}
