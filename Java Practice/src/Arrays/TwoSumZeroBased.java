package Arrays;
import java.util.Arrays;

public class TwoSumZeroBased {


    public static void main(String[] args) throws Exception {
        

        int[] numbers = {2,7,11,15};
        int[] result = new int[2];
        int target = 9;

        // Two sums of elemets of array that match with the target, but return the index differt than 0.
        // Tecnica utilzada sera 2 ponteiros um no comeco do array e outro no final do array e usando while para verificar
        // se a soma for maior que o target decrementa o final senao incrementa o inicio.

        int start = 0;
        int end = numbers.length-1; //3

        while(start < end)
        {
            int sum  = numbers[start] + numbers[end];
            if(sum == target)
            {
                result[0] = start + 1; // 0+1 = 1
                result[1] = end + 1;  // 1+1 = 2
                System.out.println(Arrays.toString(result));
                return;
            }
            else if(sum > target)
                end--; //2 // 1
            else
                start++;
        }

        System.out.println(Arrays.toString(result));
    }
    
}
