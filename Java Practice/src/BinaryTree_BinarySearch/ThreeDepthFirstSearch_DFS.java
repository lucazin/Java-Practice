package BinaryTree_BinarySearch;
public class ThreeDepthFirstSearch_DFS {

    /* 
     *    Given a binary tree of integers root, create 3 functions to print the tree nodes in preorder, inorder, and postorder traversal.
Preorder: print the root value, then print the left subtree, then print the right subtree.
Inorder: print the left subtree, then print the root value, then print the right subtree.
Postorder: print the left subtree, then print the right subtree, then print the root value.

Example 1:

Input: root = [1, 2, 3, 4, 5, 6, 7]

Output:
Preorder: 1 2 4 5 3 6 7
Inorder: 4 2 5 1 6 3 7
Postorder: 4 5 2 6 7 3 1

     * 
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


        //Input: root = [1, 2, 3, 4, 5, 6, 7]

        /* 
                        1 
                    2      3
                  4   5   6  7
          
           1 (root)  2 (root left) 3 (root right) 4,5 (left children) 6,7 (right child)
         
         */


         // DFS Search em uma arvore nos 3 modos  PreOrder, InOrder e PostOrder

        Tree tree = new Tree(1);

        tree.left = new Tree(2);
        tree.left.left = new Tree(4);
        tree.left.right = new Tree(5);

        tree.right = new Tree(3);
        tree.right.left = new Tree(6);
        tree.right.right = new Tree(7);

        System.out.println("PreOrder #####");
        dfs_Preorder(tree);
        System.out.println("InOrder #####");
        dfs_inOrder(tree);
        System.out.println("PostOrder #####");
        dfs_PostOrder(tree);

    }

    public static void dfs_Preorder(Tree root)
    {
         //Original
        /* 
                        1 
                    2      3
                  4   5   6  7 
                  
                  
            print 1 root
            print 2 - 4 - 5 (Left)
            print 3 - 6- 7
         */

        //Preorder: 1 2 4 5 3 6 7
        //Print root 
        //Print left subtree
        //Print right subtree

        if(root == null)return;
        System.out.println(root.data);
        dfs_Preorder(root.left);
        dfs_Preorder(root.right);


    }

    public static void dfs_inOrder(Tree root)
    {

        // de baixo pra cima - Esqueda - root - Direita
        //Original
        /* 
                        Root
                         1

                  Left      Right
                          
                    2         3
                  4   5      6  7   
                  
                 
            Print 4 - 2 - 5
                   2
                4    5
            
                Print root - 1  

             Print 6 - 3 - 7
                   3
                6    7
         */
        
         


        //Inorder: 4 2 5 1 6 3 7 
        //Print leftsubtree
        //print root
        //print rightsubtree  

        if(root == null)return;
        dfs_inOrder(root.left);
        System.out.println(root.data);
        dfs_inOrder(root.right);
    }

    public static void dfs_PostOrder(Tree root)
    {
        
         //Original
        /* 
                        1 
                    2      3
                  4   5   6  7    
         */
        

        //Postorder: 4 5 2 6 7 3 1
        //Print left subtree
        //Print rightsubtree
        //Print root

        if(root == null)return;
        dfs_PostOrder(root.left);
        dfs_PostOrder(root.right);
        System.out.println(root.data);
    }


}
