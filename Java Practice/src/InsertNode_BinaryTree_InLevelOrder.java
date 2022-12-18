import java.util.LinkedList;
import java.util.Queue;

public class InsertNode_BinaryTree_InLevelOrder {
 
    
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
    
            InsertNodeBinaryTree(root,19);
        }
    
    
        public static void InsertNodeBinaryTree(Tree root,int valorprocurado)
        {
            Tree newnode = new Tree(valorprocurado);
            if(root == null)
            {
                root.data = newnode.data;
                System.out.print("inserido" + valorprocurado);
                return;
            }

            Queue<Tree> q = new LinkedList<Tree>();
            q.add(root);
    
            while(!q.isEmpty())
            {
                Tree tree_node = q.remove(); // retorna o  valor head ( comec) da tree e remove da fila
    
                //interar sobre a fila esqueda e lado direito 
                if(tree_node.left == null)
                {
                   tree_node.left = newnode;
                   System.out.print("inserido corretamente");
                   break;
                } 
    
                else if(tree_node.right == null)
                {
                   tree_node.right = newnode;
                   System.out.print("inserido corretamente");
                   break;
                }
                else
                {
                    q.add(tree_node.left);
                    q.add(tree_node.right);
                }
            }
    
        }

}
}
