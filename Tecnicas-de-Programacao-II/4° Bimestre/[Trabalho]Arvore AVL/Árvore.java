
/**
 * Interface respresentativa com métodos referentes para implementação de árvores.
 * 
 * @author José Ricardo Guidetti Junior
 * @version 10/06/2015
 */
public interface Árvore // Declaração da interface
{
  /** Insere elemento*/
  void inserir(Comparable v);
  /** Remove elemento*/
  void remover(Comparable v); 
  /** Retorna o Nó raiz*/
  Nó retornaRaiz();
  /** Faz comparação da Raiz com o Nó passado por argumento*/
  boolean éRaiz(Nó aComparar);
  /** Retorna quem está a esquerda do Nó passado por paramêtro.*/
  Nó aEsquerda(Nó n);
  /** Retorna o Nó da direita do Nó passado por paramêtro.*/
  Nó aDireita(Nó n);
  /** Verifica se tem algum Nó na Direita, caso sim returna True, se não retorna False. */
  boolean temDireita(Nó n);
  /** Retorna se tem algum nó na Esquerda, caso sim returna True, se não retorna False. */
  boolean temEsquerda(Nó n);
}// fim da Interface.
