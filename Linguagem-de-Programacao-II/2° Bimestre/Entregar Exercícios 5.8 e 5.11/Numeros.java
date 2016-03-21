
/**
 * <p>A classe Numeros contem um total de 8 metodos para fins de comparacoes de numeros,
 * e cada metodo mostrando ou o menor ou o maior valor daqueles numeros passado por parametro.</p>
 * <p>Temos tambem a classe Auxiliar, nela contem todas as funcoes para ser feita essa comparacao e achar o maior ou menor numero.</p>
 */ 
import java.util.ArrayList; 
/**
 * 
 * @Author Thelokys
 * @Version 04/27/2015
 */
public class Numeros//Declaracao da classe
{
     static double maior;
     static double menor;
    /**
     * Metodo maiorDeDois mostra a partir de dois valores o maior numero entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * 
     * @return Double - retorna o maior numero
     */
    public static double maiorDeDois(double a, double b)
    { 
       if(a >= b)
       {
           return a;
       }
       return b;
    }
 
     /**
     * Metodo menorDeDois mostra a partir de dois valores o menor numero entre eles.
     *     
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * 
     * @return Double - retorna o menor numero
     */
    public static double menorDeDois(double a, double b)
    {
       if(a <= b)
       {
           return a;
       }
       return b;
    }
    
     /**
     * Metodo maiorDeTres mostra a partir de tres valores o maior numero entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * @param c, numero para ser comparado
     * 
     * @return Double - retorna o maior numero
     */
    public static double maiorDeTres(double a, double b, double c)
    {
        double []arranjo = {a, b ,c};
        for(int i = 0; i <  arranjo.length; i += 1){
            if( i == 0 ) {
              maior = arranjo[0];
            }else if(maior < arranjo[i]) {
                maior = arranjo[i];
            }
        }
        return maior;
    }
    
     /**
     * Metodo menorDeTres mostra a partir de tres valores o menor numero entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * @param c, numero para ser comparado
     * 
     * @return Double - retorna o menor numero
     */
    public static double menorDeTres(double a, double b, double c)
    {   
      double []arranjo = {a, b ,c};
        for(int i = 0; i <  arranjo.length; i += 1){
            if( i == 0 ) {
                menor = arranjo[0];
            }else if(menor > arranjo[i]) {
                menor = arranjo[i];
            }
        }
        return menor;
    }
    
     /**
     * Metodo maiorDeQuatro mostra a partir de quatro valores o maior numero entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * @param c, numero para ser comparado
     * @param d, numero para ser comparado
     * 
     * @return Double - retorna o maior numero
     */
    public static double maiorDeQuatro(double a, double b, double c, double d)
    {
        double []arranjo = {a, b ,c, d};
        for(int i = 0; i <  arranjo.length; i += 1){
            if( i == 0 ) {
              maior = arranjo[0];
            }else if(maior < arranjo[i]) {
                maior = arranjo[i];
            }
        }
        return maior;
    }
    
     /**
     * Metodo menorDeQuatro mostra a partir de quatro valores o menor entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * @param c, numero para ser comparado
     * @param d, numero para ser comparado
     * 
     * @return Double - retorna o menor numero
     */
    public static double menorDeQuatro(double a, double b, double c, double d)
    {
        double []arranjo = {a, b ,c,d};
        for(int i = 0; i < arranjo.length; i += 1){
            if( i == 0 ) {
                menor = arranjo[0];
            }else if(menor > arranjo[i]) {
                menor = arranjo[i];
            }
        }
        return menor;
    }
    
     /**
     * Metodo maiorDeCinco mostra a partir de cinco valores o maior entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * @param c, numero para ser comparado
     * @param d, numero para ser comparado
     * @param e, numero para ser comparado
     * 
     * @return Double - retorna o maior numero
     */
    public static double maiorDeCinco(double a, double b, double c, double d, double e)
    {
        double []arranjo = {a, b ,c, d, e};
        for(int i = 0; i <  arranjo.length; i += 1){
            if( i == 0 ) {
                maior = arranjo[0];
            }else if(maior < arranjo[i]) {
                maior = arranjo[i];
            }
        }
        return maior;
    }
    
     /**
     * Metodo menorDeCinco mostra a partir de cinco valores o menor entre eles.
     * 
     * @param a, numero para ser comparado
     * @param b, numero para ser comparado
     * @param c, numero para ser comparado
     * @param d, numero para ser comparado
     * @param e, numero para ser comparado
     * 
     * @return Double - retorna o menor numero
     */
    public static double menorDeCinco(double a, double b, double c, double d, double e)
    {
         double []arranjo = {a, b ,c,d ,e};
        for(int i = 0; i <  arranjo.length; i += 1){
            if( i == 0 ) {
                menor = arranjo[0];
            }else if(menor > arranjo[i]) {
                menor = arranjo[i];
            }
        }
        return menor;
    }
}
