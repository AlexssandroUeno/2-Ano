/**
 * Na classe ÁrvoreBinária que implementa a classe árvore, temos uma representação
 * de uma árvore binária e somente os campos e métodos mais básicos são representados 
 * nessa classe.
 * 
 * @author José Ricardo Guidetti Junior 
 * @version 2015/10/01
 */
public class ÁrvoreBinária implements Árvore //declaração da classe 
                                          //(herdando de Árvore)
{
  /**
   * Declaração dos campos da classe ÁrvoreBinária. 
   */
  private Nó raiz;

  public void inserir (Comparable v)
  {
    Nó aInserir = new Nó (v);
    inserir(this.raiz, aInserir);
  }
  protected Nó inserir (Nó atual, Nó aInserir)
  {
    if (atual == null)
    { // caso raiz for nula, então o Nó à ser inserido tornasse a raiz;
      this.raiz = aInserir;
      return raiz;
    }
    else //caso a raiz não seja nula 
    { //comparamos o valor do nó à ser inserido e o valor do Nó atual.
      if (aInserir.retornaValor().compareTo(atual.retornaValor()) < 0)
      { // Caso o Nó atual seja um valor MAIOR do que o Nó à ser inserido. 
        /**
         * Aqui é aonde funciona a movimentação para inserções.
         */
        if (!temEsquerda(atual))
        { /**Se não tiver a ninguém à esquerda, então inserimos lá !!! */
          atual.mudaEsquerdaPara(aInserir);
          aInserir.mudaPaiPara(atual);
        }
        else
        { /** Se tiver alguém para esquerda então caminhamos mais um pouco para esquerda. */
          inserir (aEsquerda(atual), aInserir);
        }
      }
      
      else if (aInserir.retornaValor().compareTo(atual.retornaValor()) > 0)
      {
        if (!temDireita(atual))
        { /**Se não tiver a ninguém à direita, então inserimos lá !!! */
          atual.mudaDireitaPara(aInserir);
          aInserir.mudaPaiPara(atual);
        }
        else
        { /** Se tiver alguém para direita então caminhamos mais um pouco para direita.*/
          inserir (aDireita(atual), aInserir);
        }
      }
      else
      { /*O Nó já existe */
      }
    }
    return aInserir;
  }
  
  public void remover (Comparable v)
  {}

  public void mudaRaizPara (Nó r) {this.raiz = r;}

  /** Retorna a raiz da árvore.*/
  public Nó retornaRaiz () {return raiz;}

  /** 
   * Compara se o Nó passado por parâmetro é o Nó raiz.
   * 
   * @return True ou False -  se for igual retorna True caso contrário retorna false
   */
  public boolean éRaiz (Nó aComparar) {return aComparar == raiz;}

  /**
   * No método aEsquerda mostra quem está a esquerda do Nó passado por parâmetro.
   * 
   * @return Nó -  Retorna o Nó a esquerda, caso não tiver Nó retorna nulo.
   */
  public Nó aEsquerda(Nó n){return n.retornaEsquerda();}

  /** 
   * No método aDireita recebe por parâmetro um Nó para retorna o filho da direita.
   * 
   * @return Nó -  Retorna o Nó direita, caso não tiver Nó retorna nulo.
   */
  public Nó aDireita(Nó n){return n.retornaDireita();}

  /** 
   * Verifica se tem algum Nó na Direita, caso sim retorna true, se não retorna false. 
   * 
   * @return True ou False 
   *                - Caso tenha algum nó à direita ira retornar True,se não False.
   */
  public boolean temDireita(Nó n){return n.retornaDireita() != null;}

  /** 
   * Retorna se tem algum nó na Esquerda, caso sim retorna true, se não retorna false.
   * 
   * @return True ou False - 
   * Caso não tenha algum nó à Esquerda ira retornar False, 
   *        caso tem algum nó então irá retornar True. 
   */
  public boolean temEsquerda(Nó n){return n.retornaEsquerda() != null;}
}// Fim da classe árvore.
