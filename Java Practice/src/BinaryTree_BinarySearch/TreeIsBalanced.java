package BinaryTree_BinarySearch;

public class TreeIsBalanced {

    public static class TreeNode {
        public int data;      
        public TreeNode left;    
        public TreeNode right; 
        public TreeNode parent;
        public int size = 0;
    
        public TreeNode(int valor) {
            data = valor;
            size = 1;
        }
    }

    public class CheckBalanced {

        public static int checkHeight(TreeNode root) 
        {
              if (root == null) {
                  return -1;
              }

              int leftHeight = checkHeight(root.left);
              if (leftHeight == Integer.MIN_VALUE) 
                return Integer.MIN_VALUE; // Propagate error up
              
              int rightHeight = checkHeight(root.right);
              if (rightHeight == Integer.MIN_VALUE) 
                return Integer.MIN_VALUE; // Propagate error up
              
              int heightDiff = leftHeight - rightHeight;

              if (Math.abs(heightDiff) > 1) {
                  return Integer.MIN_VALUE; // Found error -> pass it back
              } 
              else
              {
                  return Math.max(leftHeight, rightHeight) + 1;
              }
          }
          

          public static boolean isBalanced(TreeNode root) {
              return checkHeight(root) != Integer.MIN_VALUE; //se diferente retorna true;
          }
      }

    public static void main(String[] args) throws Exception {
        System.out.println("Check Is Balanced");

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(8);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(1);

        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(2);


       System.out.println(CheckBalanced.isBalanced(root));
    }


    
}
