package BinaryTree_BinarySearch;

public class findNextNode_Sucessor_BinarySearchTree {
    

    public static class TreeNode {
        public int data;      
        public TreeNode left;    
        public TreeNode right; 
        public TreeNode parent;
        public int size = 0;
    
        public TreeNode(int valor) {
            data = valor;
            size = 1;
        }
    }

    public static class BinaryTree {
     
        static TreeNode root;
     
        /* A function that constructs Balanced Binary Search Tree
         from a sorted array */
         TreeNode sortedArrayToBST(int arr[], int start, int end) {
     
            /* Base Case */
            if (start > end) {
                return null;
            }
     
            /* Get the middle element and make it root */
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(arr[mid]);
     
            /* Recursively construct the left subtree and make it
             left child of root */
            node.left = sortedArrayToBST(arr, start, mid - 1);
     
            /* Recursively construct the right subtree and make it
             right child of root */
            node.right = sortedArrayToBST(arr, mid + 1, end);
             
            return node;
        }

       public static void preOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

        public static void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
          

            inOrder(root.left);
            System.out.print(node.data + " ");
            inOrder(root.right);
        }
    }

    public class Successor {
        public static TreeNode inorderSucc(TreeNode n) { 
            if (n == null) return null;
            
            // Found right children -> return left most node of right subtree
            if (n.parent == null || n.right != null) { 
                return leftMostChild(n.right); 

            } 
            else
            { 
                TreeNode q = n;
                TreeNode x = q.parent;
                // Go up until we're on left instead of right
                while (x != null && x.left != q) {
                    q = x;
                    x = x.parent;
                }
                return x;
            }  
        } 
            
        public static TreeNode leftMostChild(TreeNode n) {
            if (n == null) {
                return null;
            }
            while (n.left != null) {
                n = n.left; 
            }
            return n; 
        }
     
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
       
        BinaryTree tree = new BinaryTree();
        int n = arr.length;
        TreeNode root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        System.out.println("\n");
        tree.preOrder(root);
        System.out.println("\n");

        TreeNode node = root.left;
        TreeNode next = Successor.inorderSucc(node);

        System.out.println("In order traversal Sucessor");
        System.out.println("\n");
        System.out.println(next.data);
        

        // TreeNode root = TreeNode.createMinimalBST(array);
        // TreeNode node = root.find(array[1]);
        // TreeNode next = Successor.inorderSucc(node);
    }

}

