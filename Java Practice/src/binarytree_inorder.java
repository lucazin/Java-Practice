import java.util.ArrayList;
import java.util.List;

public class binarytree_inorder {

    
    public static  class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    

    public static void main(String[] args) throws Exception {
      

      /*  
       *   1 
       *       2
       *   3
       * 
       * root = 1,null,2,3
       * ret = 1,3,2 
       * 
       * Porque buscamos na esquerda toda e depois voltamos ao centro. root
       * 
       * inorder e de tras pra frente.
       * tranversal e percorrer a arvore binaria
       * 
       * give the root of binary tree, return a inorder trasversal of its nodes value.
       */

       TreeNode root = new TreeNode();
       root.val = 1;


       root.left = null;
       root.right = new TreeNode(2);
       root.right.left = new TreeNode(3);

      List<Integer> output = new ArrayList<>();
      helper(root,output);



    }

    public static void helper(TreeNode root,List<Integer> output)
    {
       if(root == null) return;

       helper(root.left, output);  //chamo recursao passando o lado esquerdo e verifico se e nulo senao eu adiciono o valor
       output.add(root.val);
       helper(root.right, output);

    }
}
