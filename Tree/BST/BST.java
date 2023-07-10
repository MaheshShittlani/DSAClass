import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BST {
    private Node root;

    public BST() {
        root = null;
    }
    public void insert(int item) {
        root = insertRec(root, item);
    }

    private Node insertRec(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.data) {
            current.left = insertRec(current.left, value);
        } else if (value > current.data) {
            current.right = insertRec(current.right, value);
        }

        return current;
    } 


    public void inOrderTraversal() {
        System.out.println("Inorder Traversal");
        inOrderRecursive(root);
        System.out.println();
    }

    public void preOrderTraversal() {
        System.out.println("Pre order traversal");
        preOrderRecursive(root);
        System.out.println();
    }

    public void postOrderTraversal() {
        System.out.println("Post Order traversal");
        postOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node current) {
        if (current == null) {
            return;
        }
        inOrderRecursive(current.left);
        System.out.print(current.data + " ");
        inOrderRecursive(current.right);
    }

    private void preOrderRecursive(Node current) {
        if (current == null) {
            return;
        }
        System.out.print(current.data + " ");
        inOrderRecursive(current.left);
        inOrderRecursive(current.right);
    }

    private void postOrderRecursive(Node current) {
        if (current == null) {
            return;
        }
        inOrderRecursive(current.left);
        inOrderRecursive(current.right);
        System.out.print(current.data + " ");
    }  

    public void levelOrderTraversal() {
        System.out.println("Level order traversal...");
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }

        System.out.println();
    }

    
    public int getHeight() {
        return getHeightRecursive(root);
    }

    private int getHeightRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        int leftHeight = getHeightRecursive(current.left);
        int rightHeight = getHeightRecursive(current.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean search(int item) {
        return searchRecursive(root, item);
    }

    private boolean searchRecursive(Node current, int item) {
        if (current == null) {
            return false;
        } 
        if(current.data == item) {
            return true;
        }

        if (item < current.data) {
            return searchRecursive(current.left, item);
        } else {
            return searchRecursive(current.right, item);
        }
    }

    public int findMin() {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty.");
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public int findLargest() {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty.");
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    public void insertNonRecursive(int item) {
        Node newNode = new Node(item);

        if (root == null) {
            root = newNode;
            return;
        }

        Node par = null;  // Parent pointer
        Node ptr = root;  // Current pointer

        while (ptr != null) {
            par = ptr;
            if (item < ptr.data) {
                ptr = ptr.left;
            } else if (item > ptr.data) {
                ptr = ptr.right;
            } else {
                // Handle duplicate values (if desired)
                return;
            }
        }

        if (item < par.data) {
            par.left = newNode;
        } else {
            par.right = newNode;
        }
    }

    public void delete(int item) {
        if (root == null) {
            return;
        }

        Node par = null;  // Parent pointer
        Node ptr = root;  // Current pointer

        while (ptr != null) {
            if(item == ptr.data) {
                break;
            } else if (item < ptr.data) {
                par = ptr;
                ptr = ptr.left;
            } else {
                par = ptr;
                ptr = ptr.right;
            }
        }

        if (ptr == null) {
            throw new NoSuchElementException("Item not found.");
        }

        // Case 1: Node to be deleted has no children
        if (ptr.left == null && ptr.right == null) {
            if (par == null) {
                root = null;  // Deleting the root node
            } else if (ptr == par.left) {
                par.left = null;  // Deleting a left child
            } else {
                par.right = null;  // Deleting a right child
            }
        }
        // Case 2: Node to be deleted has one child
        else if (ptr.left == null || ptr.right == null) {
            Node child = (ptr.left != null) ? ptr.left : ptr.right;

            if (par == null) {
                root = child;  // Deleting the root node
            } else if (ptr == par.left) {
                par.left = child;  // Deleting a left child
            } else {
                par.right = child;  // Deleting a right child
            }
        }
        // Case 3: Node to be deleted has two children
        else {
            Node successor = getSuccessor(ptr);
            ptr.data = successor.data;
            delete(successor.data);
        }
    }

    private Node getSuccessor(Node node) {
        Node current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}