package Arrays;
import java.util.HashMap;

public class FindDuplicate {

    /*
     * 
     *  Given an array of integers arr that contains n+1 elements between 1 and n inclusive, create a function that returns the duplicate element (the element that appears more than once). Assume that:
- There is only one duplicate number
- The duplicate number can be repeated more than once

Example 1:

Input: arr = [4, 2, 1, 3, 1]

Output: 1
     * 
     * 
     * 
     * if sorted array the time complexity vai ser O(nlogn) 
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {1,2,2};

        System.out.println(CountDuplicate(arr));
    }

    public static int CountDuplicate(int[] arr)
    {
        //O(n) just one loop

        int count = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0 ; i<=arr.length-1; i++)
        {
            if(map.containsValue(arr[i]))
                count++;
            else
                map.put(i, arr[i]);
        }

        return count;
    }
    
}
