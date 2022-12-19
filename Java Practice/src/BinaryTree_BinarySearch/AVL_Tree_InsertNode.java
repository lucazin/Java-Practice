package BinaryTree_BinarySearch;
import java.util.LinkedList;
import java.util.Queue;

public class AVL_Tree_InsertNode {

    static class BST{
        int value;
        BST left;
        int Height;
        BST right;

        BST(){};
        BST(int data){this.value = data; this.left = null; this.right = null;}

        BST(int data, int height, BST left, BST right)
        {this.value = data; this.Height = height; this.left = left; this.right = right;}
    }

     /*  Todos usando recursividade pra buscar e com condicao do root == null  return

         Depth First Search - DFS
       - PreOrder : Comeca pelo root node master e desce em todos os outros nodes comecando pela root / left e right 
       - InOrder: Comeca pela esquerda left sobe vai ate o root e passa pro lado direito right
       - PostOrder: Comeca pela esquerda bottom top  vai pro no da direita e por ultima vai pro root.

       Breath First Search

       - Level Order - Busca pelos elementos olhando pra levels da arvore, usa queue para trabalhar os elementos.
      */

      public static void BSF_LevelTraversal(BST root)
      {
          // time omplexity On
          if(root == null)
              return;
  
        Queue<BST> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            BST ElementTree = q.remove(); //remove one by one from queue and print
            System.out.println(ElementTree.value);

            if(ElementTree.left != null)
                q.add(ElementTree.left); //add to queue

            else if(ElementTree.right != null)
                q.add(ElementTree.right); // add to queue
        }
        
      }

    public static void DFS_PreOrder(BST root)
    {
        //On
        if(root == null)
            return;

        System.out.println(root.value);
        DFS_PreOrder(root.left);
        DFS_PreOrder(root.right);
    }
    
    public static void DFS_InOrder(BST root)
    {
         //On
        if(root == null)
            return;

        DFS_PreOrder(root.left);
        System.out.println(root.value);
        DFS_PreOrder(root.right);
    }
    
    public static void DFS_PostOrder(BST root)
    {
         //On

        if(root == null)
            return;

        DFS_PreOrder(root.left);
        DFS_PreOrder(root.right);
        System.out.println(root.value);
    }

    public static void main(String[] args) throws Exception {
       

      BST BinaryST = new BST(4);
      InsertNode_AVL_BST(BinaryST, 5);
      InsertNode_AVL_BST(BinaryST, 10);
      InsertNode_AVL_BST(BinaryST, 15);
      InsertNode_AVL_BST(BinaryST, 20);
     

    //   System.out.println("PreOrder");
    //   DFS_PreOrder(BinaryST);

    //   System.out.println("InOrder");
    //   DFS_InOrder(BinaryST);

    //   System.out.println("PostOrder");
    //   DFS_PostOrder(BinaryST);

      System.out.println("Level Order");
      BSF_LevelTraversal(BinaryST);
    
    }

    public static BST InsertNode_AVL_BST(BST root, int value)
    {
        //O (log n_)
        if(root == null){
            BST node = new BST(value);
            node.Height = 1;
            return node;
        }
        else if(value < root.value)
        {
            root.left = InsertNode_AVL_BST(root.left, value); // O (n/2)
           
        }
        else 
        {   
            root.right = InsertNode_AVL_BST(root.right, value); //O(n/2)
           
        }

        //after insert we have to updated de height of tree;

        root.Height = 1 + Math.max(GetHeight_AVLTree(root.left), GetHeight_AVLTree(root.right));
        int balance  = GetTreeBalanced(root);

        //Disalanced and is a Left / Left Rotate Condition 
        if(balance > 1 && value < root.left.value)
        {
            //Do Right Rotate here
            return rotateRight(root);

        }
         //Disalanced and is a Left / Right Rotate Condition 
         if(balance > 1 && value > root.left.value)
         {
            root.left = rotateLeft(root);
             //Do Right Rotate here
             return rotateRight(root);
 
         }
 
          //Disalanced and is a Right / Right Rotate Condition 
        if(balance < -1  && value > root.right.value)
        {
            //Do Left Rotate here
            return rotateLeft(root);

        }

          //Disalanced and is a Left / Right Rotate Condition 
          if(balance > 1 && value < root.left.value)
          {
             root.right = rotateRight(root);
              //Do Right Rotate here
              return rotateLeft(root);
  
          }

          return root;

    }
    
    


    //#####AVL TREE OPERATIONS 

    /* EXPLAIN */


    public static int GetHeight_AVLTree(BST root)
    {
        if(root == null)
            return 0;

        return root.Height;
    }

    //Rotate Right
    public static BST rotateRight(BST DisbalancedNode)
    {

            BST newroot = DisbalancedNode.left;
            DisbalancedNode.left = DisbalancedNode.left.right;
            newroot.right = DisbalancedNode;
            DisbalancedNode.Height = 1+ Math.max(GetHeight_AVLTree(DisbalancedNode.left), GetHeight_AVLTree(DisbalancedNode.right));
            newroot.Height = 1 + Math.max(GetHeight_AVLTree(newroot.left), GetHeight_AVLTree(newroot.right));
            return newroot;
    }

     //Rotate Left
     public static BST rotateLeft(BST DisbalancedNode)
     {
 
             BST newroot = DisbalancedNode.right;
             DisbalancedNode.right = DisbalancedNode.right.left;
             newroot.left = DisbalancedNode;
             DisbalancedNode.Height = 1+ Math.max(GetHeight_AVLTree(DisbalancedNode.left), GetHeight_AVLTree(DisbalancedNode.right));
             newroot.Height = 1 + Math.max(GetHeight_AVLTree(newroot.left), GetHeight_AVLTree(newroot.right));
             return newroot;
     }

     public static int GetTreeBalanced (BST root)
     {
        if(root == null)
            return 0;

        return GetHeight_AVLTree(root.left) - GetHeight_AVLTree(root.right);
     }
}
