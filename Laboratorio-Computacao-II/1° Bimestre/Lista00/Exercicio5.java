
/**
 * Write a description of class Exercicio5 here.
 * 
 * @author Thelokys
 *
 * Faça um método estático na classe Principal que escreva na tela todos os números
 * pares de 1 a 10000 que são palíndromos.
 */
public class Exercicio5
{
   public static void main()
   {
    /** Contador para ir de 1 até 10000*/
        for(int i = 1;i < 10001;i++)
        {
            /** Verificando se o número é par*/
           if(((i % 2) == 0) && (i > 8))
           {

                String numeros = Integer.toString(i); // Passamos o numero recebido para uma String     
                /**O resto ja foi explicado tudo no arquivo 'Exercicio4.java' */
                int wordSize = numeros.length() - 1;
                int aux = 0;
                for(int k = 0; k<numeros.length(); k++)
                {
                    if(numeros.charAt(k) == (numeros.charAt(wordSize--)))
                    {   
                        aux++;
                    }
                }
                if(aux == numeros.length())
                    {
                        System.out.println("É um palídromo o número: "+numeros);
                    }
                    /** Apaguei pq não diz nada sobre mostrar os que não são palídromos, mas qualquer coisa está ali*/
                    // else{
                    //     System.out.println("Não é um palídromo o número: "+numeros);
                    // }
           }                
        }        
    }
   
}
