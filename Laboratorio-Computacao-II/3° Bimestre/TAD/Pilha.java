
/**
 * Write a description of interface Pilha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Pilha<T>
{
    /**
     * Do inglês, push(), o método empilhar apartir de um elemento
     * adiciona-o na última posição pilha, com um desempenho de O(1)
     * 
     * 
     * @param E
     *          Elemento abstrato para inclusão
     * 
     */
    void empilhar(T e);
    
    /**
     * Do inglês, pop(), o método desempilha o último elemento da pilha,
     * retornando o elemento desempilhado, com um desempenho de O(1)
     * 
     * @return T -
     *          Retorna o elemento removido.
     * 
     */
    T desempilhar();
    
    /**
     * Do inglês, peek(), o método mostra o primeiro elemento, 
     * com um desempenho de O(1) 
     * 
     *@return T -
     *          Retorna o topo da pilha 
     * 
     */
    T olhar();
}
