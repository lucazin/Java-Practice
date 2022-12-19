package LinkedList;
public class ReverseLinkedList2 {

/* 
 * 
 * Given a linked list of integers list, create a function that reverses it in-place without using an additional data structure.

Example 1:

Input: list = 5 -> 3 -> 6 -> 4 -> 7 -> null

Output: 7 -> 4 -> 6 -> 3 -> 5 -> null
 * 
 */

static class Node{
    int data;
        Node next;
        Node(int data){this.data = data; this.next = null;}
        Node(int data, Node next){this.data = data; this.next = next;}
    }
  
    static class LinkedList{
        Node head;
        LinkedList(){this.head = null;}
        LinkedList(Node head){this.head = head;}
    }
    


     public static void main(String[] args) throws Exception {      
           System.out.println("Hello, World!");  

           Node n1 = new Node(5);
           Node n2 = new Node(3);
           Node n3 = new Node(6);
           Node n4 = new Node(4);
           Node n5 = new Node(7);
           Node n6 = null;

           n1.next = n2;
           n2.next = n3;
           n3.next = n4;
           n4.next = n5;
           n5.next = n6;

           LinkedList root = new LinkedList(n1);
        
           reverseList(root);
        }

     
        public static void reverseList(LinkedList list){

            // O(n)


            // your code here
            // Input: list = 5 -> 3 -> 6 -> 4 -> 7 -> null
            // Output: 7 -> 4 -> 6 -> 3 -> 5 -> null

            Node prev = null;
            Node cur = list.head; //Pega todo o lista linkadae atribui a uma variavel
            Node next = null; // proximo null

            while(cur != null) // enquant nao encontro nulo na lista vou percorrer
            {
                next = cur.next; //atribui 3 /
                cur.next = prev; //atribui null /
                prev = cur; //apenas o next esta null mas o node 1 (5) atribui ao prev
                cur = next; //atribui ao cur o resto da lsta // 
            }

            list.head = prev;

        }
    
}
