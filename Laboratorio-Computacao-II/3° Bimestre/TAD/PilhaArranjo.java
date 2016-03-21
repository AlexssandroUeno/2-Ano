
[


[
/**
 * Write a description of class PilhaArranjo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PilhaArranjo<T> implements Pilha<T>
{
    
    public PilhaArranjo() {
        this.arranjo = new Object[TAM_PADRAO];
    }
    
    @Override
    public T desempilhar(){
        return null;
    }
    
    @Override
    public void empilhar(T e){

    }
    
    @Override
    public T olhar(){
        return null;
    }
    
    private int topo = 0;
    private Object arranjo[];
    private static int TAM_PADRAO = 5;
}
