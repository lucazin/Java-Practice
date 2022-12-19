package BinaryTree_BinarySearch;
public class MaxPathSUM_BinaryTree {

  
    static Integer maxsum = Integer.MIN_VALUE;

    static class Tree{
        int data;
        Tree left;
        Tree right;
        Tree(int data){this.data = data; this.left = null; this.right = null;}
        Tree(int data, Tree left, Tree right){this.data = data; this.left = left; this.right = right;}
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);

        MaxPathSumTree(root);
         System.out.println(maxsum);
    }

    public static int MaxPathSumTree(Tree root)
    {
        //This indicates that we need to perform a post-order traversal of the tree because,
        // in post-order, children are processed before the parent.
        /*
         * 
         * Time complexity: O(n)

Each node in the tree is visited only once. During a visit, 
we perform constant time operations, including two recursive calls

and calculating the max path sum for the current node. So the time complexity is O(n)O(n)O(n).

Space complexity: O(n)O(n)O(n)

We don't use any auxiliary data structure, but the recursive call 
stack can go as deep as the tree's height. In the worst case, the
 tree is a linked list, so the height is nnn. Therefore, the space complexity is O(n).

         */


        if(root == null) return 0;

         //Faz a soma total do lado esquerdo da arvore
         
         // add the path sum from left subtree. Note that if the path
        // sum is negative, we can ignore it, or count it as 0.
        // This is the reason we use `Math.max` here.
        int maxsumleft = Math.max(MaxPathSumTree(root.left), 0);


        //soma lado direito todo da arvore, se for negativo coloca 0 Math.Max cuida disso
        int maxsumright = Math.max(MaxPathSumTree(root.right), 0);


        // soma a juncao das somas do lado direito com esquerdo da arvore e o root

         // if left or right path sum are negative, they are counted
        // as 0, so this statement takes care of all four scenarios
        maxsum = Math.max(maxsum, maxsumleft + maxsumright + root.data);

        // return the max sum for a path starting at the root of subtree
        return Math.max(maxsumleft + root.data, maxsumright + root.data);
    }


    
}
