package BinaryTree_BinarySearch;
public class IsValidBinaryTree {
    
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    static Integer prev;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Tree root = new Tree(2);
        root.left = new Tree(1);
        root.right = new Tree(3);

        prev = null;
        System.out.println(inorder(root));
    }

    /*
     * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
     * 
     */

    private static boolean inorder(Tree root) {
        if (root == null) { // always check if root is null 
            return true;
        }
        if (inorder(root.left) == false) {
            return false;
        }
        if (prev != null && root.data <= prev) {
            return false;
        }
        prev = root.data;
        return inorder(root.right);
    }


}
