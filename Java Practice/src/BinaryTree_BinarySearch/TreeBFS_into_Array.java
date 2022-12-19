package BinaryTree_BinarySearch;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS_into_Array {
    

    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        /* 
         *        
         
                     5
         *       8      1
         *     6   7   2  3 
             9              4



        
         * 
         */

        Tree root = new Tree(5);

        root.left = new Tree(10);
        root.right = new Tree(3);


        root.left.left = new Tree(4);
        root.left.right = new Tree(6);
        root.right.right = new Tree(7);

        
        root.left.left.right = new Tree(8);
        root.left.right. left = new Tree(9);
        root.left.right.right = new Tree(1);
        root.right.left = new Tree(2);

        PrintBFSTree_Inorder(root);

    }

    public static void PrintBFSTree_Inorder(Tree root)
    {
      ArrayList<Integer> arr = new ArrayList<>();
      ArrayList<ArrayList> arrfull = new ArrayList<>();

        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);

        arr.add(root.data);
        arrfull.add(arr);
        arr = new ArrayList<>();

        while (!queue.isEmpty())
        {
            Tree temp = queue.poll();
            System.out.print(temp.data + " ");
            
 
            /*add left child to the queue */
            if (temp.left != null) {
                queue.add(temp.left);
                arr.add(temp.left.data); 

            }
 
            /*add right right child to the queue */
            if (temp.right != null) {
                queue.add(temp.right);
                arr.add(temp.right.data);
            }

            if(arr.size() > 0)
            {
                arrfull.add(arr);
                arr = new ArrayList<>();
            }
          

        }

        int count = arrfull.size();
    }
    
    public static void TreePrint (Tree root)
    {
        if(root == null)
            return;
        else
        {
            System.out.println(root.data);
            TreePrint(root.left);
            TreePrint(root.right);
        }
    }
}
