package BinaryTree_BinarySearch;
import java.util.LinkedList;
import java.util.Queue;

public class BInarySearchTree_Transversal {

    static class BST{
        int value;
        BST left;
        int Height;
        BST right;

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
       

      BST BinaryST = new BST(40);
      InsertNodeBST(BinaryST, 10);
      InsertNodeBST(BinaryST, 23);
      InsertNodeBST(BinaryST, 54);
      InsertNodeBST(BinaryST, 4);
      InsertNodeBST(BinaryST, 94);
      InsertNodeBST(BinaryST, 6);
      InsertNodeBST(BinaryST, 9);
      InsertNodeBST(BinaryST, 12);

      System.out.println("PreOrder");
      DFS_PreOrder(BinaryST);

      System.out.println("InOrder");
      DFS_InOrder(BinaryST);

      System.out.println("PostOrder");
      DFS_PostOrder(BinaryST);

      System.out.println("Level Order");
      BSF_LevelTraversal(BinaryST);
    
    }

    public static BST InsertNodeBST(BST root, int value)
    {
        //O (log n_)
        if(root == null){
            BST node = new BST(value);
           // System.out.println(node.value);
            return node;
        }
        else if(value <= root.value)
        {
            root.left = InsertNodeBST(root.left, value); // O (n/2)
            return root;
        }
        else 
        {   
            root.right = InsertNodeBST(root.right, value); //O(n/2)
            return root;
        }
    }
    
}


