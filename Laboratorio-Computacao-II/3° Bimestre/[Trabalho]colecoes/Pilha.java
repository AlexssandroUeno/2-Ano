
/**
 * Write a description of class Pilha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pilha
{
    public Pilha(int capacidade) {
        arranjo = new Object[capacidade];
        topo = 0;
    }
    public Pilha() {
        this(10);
    }
    
    public void empilhar(Object objeto) {
        arranjo[topo] = objeto;
        topo++;
    }
    
    public Object desempilhar() {
        topo--;
        Object temp = arranjo[topo];
        arranjo[topo] = null;
        return temp;
    }
    
    public Object topo() {
        return arranjo[topo - 1];
    }
    
    private final Object[] arranjo;
    private int topo;
}
