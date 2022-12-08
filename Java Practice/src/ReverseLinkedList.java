import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseLinkedList {

    public static  class ListNode 
    {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val) {this.val = val;}
        ListNode (int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        /*
          - Reverse Linked List 
          - Input 1 - 2 - 3 - 4 - 5 - null 
          - Saida 5 - 4 - 3 - 2 - 1 - null
          
         */

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
      
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        List<ListNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        
        for(int i=0;i<=list.size()-1;i++)
           reverse(list.get(i));
    
    }
    
    public static  void reverse (ListNode node)
    {
        ListNode saida = null;
       
        while(node != null)
        {
            ListNode temp = node.next;  //  temp = 2 ; 
            node.next = saida;  //2
            saida = node;
            node = temp;
        }
    }
}
