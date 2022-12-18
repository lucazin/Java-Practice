public class BalancedBinaryTree {
    
    static Integer countleft = 0;
    static Integer countRight = 0;
    static Tree left = null;
    static Tree right = null;

    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Tree root = new Tree(5);

        root.left = new Tree(8);
        root.left.right = new Tree(7);
        root.left.left = new Tree(6);
        root.left.left.left = new Tree(9);

        root.right = new Tree(1);
        root.right.left = new Tree(2);
        root.right.right = new Tree(3);
        root.right.right.right = new Tree(4);

        System.out.println(isBalanced_Fast(root));
    }

    public static int isBalanced_Fast(Tree root)
    {
        //O(n)
        if (root == null)
            return 0;

        int lh = isBalanced_Fast(root.left);
        if (lh == -1)
            return -1;

        int rh = isBalanced_Fast(root.right);
        if (rh == -1)
            return -1;
 
            /* 
             * A height balanced binary tree is a binary tree in which the height of the left subtree and right subtree
             *  of any node does not differ by more than 1 and both the left and right subtree are also height balanced.
             * 
             */
        if (Math.abs(lh - rh) > 1)
            return -1;
        else
            return Math.max(lh, rh) + 1;
    }

   static boolean isBalanced(Tree node)
    {

        //O(n2)
        int lh; /* for height of left subtree */
 
        int rh; /* for height of right subtree */
 
        /* If tree is empty then return true */
        if (node == null)
            return true;
 
        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);
 
        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
            return true;
 
        /* If we reach here then tree is not height-balanced
         */
        return false;
    }
 
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /*  The function Compute the "height" of a tree. Height
       is the number of nodes along the longest path from
       the root node down to the farthest leaf node.*/
   static  int height(Tree node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of
         left height and right heights */
        return 1
            + Math.max(height(node.left),
                       height(node.right));
    }


}
