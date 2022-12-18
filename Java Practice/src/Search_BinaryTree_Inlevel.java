import java.util.LinkedList;
import java.util.Queue;

public class Search_BinaryTree_Inlevel {
    

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

        PrintSearching_BinaryTree_inLevel(root,8);
    }


    public static void PrintSearching_BinaryTree_inLevel(Tree root,int valorprocurado)
    {
        Queue<Tree> q = new LinkedList<Tree>();
        q.add(root);

        while(!q.isEmpty())
        {
            Tree tree_node = q.remove(); // retorna o  valor head ( comec) da tree e remove da fila

            if(tree_node.data == valorprocurado)
            {
                System.out.println(tree_node.data);
                return;
            }
          

            //interar sobre a fila esqueda e lado direito 
            if(tree_node.left != null)
                q.add(tree_node.left);

            if(tree_node.right != null)
                q.add(tree_node.right);
        }

    }
    


}
