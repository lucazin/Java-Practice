import java.util.LinkedList;
import java.util.Queue;


public class PrintBFS_Tree {
    
/* 
 * 
 * Given a binary tree root, create a function that prints its nodes in level order (level by level).

Example 1:

Input: root = [5, 10, 3, 4, 6, null, 7, null, 8, 9, 1, 2]

Output: 5 10 3 4 6 7 8 9 1 2

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

        Tree root = new Tree(5);
        root.left = new Tree(10);
        root.right = new Tree(3);

        root.left.left = new Tree(4);
        root.left.left.right = new Tree(8);
        root.left.right = new Tree(6);
        root.left.right.left = new Tree(9);
        root.left.right.right = new Tree(1);

        root.right.right = new Tree(7);
        root.right.right.left = new Tree(2);

        PrintBFSTree_Inorder(root);
    }

    public static void PrintBFSTree_Inorder(Tree root)
    {
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Tree temp = queue.poll();
            System.out.print(temp.data + " ");
 
            /*add left child to the queue */
            if (temp.left != null) {
                queue.add(temp.left);
            }
 
            /*add right right child to the queue */
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

}
