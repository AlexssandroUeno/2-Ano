
/**
 * Não se esqueça de escrever um Javadoc adequado para cada método, e para a classe como um todo.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FilaPrioridadesMin<T extends Comparable<T>>
{
    /**
     * Cria a fila de prioridades mínima vazia.
     */
    public FilaPrioridadesMin(int capacidade) 
    {
       minHeap = (T[]) new Comparable[capacidade];
    }
    
    /**
     * Cria a fila de prioridades mínima contendo todos as entradas do arranjo.
     */
    public FilaPrioridadesMin(T[] arranjoEntradas)
    {
        numElems = arranjoEntradas.length;
        minHeap = (T[]) new Comparable[arranjoEntradas.length+1];
        System.arraycopy(arranjoEntradas, 0, minHeap, 1, arranjoEntradas.length);
        construirHeap();
    }
    
    private void construirHeap() 
    {
        for(int i = numElems/2; i > 0; i--) 
        {
            filtrar(i);
        }
    }
    
   private void filtrar(int i)
   {
      T temp = minHeap[i];
      int aux;

      for(;2*i <= numElems;i = aux)
      {
         aux = 2*i;
         if(aux != numElems &&
            minHeap[aux].compareTo(minHeap[aux + 1]) == 1) aux++;
         if(temp.compareTo(minHeap[aux]) == 1)  minHeap[i] = minHeap[aux];
         else
                break;
      }
      minHeap[i] = temp;
   }
    
   private void sortHeap(T[] arranjo)
   {
      numElems = arranjo.length;
      minHeap = (T[]) new Comparable[numElems+1];
      System.arraycopy(arranjo, 0, minHeap, 1, numElems);
      construirHeap();

      for (int i = numElems; i > 0; i--)
      {
         T temp = minHeap[i]; //move top item to the end of the heap array
         minHeap[i] = minHeap[1];
         minHeap[1] = temp;
         numElems--;
         filtrar(1);
      }
      for(int k = 0; k < minHeap.length-1; k++)
         arranjo[k] = minHeap[minHeap.length - 1 - k];
   }
   
    public void inserir(T entrada) {
        if(numElems == minHeap.length - 1) expandir();
        int pos = ++numElems;        
        for(;  pos > 1 && entrada.compareTo(minHeap[pos/2]) < 0;pos = pos/2)
        {
            minHeap[pos] = minHeap[pos/2];
        }
        minHeap[pos] = entrada;
    }
    
    private void expandir() {
      T [] antigoHeap = minHeap;
      minHeap = (T[]) new Comparable[minHeap.length * 2];
      System.arraycopy(antigoHeap, 1, minHeap, 1, numElems);
   }
    
    public T minimo() {
        return minHeap[1];
    }
    
    public T extrairMinimo() {
      if (numElems == 0) return null;
      T min = minHeap[1];
      minHeap[1] = minHeap[numElems--];
      filtrar(1);
      return min;
    }
    
    // Somente esses atributos são permitidos, não é necessário nada mais.
    private T[] minHeap;
    private int numElems;
}
