import java.util.ArrayList;
import java.util.List;

public class narytree_preorder_transversal {


    public static  class ListNode 
    {
        Integer val;
        List<ListNode> children;
        
        ListNode(){}

        ListNode(Integer val) {this.val = val;}
        ListNode(Integer val,List<ListNode> children) {this.val = val ;this.children = children;}
       
    }


    /* Give a n ary tree return pre order transversal all its node 
     * recursive solution is a option ? 
     * original tree is represented in order level and each group has null divider 
     * 
     *      1
     *  3    2    4
     *5   6
     * 
     */
    
     // original  1 null 3,2,4, null, 5,6
     // get 1,3,5,6,2,4

    public static void main(String[] args) throws Exception {
       
        List<Integer> output = new ArrayList<>();

        ListNode root = new ListNode();
        root.val = 1;

        root.children = new ArrayList<ListNode>();
        
        root.children.add(new ListNode(null));
        root.children.add(new ListNode(3));
        root.children.add(new ListNode(2));
        root.children.add(new ListNode(4));
        root.children.add(new ListNode(null));
        root.children.add(new ListNode(5));
        root.children.add(new ListNode(6));

        preorder(root,output);
 
        int size = output.size();

    }

    public static void preorder(ListNode root,List<Integer> output)
    {
        if(root == null) return;
        else{
            output.add(root.val);
            for(int i=0;i<root.children.size();i++)
            {
                preorder(root.children.get(i),output);
            }
        }
    }
}
