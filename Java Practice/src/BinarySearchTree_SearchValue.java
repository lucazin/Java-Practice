public class BinarySearchTree_SearchValue {
    
    static class BST{
        int value;
        BST left;
        int Height;
        BST right;

        BST(int data){this.value = data; this.left = null; this.right = null;}

        BST(int data, int height, BST left, BST right)
        {this.value = data; this.Height = height; this.left = left; this.right = right;}
    }

    /* 
     - Definition BinarySerch Tree is 
     Left Side root is less the parent root  and right side is bigger than parent root
     Binary tree have two childrens. 

     Search - 
     * 
     * 
     */

     public static void SearchBinary(BST root, int value)
     {

        // O(log n)
        if (root == null)
            return;

        if(value == root.value)
        {
            System.out.println("Value Find " + value);
            return;
        }

        if(value <= root.value)
            SearchBinary(root.left, value); // O n/2 two time complexity
        else
            SearchBinary(root.right, value); //O n/2 two time complxity      

       
       

        //O (log n)

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
  
        SearchBinary(BinaryST,4);
      
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
