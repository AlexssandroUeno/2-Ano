
/**
 * Write a description of class Fila here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fila
{
    public Fila(int capacidade) {
        arranjo = new Object[capacidade];
        inicio = fim = 0;
    }
    public Fila() {
        this(10);
    }
    
    public void enfileirar(Object objeto) {
        arranjo[fim] = objeto;
        fim++;
        if (fim == arranjo.length) {
            fim = 0;
        }
    }
    
    public Object desenfileirar() {
        Object retirado = arranjo[inicio];
        arranjo[inicio] = null;
        
        inicio++;
        if (inicio == arranjo.length) {
            inicio = 0;
        }
        
        return retirado;
    }
    
    public Object primeiro() {
        return arranjo[inicio];
    }
    
    private final Object[] arranjo;
    private int inicio, fim;
}
