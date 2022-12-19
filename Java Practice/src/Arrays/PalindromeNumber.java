package Arrays;
public class PalindromeNumber {
    

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");


        int x = 434;
        
        System.out.println(PalidromeNum(x));
        System.out.println(PalindromeIntegerStr(x));
        
    }

    public static boolean PalindromeIntegerStr(int x)
    {
        if(x < 0)
        return false;

        String str = Integer.toString(x);
        for(int i =0; i<str.length() / 2; i++)
        {
            if(str.charAt(i) != str.charAt(str.length()-1 -i))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean PalidromeNum(int x)
    {
        if(x < 0 || (x != 0 && x % 10  == 0))
            return false;

        int num = x;
        int y = 0;

        while(num != 0)
        {
            int resto = num % 10 ;
            num = num / 10;
            y = y * 10 + resto;

        }

        return y == x;
    }

}
