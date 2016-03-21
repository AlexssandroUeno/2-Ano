/**
* Escreva a descrição da classe Exercicio1 aqui.
*
* @author Thelokys
* 
*/

//Faça um método estático na classe Principal que receba, como parâmetro, um vetor
//de números inteiros e retorne o somatório de seus valores

public class Exercicio2
{
	
   public static int getSomatoria(int[]numeros)
   {
   	int somatoria = 0;
       	for(int i = 0; i<numeros.length;i++)
       	{
       		somatoria += numeros[i];
       	}
   	return somatoria;
   }
}
