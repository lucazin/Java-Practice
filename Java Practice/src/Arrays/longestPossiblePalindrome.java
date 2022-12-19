package Arrays;
import java.util.HashMap;

public class longestPossiblePalindrome {

    /*
     * 
     * Given a string str made of alphabetical letters only, create a function that returns the length of the longest palindrome string that can be made from letters of str

Example 1:

Input: str = "abbaba"

Output: 5

Explanation: one of the longest palindromes that can be made is "baaab", its length is 5

Example 2:

Input: str = "abbaaa"

Output: 6

Explanation: one of the longest palindromes that can be made is "baaaab", its length is 6

Example 3:

Input: str = "abbabab"

Output: 7

Explanation: one of the longest palindromes that can be made is "bbaaabb", its length is 7

Example 4:

Input: str = "abdccdceeebebc"

Output: 13

Explanation: one of the longest palindromes that can be made is "eedccbabccdee", its length is 13
     * 
     * 
     */

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String str = "abbaba";
        System.out.println(PalindromeLongest(str));

    }

    public static int PalindromeLongest(String s)
    {
        //Input: str = "abbaba"
        //1 check the sequencs of words

        //O(n)

        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
    
}
