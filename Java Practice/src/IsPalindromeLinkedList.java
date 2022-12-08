import java.util.*;

public class IsPalindromeLinkedList {

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

    public static void main(String[] args) throws Exception 
    {

        /* 
         1 3 5 6 1
         1 6 5 3 1

         1 2 3  3 2 1
         1 2 3  3 2 1


         Palindrome - O primeiro ponteiro e o ultimo ponteiro sao iguais.
         Iterar na lista linkada verificando se o comeco da lista e o final da lista os nodes sao iguais. Pode dar errado.

         Divide a lista no meio / 2 
         Verificar se os ultimos 3 digitos da lista modificado sao iguais da lista original.

         1 2 3  ** 3 2 1   321 se inverter e igual a 123? Se bater com os 3 nodes da lista original e palindrome.

         2 ponteiros andando, o primeiro anda 1 node pra frente e o segundo anda 2 nodes pra frente. ambos comecando pelo head
         faz um while atribuindo os valores a estes ponteiros na linkedlist
         o ponteiro 1 mais devagar eu inverto ele com a funcao de inverter linkedinlist

         Faco um while comparando valor a valor da ponteiro 1 invertido com a lista original head
         se for diferente retorno false
         */

         // 1 2 3 3 2 1 

         //6 7 8 7 6

         ListNode node1 = new ListNode(6);
         ListNode node2 = new ListNode(7);
         ListNode node3 = new ListNode(8);
         ListNode node4 = new ListNode(7);
         ListNode node5 = new ListNode(6);
       
         node1.next = node2;
         node2.next = node3;
         node3.next = node4;
         node4.next = node5;

            
         LinkedList<ListNode> Lista = new LinkedList<>();
         Lista.add(node1);
         Lista.add(node2);
         Lista.add(node3);
         Lista.add(node4);
         Lista.add(node5);

        
         boolean ret = isPalindrome(Lista);
    
    }

    public static boolean isPalindrome( LinkedList<ListNode> head)
    {
        if(head == null) return true;

        ListNode slow = head.getFirst();
        ListNode fast = head.getFirst();

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next; // 1 vez - 8 ; 2 vez - 6
            slow = slow.next; // 1 vez - 7 ; 2 vez - 8 = total 678
        }

        ListNode temp_slow = reverse(slow);  //678  -> 876

        while(temp_slow != null)
        {
            if(temp_slow.val != head.getFirst().val)
                return false;
            else
            {
                temp_slow = temp_slow.next;
                head.set(0, head.getFirst().next);
            }
        }

        return true;

    }
    public static  ListNode reverse (ListNode node)
    {
        ListNode retorno = null;
       
        while(node != null)
        {
            ListNode temp = node.next;  //  temp = 2 ; 
            node.next = retorno;  //2
            retorno = node;
            node = temp;
        }

        return retorno;
    }
    
}
