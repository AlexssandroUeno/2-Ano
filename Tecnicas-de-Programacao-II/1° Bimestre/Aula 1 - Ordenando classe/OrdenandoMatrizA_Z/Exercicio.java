import java.util.Arrays;

/**
 * Write a description of class Exercicio here.
 * 
 * @author Jose Ricardo
 *
 */
public class Exercicio
{
    public static void main(String[]args)
    {
        int numeros[] = {9,5,10,11,1};
        int x = 0;
        System.out.println("Numeros Antes: ");
        for (int i = 0;i<numeros.length;i++ ) 
        {
            System.out.println(numeros[i]);
        }

        for(int i = 0; i<=3;i++)
        {
            for(int j = (i+1);j<=4;j++)
            {       
               if(numeros[i] > numeros[j])
               {
                    x = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = x;
               }    
           }
        }
        System.out.println("Numeros depois: ");
        for(int i = 0;i < numeros.length;i++)
        {
            System.out.println(numeros[i]);
        }

    }
}
