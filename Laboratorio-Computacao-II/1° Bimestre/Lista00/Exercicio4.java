/**
 * Escreva a descrição da classe Exercicio3 aqui.
 * 
 * @author Thelokys
 * Faça um método estático na classe Principal que receba um conjunto de palavras em
 *um arranjo (vetor) e escreva na tela apenas as palavras que são palíndromos.
 */
public class Exercicio4
{
   public static void main(String[]args)
   {
        /** Primeiro "for" é para percorrer o conjunto de palavras (o  vetor 'args')*/
        for(int i = 0; i < args.length;i++)
        {
            /**Temos aqui uma variável auxiliar que iremos carrega-la mais à frente*/
            int aux = 0;
            /** A variável wordSize ela pega o índice da última letra da palavra*/
            int wordSize = args[i].length() - 1;
            /** Segundo "for" é para percorrer a palavra que esta dentro do vetor args*/
            for(int j = 0; j < args[i].length();j++)
            {
                /** Verifica se a palara é um palidromo*/;
                if(args[i].charAt(j) == args[i].charAt(wordSize--))
        /* lermos então as letras de trás para frente,
         * e verificamos se todas as letras são iguais de acordo com os seus índices.
         * E para cada letra igual carregamos um contador.
         * EX:Índice  0  1  2  3  4
         *   Letra   [A][R][A][R][A] 
         *         SE(Letra[0] == Letra[4]) entao   
         *         	  carregamos uma variavel;
         *         fimSe
 		 *  Assim estando verificando se A==A, e depois R==R, A==A , R==R e A==A
 		 *  Ao todo a variável aux tera carregado 5 vezes, ou seja o mesmo tamanho da palavra.
         */
                {
                    aux++;
                }
            }
            /* Assim no final se todas as letras forem iguais,
             * ou seja, a palavra é um palídromo,a variável "aux" ela terá então,
             * o mesmo valor do tamanho da palavra,
             * logo em seguida temos um if que verifica essa lógica.
            */
                 if(aux == args[i].length())
                {
                    System.out.println("É um palídromo a palavra: "+args[i]);
                }
                else
                {
                    System.out.println("Não é um palídromo a palavra: "+args[i]);
                }
        }

   }

}
