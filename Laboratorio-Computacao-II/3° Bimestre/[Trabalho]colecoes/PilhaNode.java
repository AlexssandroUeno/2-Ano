
/**
 * PilhaNode.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 08/11/2015 12:02
 */
public class PilhaNode
{
   public PilhaNode(){
        this.topo = null;
   }
   
    public void empilhar(Object valor) {
        No no = new No(valor);
        if (isEmpty()) {
            inicio = no;
            topo = no;
        } else
        {
            topo.setProximo(no);
            no.setProximo(null);
            topo = no;
        }
   }
   
   public Object desempilhar(){       
       No noRemovido = topo;
       if(topo == inicio){
           topo = null;
           inicio = null;
       }else{
           No anterior = getAnterior(topo);       
           anterior.setProximo(null);
           topo = anterior;
       }
       return noRemovido.getValor();
   }
   
   public Object getTopo(){
    return topo.getValor();
   }
   
   private boolean isEmpty() {
        if (topo == null) {
            return true;
        } else {
            return false;
        }
    }    
    
   private No getAnterior(No _node) {
		No aux = inicio;
		while (aux.getProximo() != _node) {
			aux = aux.getProximo();
		}
		return aux;
    }
    private No topo;
    private No inicio;
}
