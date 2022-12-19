package LinkedList;
public class PalindromeLinkedList {

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
    
        /* 
         *
 Given a linked list of integers list, create a boolean function that checks if it's a palindrome linked list in constant space complexity.

Example 1:

Input: list = 1 -> 4 -> 6 -> 5 -> 6 -> 4 -> 1 -> null

Output: true

Example 2:

Input: list = 8 -> 3 -> 1 -> 8 -> null

Output: false

Example 3:

Input: list = 6 -> null

Output: true
         * 
         * 
         * The reverseList() function has an O(n) cost where n is the number of nodes of the linked
         *  list we gonna reverse

The first loop does n/2 iterations because fast is jumping by 2 nodes at each iteration

slow = reverseList(slow) costs n/2 because we are reversing the right half of the linked list

Then we are comparing two linked lists of n/2 nodes (the left half and the right half), 
so the last while loop does n iterations, and each iteration has an O(1) cost

         * 
         */
        
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        //Input: list = 1 -> 4 -> 6 -> 5 -> 6 -> 4 -> 1 -> null
        //Output: true

        // 1 4 6 8 6 4 1 
        // 1 4 6 8 6 4 1

        Node n1 = new Node(1);  
        Node n2 = new Node(4); n1.next = n2;
        Node n3 = new Node(6); n2.next = n3;
        Node n4 = new Node(5); n3.next = n4;
        Node n5 = new Node(6); n4.next = n5;
        Node n6 = new Node(4); n5.next = n6;
        Node n7 = new Node(1); n6.next = n7;
        Node n8 = null;  n7.next = n8;

        LinkedList root = new LinkedList(n1);

        System.out.println(checkPalindrome(root));

    }

    public static boolean checkPalindrome(LinkedList root)
    {
        //On

        //Se os 3 utimos forem iguais aos 3 primeiros  é palindrome

        //create 2 pointers pointing to start one slow and one fast
        Node slow = root.head;
        Node fast = root.head;

        //set position of pointers for slow and fast, slow pointer in the end will be in the middle of linkedlist lenght/2
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse linked list
        //Get the linkedlist that slow pointer stop (in the middle) and reverse linkedlist
        Node reversed = reverse(slow);
       
        //while reverse not found null i compare reversed node in order with original linkedlist 
        //in order and increment the next for loop continue
        while (reversed != null)
        {
            if(reversed.data != root.head.data)
                return false;

            reversed = reversed.next;
            root.head = root.head.next;
        }

    
        return true;
    }
    

    public static  Node reverse (Node node)
    {
        //On

        //receive linkedlist node 5 - 6 - 4 - 1 - null
        Node retorno = null;
       
        //traversal the node while node is not null, if is null the node is inverted
        while(node != null)
        {
            Node temp = node.next;  //
            node.next = retorno;  //2
            retorno = node;
            node = temp;
        }

        return retorno;
    }
}
