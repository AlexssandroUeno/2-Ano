import java.util.Arrays; 
import java.util.Scanner;
/**
 * Write a description of class Exercicio2 here.
 * 
 * @author Jose Ricardo 
 * 
 */
public class MelhorandoExercicio2
{

    public static void main(String[] args) 
    {
        Scanner in = new Scanner (System.in);// class scanner, para assim ler o teclado
        String [][] sala = new String [2][3]; ; // matriz da sala, com linhas 6 e colunas 4
        String []salaAux = new String [sala.length * sala[0].length]; // um vetor que nos auxilia na contrução da ordem com o tamanho total da matriz
        String aux = ""; // variaivel 'aux', como de sempre ¬¬, ela irá nos ajudar mais para frente na troca de nomes.
        int indice = 0;  // variaivel 'indice', que nos ajudara em percorrer cada letra de cada palavra.
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
        System.out.println('\f'); //limpar 
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
        
        /** http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html     Documentação*/
        Arrays.sort(salaAux); //usando a Classe do próprio java que contem o metodo sort, nesse método automaticamente ordena sozinho
        //É facil usar o sort, mas qual é a graça ?
        
        /** A matriz/Sala já ordenada, passamos os valores do vetor 'salaAux' para a matriz 'sala'*/
        indice = 0;  
       for(int row = 0; row < sala.length; row++)    
        {    
             for(int coll = 0;coll < sala[row].length; coll++)    
             {    
                  sala[row][coll] = salaAux[indice];    
                  indice++;    
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
   

