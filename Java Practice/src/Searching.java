public class Searching {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int[] arr = {2,5,6,7,3,9,10,33};

        int[] arr2 = {2,3,5,9,10,19,20,33,50};

        int target = 9;

        System.out.println("Busca linar - Lista não ordenada");
        SearchLinear(arr,target);

        System.out.println();
        System.out.println();

        System.out.println("Busca linar - Funciona com Lista ordenada");
        Search_BinarySearch(arr2,target);
    }


    public static void Search_BinarySearch(int[] arr, int target)
    {
        //O (log n)
        int i=0;
        int j = arr.length-1;

        int middle_array = (i+j) / 2;  
        System.out.println("Meio - " + String.valueOf(middle_array));

        while(arr[middle_array] != target && i<=j)
        {
            if(target < arr[middle_array])
                j = middle_array -1;
            else
                i = middle_array + 1;

            middle_array = (i+j) /2;

            if(arr[middle_array] == target)
            {
                System.out.println();
                System.out.print(" Encontramos o valor " + target);
                break;
            }
        }
    }

    public static void SearchLinear(int[] arr, int target)
    {
        // Usamos este metodo de searching quando a lista nao é ordenada e tem que passar por todos os itens

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == target)
            {
                System.out.print("Encontramos o valor " + target);
                break;
            }
        }

    }
}
