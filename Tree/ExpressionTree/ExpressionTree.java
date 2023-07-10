import java.util.Stack;

class ExpressionTree {
    private Node root;

    public ExpressionTree() {
        root = null;
    }

    public void buildTree(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Node> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                Node right = stack.pop();
                Node left = stack.pop();
                Node operatorNode = new Node(token);
                operatorNode.left = left;
                operatorNode.right = right;
                stack.push(operatorNode);
            } else {
                Node operandNode = new Node(token);
                stack.push(operandNode);
            }
        }

        root = stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public int evaluate() {
        return evaluateRec(root);
    }

    private int evaluateRec(Node root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.value);
        }

        int leftValue = evaluateRec(root.left);
        int rightValue = evaluateRec(root.right);

        switch (root.value) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                return leftValue / rightValue;
            default:
                return 0;
        }
    }
}
