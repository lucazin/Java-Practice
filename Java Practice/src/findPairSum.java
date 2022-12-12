import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class findPairSum {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        int[] arr =  {4, 5, 1, -3, 6};

        int target = 11;

        System.out.println(hashmap_solution(arr,target));

    }


    public static boolean hashmap_solution(int[] arr,int target)
    {

        //O(n) Time Coplexity

        /* 
         * 
         * The loop is traversing elements of arr, so it does n iterations, and at each iteration, we are searching for a key in the hash table and eventually inserting a value. And in a hash table, inserting, searching, and removing have an O(1) cost in average, so:

T(n) = n*O(1) = O(n)

Space complexity: O(n)

         */

      Hashtable hs = new Hashtable<>();
      hs.clear();

      for(int i=0;i<=arr.length-1; i++)
      {
        if(hs.containsKey(target - arr[i]))
            return true;
        else
            hs.put(arr[i], i);
      }

        return false;
    }

    public static boolean GetSumValuesCheck(int[] arr,int target)
    {


        // O(nlogn)


        int i=0;
        int j = arr.length-1;

       Arrays.sort(arr); // O(nlogn)

        while(i < j)
        {
            if(arr[i] + arr[j] == target)
                return true;
            else if(arr[i] + arr[j] < target)
                i++;
            else
                j--;
        }

        return false;
    }
    
}
