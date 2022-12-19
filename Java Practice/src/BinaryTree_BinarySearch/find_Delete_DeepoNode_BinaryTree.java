package BinaryTree_BinarySearch;
import java.util.LinkedList;
import java.util.Queue;

public class find_Delete_DeepoNode_BinaryTree {

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

        finddeepNodeBS_inLevel(root);
        DeleteDeepNode(root);
        finddeepNodeBS_inLevel(root);
    }


    //use in level tranversal 
    //find the deepst node of tree and use queue and pass to all tree and find the deepsnode.
    public static void finddeepNodeBS_inLevel(Tree root)
    {

        Queue<Tree> q = new LinkedList<>(); //use this data structure for avoid ramdom access and use fila.
        q.add(root);
        Tree initValue = null;

        while(!q.isEmpty())
        {
           initValue = q.remove(); // no final do loop essa variavel vai o node mais longo encontrado 
            if(initValue.left != null)
            {
                q.add(initValue.left);
            }

            if(initValue.right != null)
            {
                q.add(initValue.right);
            }

        }

        System.out.println(initValue.data);
    }
    
    
    //use in level tranversal 
    //Delete o ultimo node mais longo da tree
    public static void DeleteDeepNode(Tree root)
    {
        Queue<Tree> q = new LinkedList<>();
        q.add(root);

        Tree prev = null;
        Tree node = null; //ega o head da arvore
        while(!q.isEmpty())
        {

            prev = node;
            node = q.remove(); //busca the last node from the tree

            if(node.left == null)
            {
                node.right = null;
                return;
            }
            else if(node.right == null)
            {
                node.left = null;
                return;
            }
            else
            {
                q.add(node.left);
                q.add(node.right);
            }
        }
    }

    public static void DeleteNodeSelected(Tree root, int valueDeleted)
    {
        Queue<Tree> q = new LinkedList<>();
        q.add(root);

        Tree presenteValue = null;
        
        while(!q.isEmpty())
        {
            
            presenteValue = q.remove();

            if(presenteValue.data == valueDeleted)
            {
                //atribuo ao node que quero o ultimo node da arvore no lugar do node quer apagar valor passado
                presenteValue = finddeepNodeBS_inLevel_returned(root);

                //temos 2 nodes repetidos entao eu apago o ultimo node que coloquei no lugar.
                DeleteDeepNode(root);
                break;
            }
            else
            {
                q.add(presenteValue.left);
                q.add(presenteValue.right);
            }
        }
    }

    public static Tree finddeepNodeBS_inLevel_returned(Tree root)
    {

        Queue<Tree> q = new LinkedList<>(); //use this data structure for avoid ramdom access and use fila.
        q.add(root);
        Tree initValue = null;

        while(!q.isEmpty())
        {
           initValue = q.remove(); // no final do loop essa variavel vai o node mais longo encontrado 
            if(initValue.left != null)
            {
                q.add(initValue.left);
            }

            if(initValue.right != null)
            {
                q.add(initValue.right);
            }

        }

       return initValue;
    }
}
