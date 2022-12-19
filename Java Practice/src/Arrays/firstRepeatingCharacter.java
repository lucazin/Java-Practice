package Arrays;
import java.util.Hashtable;

public class firstRepeatingCharacter {
    
    /* 
     * Given a string str, create a function that returns the first repeating character.
If such character doesn't exist, return the null character '\0'.

Example 1:

Input: str = "inside code"

Output: 'i'
     * 
     */


    public static void main(String[] args) throws Exception {
        

        System.out.println(CheckRepeated("responsible"));
        
    }

    public static char CheckRepeated (String str)
    {

      //  O(n) time complexity
      //  0(n) space
        //inside code

        /* 
         * 
         * The loop is traversing characters of str, so it does n iterations, and at each iteration, 
         * we are searching for a key in the hash table and eventually inserting a value. And in a hash table, 
         * inserting, searching, and removing have an O(1) cost in average,
         * 
         */

        char ret = '\0';
        char[] arr = str.trim().toCharArray();

        int i = 0;
        int j = arr.length-1;
        
        Hashtable check = new Hashtable<>();

        while(i<=j)
        {
            if(check.containsKey(arr[i]))
            {
                    ret = arr[i];
                    break;
            }
            else
            {
                check.put(arr[i], i);
                i++;
            }     
        }

        return ret;
    }

}
