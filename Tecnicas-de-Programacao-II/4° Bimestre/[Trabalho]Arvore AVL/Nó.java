/**
 * A classe Nó tem como princípio ajudar na construção da Árvore AVL,   
 * Os elos da lista são formados por ponteiros que possuem a referência para o 
 * próximo elemento. Quando não existe a referência para o próximo elemento,
 * o ponteiro assume o valor nulo. Cada elemento possui uma referência 
 * para o elemento da esquerda, da direita e do pai do nó atual, assim como valores
 * que indicam o balanceamento.
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 2015/30/09
 */
public class Nó // Declaracao da classe
 {
  /**
   * Declaracao dos campos da classe Nó
   */  
  private Comparable valor;    //Este campo tem referência ao Nó como sendo seu valor.
 
  private Nó esquerda;  // Aponta para o nó com referência a esquerda.
  private Nó direita;   // Variável para guardar uma referência do nó a direita.
  private Nó pai;       // Variável que guarda o Nó que está te referenciando.
    
  /** 
   * Este campo tem como princípio guarda a o balanceamento(altura) do Nó.
   */
  private int balanceamento;
    
  public Nó() {/* Construtor padrão*/}

  /**
   * O construtor para a classe Nó, para inicializar os campos e também recebe
   * argumento para inicializar a variável valor. 
   *
   *@param v -  um valor do Nó
   */
  public Nó( Comparable v )
   {/* Construtor preferido para inicialização de variáveis*/
    mudaValorPara(v);  
    mudaBalanceamentoPara(0);
    mudaPaiPara(null);
    mudaDireitaPara(retornaPai());
    mudaEsquerdaPara(retornaDireita());    
   }
   
  /* Métodos de retornos para recuperação dos valores dos nó */
  public Comparable retornaValor()      {return valor;         }
  public Nó  retornaEsquerda()      {return esquerda;      }
  public Nó  retornaDireita()       {return direita;       } 
  public Nó  retornaPai()           {return pai;           }
  public int retornaBalanceamento() {return balanceamento; }
  
  /* Métodos de alteração para modifcar os valores dos nó da árvore */
  public void mudaValorPara(Comparable v)      {this.valor = v;        }
  public void mudaEsquerdaPara(Nó e)       {this.esquerda = e;     }   
  public void mudaDireitaPara(Nó d)        {this.direita = d;      }
  public void mudaPaiPara(Nó p)            {this.pai = p;          }
  public void mudaBalanceamentoPara(int b) {this.balanceamento = b;}
  
  /**
   * O método toString não recebe argumentos, e retorna uma string contendo os valores 
   * dos campos da classe formatados. 
   * 
   * @return Resultado - Uma string formatada com o valor do Nó atual.
   */
  public String toString() 
   {
   String resultado = "Node [valor=" + valor + "]";
   return resultado;
   }  
 } // Fim da classe Nó.
