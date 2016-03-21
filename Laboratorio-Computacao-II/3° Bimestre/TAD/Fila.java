
/**
 * Write a description of interface Fila here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Fila<T>
{
   /** O método enfileirar recebe um elemento e 
    * adiciona ao final da fila um elemento.
    * Com um desempenho de O(1)
    * 
    * 
    * @param e, Referência do elemento para ser adicionado.
    * 
    */
   void enfileira(T e);
   
   /** O método desenfileirar remove o primeiro elemento da fila
    * e depois o retorna.
    * Com um desempenho de O(1)
    * 
    * @return T, retorna o elemento que foi removido
    * 
    */
   T desenfilerar();
   
   /** O método primeiro, mostra o primeiro elemento inserido na fila toda. 
    * Com um desempenho de O(1)
    * 
    * @return T, retorna o primeiro elemento da fila.
    * 
    */
   T primeiro();
   
   /** O método último, mostra o último elemento adiciona na fila.
    * Com um desempenho de O(1)
    * 
    * @return T, retorna o ultimo elemento da fila.
    * 
    */
   T ultimo();
}
