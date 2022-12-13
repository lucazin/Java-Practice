import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatinChar {

    /*
     * 
     *   Given a string str made of alphabetical letters only, create a function that returns the length of the longest substring without repeating characters.

Example 1:

Input: str = "abcdbeghef"

Output: 6

Explanation: the longest substring without repeating characters is "cdbegh", its length is 6

     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String str = "abcdbeghef";
        System.out.println(CheckSubstring(str));
    }
    
    public static int CheckSubstring(String str)
    {
        int num = 0;
        int i=0;
    
        char[] arr = str.toCharArray();

        HashMap<Character,Integer> map = new HashMap<>();

        for( i=0; i<= arr.length-1;i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1 ); 

        num = (int)(Arrays.asList(map.keySet().toArray()).stream().count());

        return num;
    }
}
