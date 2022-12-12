import java.util.ArrayList;
import java.util.List;

public class n_arytree_postorder_traversal {
 
    public static  class ListNode 
    {
        Integer val;
        List<ListNode> children;
        
        ListNode(){}

        ListNode(Integer val) {this.val = val;}
        ListNode(Integer val,List<ListNode> children) {this.val = val ;this.children = children;}
       
    }

    public static void main(String[] args) throws Exception {
       
       List<ListNode> root = new ArrayList<>();

       root.add(new ListNode(1));
       root.add(new ListNode(0));
       root.add(new ListNode(3));
       root.add(new ListNode(2));
       root.add(new ListNode(4));
       root.add(new ListNode(0));
       root.add(new ListNode(5));
       root.add(new ListNode(6));
        

        List<Integer> output = new  ArrayList<>();
       // heperary(root,output); 
    }

    public static void heperary(ListNode root,List<Integer> output)
    {

        if(root == null) return;

        for(int i=0; i <root.children.size() ; i++)
        {
            heperary(root.children.get(i), output);
        }

        output.add(root.val);

    }

}
 