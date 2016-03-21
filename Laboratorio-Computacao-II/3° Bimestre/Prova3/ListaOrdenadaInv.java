
/**
 * ListaOrdenadaInv.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 09/08/2015
 */
public class ListaOrdenadaInv<AnyType>
{
    private int numElementos;
    private Comparable<AnyType>[] arranjo;

    public ListaOrdenadaInv() {
      arranjo = new Comparable[3];
    }
    
    public int inserir(Comparable<AnyType> v) {
        int pos = 0;
        numElementos++;
        if (numElementos == arranjo.length) {
          expandir();
        }
        // Deslocar elementos
        for (int i = numElementos; i > pos; i--) {
            arranjo[i] = arranjo[i - 1];
        }
        arranjo[pos] = v;
        if (numElementos > 0) {
            inv();
        }
        pos = buscar(v);
        return pos;
    }
    
    public int buscar(Comparable<AnyType> v) {
         int pos = -1;
        for (int i = 0; i < arranjo.length; i++) {
            if ((arranjo[i] != null) && (arranjo[i]==v)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public Comparable<AnyType> removerEm(int i) {
         Comparable<AnyType> removido = recuperarEm(i);
        arranjo[i] = null; 
        Comparable<AnyType>[] auxiliar = arranjo; 

        for (int j = 0; j < auxiliar.length - 1; j++) {
            if (arranjo[j] == null) {
                trocar(auxiliar, j, j + 1);
            }
        }
        arranjo = auxiliar;
        inv(); 
        numElementos--;
        return removido;
    }
    
    
    public Comparable<AnyType> recuperarEm(int i) {
        return arranjo[i];
    }
    
    public int numElementos() {
        return numElementos;
    }
    
    private void inv() {
         boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < arranjo.length; i++) {
                if ((arranjo[i] != null) && (arranjo[i-1].compareTo((AnyType) arranjo[i]) < 0) ) {    
                    trocar(arranjo, i-1, i);
                    trocou = true;
                }
            }
        } while (trocou);
    }
    
    private void trocar(Comparable<AnyType> [] ordenado, int i, int j) {
        Comparable<AnyType> seguro = ordenado[i];
        ordenado[i] = ordenado[j];
        ordenado[j] = seguro;
    }
    
    public void expandir() {
        Comparable<AnyType>[] expandido = new Comparable[arranjo.length * 2];
        for (int i = 0; i < arranjo.length; i++) {
            expandido[i] = arranjo[i];
        }
        arranjo = expandido;
    }
}
