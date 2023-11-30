public class BPlusTree {
   private BPlusNode root;

   public BPlusTree(int n) {
       root = new BPlusNode();
       root.keys = new Object[n-1];
       root.references = new Object[n];
   }
}
