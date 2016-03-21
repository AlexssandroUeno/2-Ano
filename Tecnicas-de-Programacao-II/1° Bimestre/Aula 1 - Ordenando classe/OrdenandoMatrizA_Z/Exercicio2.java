import java.util.Scanner;
/**
 * Write a description of class Exercicio2 here.
 * 
 * @author Jose Ricardo 
 * 
 */
public class Exercicio2
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner (System.in);// class scanner, para assim ler o teclado
        String [][] sala = new String [2][3]; ; // matriz da sala, com linhas 6 e colunas 4

        String []salaAux = new String [sala.length * sala[0].length]; // um vetor que nos auxilia na contrução da ordem com o tamanho total da matriz
        String aux = ""; // variaivel 'aux', como de sempre ¬¬, ela irá nos ajudar mais para frente na troca de nomes.
        int indice = 0;  // variaivel 'indice', que nos ajudara em percorrer cada letra de cada palavra.
        // Ex:        [J][o][s][u]e, [J][o][s][e], [J][u]mento
        // e assim organizando por ordem alfabetica ficando assim:
        //->                Jose,     Josue,    Jumento

        /** Carrega matriz*/
        System.out.println("Preenchendo a sala: ");
        for(int row = 0 ; row <sala.length; row++)
        {
            for(int coll = 0; coll < sala[row].length; coll++)
            {
                sala[row][coll] = in.next();
                salaAux[indice] = sala[row][coll]; 
                indice++;
            }
        }

        System.out.println('\f'); //limpar tela

        /** Mostra matriz*/
         System.out.println("\n*----------Sala SEM organização ----------*\n");
        for(int row = 0 ; row <sala.length; row++)
        {
            for(int coll = 0; coll < sala[row].length; coll++)
            {
                 
               System.out.print(sala[row][coll]+ " | ");     
            }
            System.out.print("\n\n");
        }
        
        /** Ordenando a  matriz*/

        System.out.println("\n*----------Sala Organizada por ordem alfabetica ----------*\n");
        //o método seguinte se chama "bubblet sort",
        // um método simples de verificar se um numero é maior que outro, e assim trocando-os de lugar.
        //Video a seguir mostra esse algoritmo em prática.
        //link(RECOMENDADO): https://www.youtube.com/watch?v=lyZQPjUT5B4
        for(int i = 0; i < salaAux.length;i++)  
        {  
            for(int j = (i + 1); j < salaAux.length;j++)  
            {  
              int index = 0;
                if(salaAux[i].charAt(index) > salaAux[j].charAt(index))  
                {  
                    aux = salaAux[i];  
                    salaAux[i] = salaAux[j];  
                    salaAux[j] = aux;  
                }
                //Comparando primeira letra
                else
                {
                /** Se a palavra não for igual verificamos a proxima letra*/   
                   if(!salaAux[i].equals(salaAux[j]))
                    {
            //caso a letra ainda continua sendo igual, temos um laço que incrementa indo para próxima letra, e assim por diante.
                        while(salaAux[i].charAt(index) == salaAux[j].charAt(index))
                        {
                            index++;
                            if(salaAux[i].length() == index || salaAux[j].length() == index)
                            // verificação para não estourar o index
                            {
                                --index;
                                break;
                            }
                        }
                        
                        if(salaAux[i].charAt(index) > salaAux[j].charAt(index))  
                        {  
                            aux = salaAux[i];  
                            salaAux[i] = salaAux[j];  
                            salaAux[j] = aux;  
                        }
                    }
                }  
            }   
        }
        /** A matriz/Sala já ordenada, passamos os valores do vetor 'salaAux' para a matriz 'sala'*/
        int aux2 = 0;  
       for(int row = 0; row < sala.length; row++)    
        {    
             for(int coll = 0;coll < sala[row].length; coll++)    
             {    
                  sala[row][coll] = salaAux[aux2];    
                  aux2++;    
             }    
        }
        /** Mostrando a matriz*/
        for(int row = 0 ; row <sala.length; row++)
        {
            for(int coll = 0; coll < sala[row].length; coll++)
            {
                 
               System.out.print(sala[row][coll]+ " | ");     
            }
            System.out.print("\n\n");
        }          
    } 
}    
   

