public class TestBST {
    public static void createBST(BST tree, int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10, 8,12, 7, 9, 11, 13 , 5};

        BST tree = new BST();
        createBST(tree,arr);
        tree.preOrderTraversal();
        tree.inOrderTraversal();
        tree.postOrderTraversal();
        tree.levelOrderTraversal();
        
        System.out.println("Tree height: "+tree.getHeight());
    }
}