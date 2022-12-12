import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;

public class RemoveDuplicates {

    public static void main(String[] args) throws Exception {
       
        /* 
         * Given an array of integers arr, create a function that returns an array containing the values of arr without duplicates (the order doesn't matter).

            Example 1:

            Input: arr = [4, 2, 5, 3, 3, 1, 2, 4, 1, 5, 5, 5, 3, 1]

            Output: [4, 2, 5, 3, 1]
         */

         int[] arr = {4, 2, 5, 3, 3, 1, 2, 4, 1, 5, 5, 5, 3, 1};


         RemoveDup2(arr);


    }

    public static int[] RemoveDup2(int[] arr)
    {

        // O(n)
        
        Hashtable<Integer,Integer> map = new Hashtable<>();
        boolean find = false;

        for(int i=0;i<=arr.length-1;i++)
        {
            if(map.containsValue(arr[i]))
                find = true;
            else
                map.put(i,arr[i]);
        }

        // get the values of the `HashMap` returned as an array
        int[] values = Arrays.stream( map.values().toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();


        return values;
    }

    
    public static int[] RemoveDup1 (int[] arr)
    {

        int i=0;
        int j = arr.length-1;

        Hashtable<Integer,Integer> map = new Hashtable<>();
       
        while(i<j)
        {
           if(!map.containsValue(arr[i]))
           {
               map.put(i,arr[i]);
               i++;
           }
           else
               i++;
        }



       int[]  finalarr = new int[map.values().size()];
       int x = 0;
       for (int valor : map.values()) 
       {
           finalarr[x] = valor;
           x++;
       }
             
        System.out.println(Arrays.toString(finalarr));

        return finalarr;
    }

    
}
