package BinaryTree_BinarySearch;
public class ReverseBinaryTree {

    /*
     * 
     * Given a binary tree of integers root, create a function that reverses it left to right in-place.

Example 1:

Input: root = [1, 2, 3, 4, 5, 6, 7]

Output: [1, 3, 2, 7, 6, 5, 4]
     * 
     */
    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Tree tree = new Tree(1);

        tree.left = new Tree(2);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);

        tree.right = new Tree(3);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        System.out.println("original");
        dfs_Preorder(tree);
        System.out.println("reverse");
        Reverse(tree);

        //1 2 45 3 67
        //1 3 76 2 54
    }

    public static void dfs_Preorder(Tree root)
    {
        if(root == null)return;
        System.out.println(root.data);
        dfs_Preorder(root.left);
        dfs_Preorder(root.right);
    }

    public static void Reverse(Tree root)
    {
        if(root == null)return;
       
            Tree temp =  root.left;
            root.left = root.right;
            root.right =temp;

            System.out.println(root.data);

            Reverse(root.left);
            Reverse(root.right);    
        
    }

    
}
