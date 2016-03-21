
/**
 * Listano.java
 *
 * @author Jose Ricardo Guidetti Junior
 * @version 08/11/2015 12:03
 */
public class ListaNode{
    public ListaNode() {
        this.inicio = null;
    }
    
    public int inserir(Object valor, int pos) {
       No novoNo = new No(valor);
       No aux = inicio;
       if( isEmpty()){
           inicio = novoNo;
       } else
       if( pos == 0 ) {
           novoNo.setProximo(aux);
           inicio = novoNo;
       }else 
       if( pos > getSize() ){
           while(aux.getProximo() != null){
               aux = aux.getProximo(); 
           }
           aux.setProximo(novoNo);
           novoNo.setProximo(null);
           int resultado = pos - getSize();
           if( resultado > 1 )return getSize(); 
       }else
       if( pos <= getSize() ){
           int cont = 0;
           No anterior = null;
           while( cont != pos ){
               cont += 1;
               if(cont == pos ){
                   anterior = aux;
               }
               aux = aux.getProximo();
           }
           anterior.setProximo(novoNo);
           novoNo.setProximo(aux);
        }
       return pos;
    }   
   
    public Object remover(int pos){
        No removido = null;
        No aux = inicio;
        if( isEmpty() ) {
            System.out.println("impossivel remover <lISTA VAZIA>");
        } else
        if ( pos == 0 ) {
            removido = inicio;
            inicio = aux.getProximo();
            aux.setProximo(null);
        }else
        if ( pos >= getSize() ) {
            No anteriorRemover = null;
            while(aux.getProximo() != null){
                if(aux.getProximo() == null){
                   anteriorRemover = aux;
                }
                aux = aux.getProximo();
            }
            removido = aux;
            anteriorRemover.setProximo(null);
            aux.setProximo(null);
        } 
        return removido;
    }
    
    public int buscar(Object valor){
        No aux = inicio;
        int i = 0;
        if( isEmpty() ){
            return -1;
        }else 
        if(aux.getProximo() == null){
           if( aux.getValor() == valor ) {
                    return i;
           }
        }else{        
            while(aux.getProximo() != null){
                if( aux.getValor() == valor ) {
                    return i;
                }
                i += 1;
                aux = aux.getProximo();
            }
            if( aux.getValor() == valor ) {
                    return i;
                }
        }
        return -1;
    }
    
    private int getSize() {
        No aux = inicio;
        int size = 0;
        if(inicio == null){
            return -1;
        }
        while(aux.getProximo() != null){
            aux = aux.getProximo();
            size += 1;
        } 
        return size;
    }

    private boolean isEmpty(){
        if(inicio == null)return true;
        return false;
    }
    private No inicio;
}