public class BinaryTree {
    private final char info;
    public BinaryTree left;
    public BinaryTree right;
    public BinaryTree(char info, BinaryTree left, BinaryTree right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
    //my IDE was complaining all the time for this getter
    public char getInfo() {
        return info;
    }

    public void preorderTraversal(BinaryTree root) {
        if (root != null) {
            System.out.println(root.info);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    public void inorderTraversal(BinaryTree root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root.info);
            inorderTraversal(root.right);
        }
    }

    public void postorderTraversal(BinaryTree root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.info);
        }
    }


    public void swapTree(BinaryTree root) {
        if (root != null) {
            BinaryTree temp = root.left;
            root.left = root.right;
            root.right = temp;

            swapTree(root.left);
            swapTree(root.right);
        }
    }
}
