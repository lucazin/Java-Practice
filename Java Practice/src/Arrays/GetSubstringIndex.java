package Arrays;
import java.util.ArrayList;
import java.util.List;

public class GetSubstringIndex {
/*
Given two strings str1 and str2, create a function that returns the first index where we can find str2 in str1. If we cannot find str2 in str1, the function must return -1.
Try to solve the problem without using the built-in .indexOf() method.

Example 1:

Input: str1 = "inside", str2 = "side"

Output: 2

Explanation: we can find "side" in "inside" by starting from the index 2

Example 2:

Input: str1 = "inside", str2 = "in"

Output: 0

Explanation: we can find "in" in "inside" by starting from the index 0

Example 3:

Input: str1 = "inside", str2 = "code"

Output: -1

Explanation: we can't find "code" in "inside"

*/    

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        System.out.println(Newcode("mississippi", "issip"));
    }


    public static int Newcode(String haystack, String needle)
    {
        if (needle == null) {
            return 0;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            if (haystack.equals(needle)) {
                return 0;
            }
            return -1;
        }
        int len = haystack.length() - needle.length();
        for (int i=0; i<=len; i++) {
            String target = haystack.substring(i, i + needle.length());
            if(needle.equals(target)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int GetSub(String str1,String str2)
    {
        //inside
        //side
        //result 2 because side is in position 2 starting s

        char[] arr1 = str1.toCharArray();
        char FirstLetterWord = str2.charAt(0);
        
        int sizeWord = str2.length();
        int indexfound = -1;

        for(int i=0;i<=arr1.length-1;i++)
            if(arr1[i] == FirstLetterWord)
            {
                indexfound = i;
                break;
            }
        
        char[] arr2 = str2.toCharArray();
        int x = indexfound;
        int j = arr1.length-1;

        if(sizeWord > arr1.length)
            indexfound = -1;

        int z = 0;
        while(x <= j && indexfound > -1 )
        {      
            if(arr1[x] != arr2[z])
            {
                indexfound = -1;
                break;
            }

            x++;
            z++;
        }

        return indexfound;
    }
}
