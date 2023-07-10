class ThreadedBinaryTree {
    Node root;

    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current;

            if (value < current.value) {
                if (!current.leftThread) {
                    current = current.left;
                    continue;
                }

                newNode.left = current.left;
                newNode.right = current;
                current.left = newNode;
                current.leftThread = false;
                return;
            }

            if (!current.rightThread) {
                current = current.right;
                continue;
            }

            newNode.right = current.right;
            newNode.left = current;
            current.right = newNode;
            current.rightThread = false;
            return;
        }
    }
}
