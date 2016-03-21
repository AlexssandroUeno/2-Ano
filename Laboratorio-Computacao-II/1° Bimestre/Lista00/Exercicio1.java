
/**
 * Escreva a descrição da classe Exercicio1 aqui.
 * 
 * Achando o fibonacci por recursividade
 * Recursividade é a definição de uma subrotina (função ou método) que pode invocar a si mesma.
 *   //function fib(int n)
 *      //se n<2 entao
 *         retorne n;
 *        seNao
 *          retorne fib(n-1) + fib(n-2); 
 *      //fimSe
 *   //fimFunction
 */
public class Exercicio1
{
   
    public static int metodo(int fib) 
    {       
       if(fib < 2)
       {
           return fib;
       }
       else
       {
           return (metodo(fib - 1) + metodo(fib-2));
       }
      
    }

}
