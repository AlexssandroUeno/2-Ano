
/**
 * Write a description of class Lista here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista
{
    public Lista(int capacidade) {
        arranjo = new Object[capacidade];
        numElementos = 0;
    }
    public Lista() {
        this(8);
    }
    
    public int inserir(Object objeto, int pos) {
        numElementos++;
        if (numElementos == arranjo.length) {
            expandir();
        }
        
        // Deslocar elementos
        for (int i = numElementos; i > pos; i--) {
            arranjo[i] = arranjo[i-1];
        }
        
        arranjo[pos] = objeto;
        
        return pos;
    }
    
    public Object remover(int pos) {
        Object removido = arranjo[pos];
        
        for (int i = pos; i < numElementos; i++) {
            arranjo[i] = arranjo[i+1];
        }
        numElementos--;
        arranjo[numElementos] = null;
        
        return removido;
    }
    
    public int buscar(Object object) {
        throw new UnsupportedOperationException("Ainda não implementado pelo aluno");
    }
    
    private void expandir() {
        Object[] expandido = new Object[arranjo.length * 2];
        for (int i = 0; i < arranjo.length; i++) {
            expandido[i] = arranjo[i];
        }
        arranjo = expandido;
    }
    
    private Object[] arranjo;
    private int numElementos;
}
