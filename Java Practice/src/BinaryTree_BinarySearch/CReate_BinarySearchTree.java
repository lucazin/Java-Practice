package BinaryTree_BinarySearch;
public class CReate_BinarySearchTree {


    static class BST{
        int value;
        BST left;
        int Height;
        BST right;

        BST(int data){this.value = data; this.left = null; this.right = null;}

        BST(int data, int height, BST left, BST right)
        {this.value = data; this.Height = height; this.left = left; this.right = right;}
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

      BST BinaryST = new BST(40);
      InsertNodeBST(BinaryST, 10);
      InsertNodeBST(BinaryST, 23);
      InsertNodeBST(BinaryST, 54);
      InsertNodeBST(BinaryST, 23);
      InsertNodeBST(BinaryST, 94);
      InsertNodeBST(BinaryST, 33);
      InsertNodeBST(BinaryST, 63);
      InsertNodeBST(BinaryST, 12);
        

         
    }

    public static BST InsertNodeBST(BST root, int value)
    {
        //O (log n_)
        if(root == null){
            BST node = new BST(value);
            System.out.println(node.value);
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
