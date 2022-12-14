public class peakfind {


    /*
 Given a non-empty array of integers arr, create a function that returns the index of a peak element.
  We consider an element as peak if it's greater than or equal to its neighbors,
   the next and previous element (assume that arr[-1] and arr[n] are equal to -∞). 
   And if there are multiple peaks in arr, just return the index of one of them.

Example 1:

Input: arr = [4, 5, 8, 3]

Output: 2

Explanation: arr[2] is a peak element because it's greater than or equal to arr[1], and greater than or equal to arr[3]
     * 
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {-2147483648,-2147483647};
        System.out.println(findpeak2(arr));
    }

    public static int findpeak2(int[] arr)
    {
        //Divide Conquest 

        /*
         * 
         * left and right start at the extremities of arr, but at each iteration, 
         * either left becomes equal to mid+1 or right becomes equal to mid,
         *  so we are dividing the number of remaining elements by 2,
         *  this is why the loop does at most log2_(n) iterations before left and right meet. log2_(n) 
         * because the number of divisions by 2 to go from n to 1 is log_2(n). And each iteration has an O(1) cost, so:
         * 
         */

        //O Logn
        int max = 0;

        int i =0;
        int j = arr.length-1;

        while(i < j)
        {
            int index_mid = ( i + j) / 2;   //indice 3 - valor 3

            if(arr[index_mid] < arr[index_mid+1])
                i = index_mid + 1;
            else
                j = index_mid;
        }

        return max = i;
    }

    public static int findpeak_anterior(int[] arr)
    {

        // O(n)

        int i=0;
        int j = arr.length-1;

        int peak_i= 0;
        int peak_j = 0;
        int peak = 1;

        //Brute force
        while(i<=j)
        {   

            if(arr.length > 1)
            {
                if(i == 0)
                {
                    if(arr[i] > arr[i+1]  && ( arr[i] > peak_i))
                        peak_i = arr[i];
                }
                else if(i > 0)
                {
                    if(arr[i] > arr[i+1]  || arr[i] > arr[i-1]  && ( arr[i] > peak_i))
                         peak_i = arr[i];
                }
                   
                if(j == arr.length-1)
                {
                    if(arr[j] > arr[j-1]  && ( arr[j] > peak_j))
                        peak_j = arr[j];
                }
                else if(j < arr.length-1)
                {
                    if(arr[j] > arr[j+1]  || arr[j] > arr[j-1] && ( arr[j] > peak_j))
                         peak_j = arr[j];
                }
            }
            else
            {
                peak_i = arr[i];
                peak_j = arr[j];
            }
           
                i++;
                j--;
        }

        i = 0;
        if(peak_i == 0 && peak_j == 0)
            peak = 0;
        else
        {
            while(i <= arr.length-1)
            {
                if(arr[i]== Math.max(peak_i, peak_j) )
                {
                        peak = i;
                        break;
                }
                i++;
            }
        }

        return peak;
    }
}

