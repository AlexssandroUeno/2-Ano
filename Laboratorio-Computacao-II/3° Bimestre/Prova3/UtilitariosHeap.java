
/**
 * UtilitariosHeap.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 09/08/2015
 */
public class UtilitariosHeap
{
    
    /**
     * Proibido ao aluno modificar este método.
     */
    private UtilitariosHeap() {
    }
    
    public static boolean verificarHeap(Integer[] arr) {
     for (int i = 1; i < arr.length; i++) 
      if (arr[getPai(++i)].compareTo(arr[i]) == 1)
       {
        return false;
       }
     return true;
    }
    
    private static int getPai(int indiceNo){return indiceNo/2;}
}
