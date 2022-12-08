public class ValidStringPalndrome {

    public static void main(String[] args) throws Exception {
        
        System.out.println(ProcessStringPL("A man, a plan, a canal: Panama"));
    }


    public static boolean ProcessStringPL(String str)
    {
     
/*
 * Recebe uma string qualquer.
 * transformo em minusculo e tiro os caracteres especiais
 * transforma a string em uma array - de char
 * cria dois ponteiros para verificar a array de letras
 * ponteiro i comeca do 0 e ponteiro j comeca do final da string.
 * faco um while comparando  posicao inicial com posicao final 
 * A cada iteracao incremento ponteiro i e decremento ponteiro j
 * se a comparacao for diferente retorna false.
 
 */

       str = str.replaceAll("\\p{Cntrl}","").replaceAll(" ","");

        char[] arr = new  char[str.length()];
        int i = 0;
        int j = str.length()-1;

        arr = str.toLowerCase().toCharArray();

        while(i <= j)
        {
            if(!String.valueOf(arr[i]).toString().equals(String.valueOf(arr[j]).toString()))
              return false;
            
            i++;
            j--;
        }

        return true;
    }


    public static boolean ReverseString(String strOriginal)
    {
         String reversedString ="";

         strOriginal = strOriginal.replaceAll("[^a-zA-Z0-9]", " ").trim();

         for(int i=strOriginal.length()-1;i > 0;i--)
            reversedString += strOriginal.charAt(i);
         
        
        if(reversedString.equals(strOriginal))
            return true;

        return false;
    }
    
}
