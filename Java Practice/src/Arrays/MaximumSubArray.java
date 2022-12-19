package Arrays;
public class MaximumSubArray {
    
/* 
 * 
 * Given a non-empty array of integers arr, create a function that returns the sum of the subarray that has the greatest sum.
We don't consider the empty array [] as a subarray.

Example 1:

Input: arr = [2, 3, -6, 4, 2, -8, 3]

Output: 6

Explanation: the maximum subarray is [4, 2], its sum is 6

 */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {2, 3, -6, 4, 2, -8, 3};
       System.out.println( Maximum(arr));

    }

    public static int Maximum(int[] arr)
    {
        //O(n)

        int globalsum = 0;  // Variavel glocal pra somar com a soma local.
        int localsum = 0; //variavel para somar os itens do array e retornar a maior soma

        for(int i =0;i<=arr.length-1;i++)
        {// faco a iteracao da lista

            //qual e maior 2 ou 0 ? retorna 2 pro local sum
            //qual e maior 2 ou 2+3 = 5 ? retorna 5 pro local sum
            //qual e maior -6 ou 5 + -6 = 1 = retorna 1
            //qual e maior 4 ou 1 +  4 = 5 // retorna 5 
            // . . .. . . . . . 
            localsum = Math.max(arr[i], localsum + arr[i]);  // aqui eu retorno a soma de cada item do array somando com a soma local mais item do array
          
            //incremento o localsum com o global sum e vejo qual e o maior no retorno do math.max
            globalsum = Math.max(globalsum, localsum); // faco a soma e retorno qual maior soma 
        }

        return globalsum;
    }
    
}
