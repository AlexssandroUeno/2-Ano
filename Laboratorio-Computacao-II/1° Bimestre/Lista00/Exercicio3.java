
/**
 * Escreva a descrição da classe Exercicio3 aqui.
 * 
 * @author Thelokys
 */
/*
Faça um método estático na classe Principal que receba uma palavra por parâmetro,
verifique se ela é um palíndromo 1 e retorne se é ou não.
* 'Exercicio4.java' tem uma explicação
 */

public class Exercicio3
{
    public static void getPalidromo(String palavra)
    {
        int j = palavra.length() -1;
        int aux = 0;

        for(int i = 0; i<palavra.length(); i++)
        {

            if(palavra.charAt(i) == (palavra.charAt(j--)))
            {   
                aux++;
            }
        }
    if(aux == palavra.length())
        {
            System.out.println("É um palídromo a palavra: "+palavra);
        }else{
            System.out.println("Não é um palídromo a palavra: "+palavra);
        }

    }

}
