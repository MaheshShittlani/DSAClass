class Node {
    int value;
    Node left;
    Node right;
    boolean leftThread;
    boolean rightThread;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.leftThread = false;
        this.rightThread = false;
    }
}