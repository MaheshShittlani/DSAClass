public class ExpressionTree {
    public Node buildExpressionTree(String infixExpression) {
        Stack<Node> stack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char c = infixExpression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                Node node = new Node(Character.toString(c));
                stack.push(node);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    processOperator(stack, operatorStack);
                }
                operatorStack.pop(); // Pop '('
            } else {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    processOperator(stack, operatorStack);
                }
                operatorStack.push(c);
            }
        }

        while (!operatorStack.isEmpty()) {
            processOperator(stack, operatorStack);
        }

        return stack.pop();
    }

    private void processOperator(Stack<Node> stack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        Node rightNode = stack.pop();
        Node leftNode = stack.pop();
        Node operatorNode = new Node(Character.toString(operator));

        operatorNode.left = leftNode;
        operatorNode.right = rightNode;

        stack.push(operatorNode);
    }

    private int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree();
        String infixExpression = "a+b*c-(d/e+f)*g";
        Node root = expressionTree.buildExpressionTree(infixExpression);

        System.out.print("Inorder traversal of the expression tree: ");
        expressionTree.inorderTraversal(root);
    }
}
