//Team bad bunny
public class Main {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree('a',
                new BinaryTree('b',
                        new BinaryTree('c', null,
                                new BinaryTree('d', null, null)
                        ), null )
                , new BinaryTree('e',
                new BinaryTree('f', null, null),
                        new BinaryTree('g',
                                new BinaryTree('h', null, null), null)
                ));
        System.out.println("printing original tree with preorderTraversal:\n");
        root.preorderTraversal(root);
        System.out.println("swapping...");
        root.swapTree(root);
        System.out.println("printing swapped tree with preorderTraversal:\n");
        root.preorderTraversal(root);
    }
}
