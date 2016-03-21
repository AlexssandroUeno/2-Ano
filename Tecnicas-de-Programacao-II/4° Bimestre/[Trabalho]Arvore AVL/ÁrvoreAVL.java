import java.util.ArrayList; // importação para manipulação de arranjos(Api do java).
/**
 * Essa classe tem como objetivo representar a estrutura de uma árvore AVL ou árvore 
 * balanceada pela altura é uma árvore de busca binária autobalanceada. Na árvore 
 * as alturas das duas sub-árvores a partir de cada nó diferem no máximo em uma unidade.
 * As operações de busca, inserção e remoção de elementos possuem complexidade O(log n )
 * (no qual n é o número de elementos da árvore). Inserções e remoções podem também 
 * requerer o rebalanceamento da árvore, exigindo uma ou mais rotações.
 * Nessa estrutura de dados cada elemento é chamado de Nó. Um Nó contém um valor próprio,
 * um valor de altura, e dois filhos, que são outros Nós. A partir desta estrutura é 
 * possível montar um algoritmo eficiente para armazenar, buscar e deletar informações.
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 2015/10/01
 */
public class ÁrvoreAVL<Type> extends ÁrvoreBinária /*extends Google implements Tudo */
{
  public void inserir(Type v)
  {
    Nó aInserir = new Nó (v);
    verificarBalanceamento(inserir(retornaRaiz(), aInserir));
  }
  private void verificarBalanceamento(Nó atual)
  {
    mudaBalanceamento(atual);
    int balanceamento = atual.retornaBalanceamento();
    if (balanceamento == -2)
    {
      if (altura(atual.retornaEsquerda().retornaEsquerda()) >= altura(atual.retornaEsquerda().retornaDireita()))
      {
        atual = rotacaoDireita(atual);
      }
      else
      {
        atual = duplaRotacaoEsquerdaDireita(atual);
      }
    }
    else if (balanceamento == 2)
    {
      if (altura(atual.retornaDireita().retornaDireita()) >= altura(atual.retornaDireita().retornaEsquerda()))
      {
        atual = rotacaoEsquerda(atual);
      }
      else
      {
        atual = duplaRotacaoDireitaEsquerda(atual);
      }
    }
    if (atual.retornaPai() != null)
    {
      verificarBalanceamento(atual.retornaPai());
    }
    else
    {
      mudaRaizPara(atual);
    }
  }
  private Nó rotacaoEsquerda(Nó inicial)
  {
    Nó direita = inicial.retornaDireita();
    direita.mudaPaiPara(inicial.retornaPai());
    inicial.mudaDireitaPara(direita.retornaEsquerda());
    if (inicial.retornaDireita() != null)
    {
      inicial.retornaDireita().mudaPaiPara(inicial);
    }
    direita.mudaEsquerdaPara(inicial);
    inicial.mudaPaiPara(direita);
    if (direita.retornaPai() != null)
    {
      if (direita.retornaPai().retornaDireita() == inicial)
      {
        direita.retornaPai().mudaDireitaPara(direita);
      }
      else if (direita.retornaPai().retornaEsquerda() == inicial)
      {
        direita.retornaPai().mudaEsquerdaPara(direita);
      }
    }
    mudaBalanceamento(inicial);
    mudaBalanceamento(direita);
    return direita;
  }
  private Nó rotacaoDireita(Nó inicial)
  {
    Nó esquerda = inicial.retornaEsquerda();
    esquerda.mudaPaiPara(inicial.retornaPai());
    inicial.mudaEsquerdaPara(esquerda.retornaDireita());
    if (inicial.retornaEsquerda() != null)
    {
      inicial.retornaEsquerda().mudaPaiPara(inicial);
    }
    esquerda.mudaDireitaPara(inicial);
    inicial.mudaPaiPara(esquerda);
    if (esquerda.retornaPai() != null)
    {
      if (esquerda.retornaPai().retornaDireita() == inicial)
      {
        esquerda.retornaPai().mudaDireitaPara(esquerda);
      }
      else if (esquerda.retornaPai().retornaEsquerda() == inicial)
      {
        esquerda.retornaPai().mudaEsquerdaPara(esquerda);
      }
    }
    mudaBalanceamento(inicial);
    mudaBalanceamento(esquerda);
    return esquerda;
  }
  private Nó duplaRotacaoEsquerdaDireita(Nó inicial)
  {
    inicial.mudaEsquerdaPara(rotacaoEsquerda(inicial.retornaEsquerda()));
    return rotacaoDireita(inicial);
  }
  private Nó duplaRotacaoDireitaEsquerda(Nó inicial)
  {
    inicial.mudaDireitaPara(rotacaoDireita(inicial.retornaDireita()));
    return rotacaoEsquerda(inicial);
  }
  private Nó sucessor(Nó q)
  {
    if (q.retornaDireita() != null)
    {
      Nó r = q.retornaDireita();
      while (r.retornaEsquerda() != null)
      {
        r = r.retornaEsquerda();
      }
      return r;
    }
    else
    {
      Nó p = q.retornaPai();
      while (p != null && q == p.retornaDireita())
      {
        q = p;
        p = q.retornaPai();
      }
      return p;
    }
  }
  private int altura(Nó atual)
  {
    if (atual == null)
    {
      return -1;
    }
    if (atual.retornaEsquerda() == null && atual.retornaDireita() == null)
    {
      return 0;
    }
    else if (atual.retornaEsquerda() == null)
    {
      return 1 + altura(atual.retornaDireita());
    }
    else if (atual.retornaDireita() == null)
    {
      return 1 + altura(atual.retornaEsquerda());
    }
    else
    {
      return 1 + Math.max(altura(atual.retornaEsquerda()), altura(atual.retornaDireita()));
    }
  }
  private void mudaBalanceamento(Nó no)
  {
    no.mudaBalanceamentoPara(altura(no.retornaDireita()) - altura(no.retornaEsquerda()));
  }
}