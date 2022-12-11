import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    
    public static void main(String[] args) throws Exception {
     
      
        /* Give a noninteger numrows generate first nul rows pascal traingle
         * 
         *             1
         *          1     1
         *          1  2  1
         *         1  3  3  1
         *        1  4  6  4 1
         */

         int numrows = 5;
        
         List<Integer> lista = new ArrayList<>();
         List<List<Integer>> ret = new ArrayList<>();

         //faco iteracao de acordo com o numero de linhas 
         for(int i=0;i<numrows;i++)
         {
            lista.add(0,1); // Lista de numeros 1 na vertical conforme numero de rows

            //comeco pela linha 1 porque a 0 e fixa diante do 1, entao preciso criar 1,1 ; 1,2,1 etc...
            for( int x = 1;   x < lista.size()-1; x++ ) 
            {
                //dentro do for comeco da linha 1 e vou iterando enquanto x for menor que todas as combinacoes possiveis.
                
                //adiciono na lista na posicao do x, aonde a soma e x+x+1  ( exemplo - 1 + 1+2 = 4)
                lista.set(x, lista.get(x)+ lista.get(x+1));
            }

            ret.add(lista);
         }
       
          
    }

}
