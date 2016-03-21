package Mensuraveis.Ordenacao;
/**
 * Na classe QuicksortMensuravel, encontra-se o metodo de ordenacao Quicksort,
 * uma ordenacao aonde dividimos um arranjo em modo recursivo, 
 * em que nessa divisao teremos duas partes movendo os numeros menores de um 
 * lado e os maiores para outro lado e no final juntamos tudo.
 * 
 * @Author Jose Ricardo Guidetti Jr
 * @Version 25/06/2015
 * @see OrdenacaoMensuravel
 */
public class QuicksortMensuravel extends OrdenacaoMensuravel {
    
    @Override
    public void ordenar(int[] arranjo) {
         sort(arranjo, 0, arranjo.length - 1);
    }
  
    /**
     * No metodo sort,aqui Eh aonde aplicamos o quicksort atraves de uma indutiva relizada varias vezes,
     * quebrando o vetor em partes e ordenando-o.
     * 
     * @Param vetor[], referencia do vetor que sera ordenado.
     * @Param inicio, referencia do inicio do vetor para fins de ordenacao.
     * @param fim, referencia final do vetor para fins de ordenacao.
     */
   private void sort(int[] vetor, int inicio, int fim) {
      if (inicio < fim) {
         int posicaoPivo = separar(vetor, inicio, fim);
         sort(vetor, inicio, posicaoPivo - 1);
         sort(vetor, posicaoPivo + 1, fim);
      }
   }
 
   /**
    * No metodo separar, temos as referencias do inicio e fim (dois pivos)para fazer 
    *suas respectivas trocas quando eles tiverem no mesmo indice.
    * 
    * @param vetor, referencia do vetor que ira ser ordenado.
    * @param inicio, referencia inicial do vetor.
    * @param fim, referencia final do vetor.
    * 
    * @return f, referencia do indice do vetor que ira ser separado.
    */
   private static int separar(int[] vetor, int inicio, int fim) {
      int pivo = vetor[inicio];
      int i = inicio + 1, f = fim;
      while (i <= f) {
         if (vetor[i] <= pivo) {
            i++;
         }else if (pivo < vetor[f]) {
            f--;
         }else {
            int troca = vetor[i];
            vetor[i] = vetor[f];
            vetor[f] = troca;
            i++;
            f--;
         }
      }
      vetor[inicio] = vetor[f];
      vetor[f] = pivo;
      return f;
   }
}