package BinaryTree_BinarySearch;

public class BinarySearchTree_MinimalHeight {


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
    

    public static void main(String[] args) throws Exception {
            

    }


    public static boolean isBST(TreeNode tree) {
                if (tree.left != null) {
                    if (tree.data < tree.left.data || !tree.left.isBST()) {
                        return false;
                    }
                }
                
                if (tree.right != null) {
                    if (tree.data >= tree.right.data || !tree.right.isBST()) {
                        return false;
                    }
                }		
                
                return true;
            }
            
            public int height(TreeNode tree) {
                int leftHeight = tree.left != null ? tree.left.height() : 0;
                int rightHeight = tree.right != null ? tree.right.height() : 0;
                return 1 + Math.max(leftHeight, rightHeight);
            }
            
            private  void setLeftChild(TreeNode left) {
                TreeNode tree = left;
                if (tree != null) {
                    tree.parent = this;
                }
            }
            
            private static void setRightChild(TreeNode right) {
                TreeNode tree = right;
                if (right != null) {
                    right.parent = this;
                }
            }
            
            
            public  static TreeNode createMinimalBST(int arr[], int start, int end){
                if (end < start) {
                    return null;
                }
                int mid = (start + end) / 2;
                TreeNode n = new TreeNode(arr[mid]);
                n.setLeftChild(createMinimalBST(arr, start, mid - 1));
                n.setRightChild(createMinimalBST(arr, mid + 1, end));
                return n;
            }
            
            public static TreeNode createMinimalBST(int[] array) {
                return createMinimalBST(array, 0, array.length - 1);
            }

    
    }
}
