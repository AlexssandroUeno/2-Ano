package Mensuraveis.Ordenacao;


/**
 * Write a description of class MergesortMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MergesortMensuravel extends OrdenacaoMensuravel
{
    public int[] mergeArranjos(int[] A, int[] B) {
        int[] ordenado = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k <= ordenado.length; k++) {
            if (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    ordenado[k] = A[i++];
                } else {
                    ordenado[k] = B[j++];
                }
            } else if (i < A.length) {
                ordenado[k] = A[i++];
            } else if (j < B.length) {
                ordenado[k] = B[j++];
            }
        }
        return ordenado;
    }
    
    public void merge(int[] arranjo, int inicio, int meio, int fim) {  
        int[] A = new int[meio - inicio]; 
        int[] B = new int[fim - meio];  
        if(A.length == 0 || B.length == 0){
          return;
        }
        //Preenchemos
        for (int i = 0; i < (meio-inicio); i++) {
            A[i] = arranjo[inicio + i];      
        }
        for (int i = 0; i < (fim - meio); i++) {
            B[i] = arranjo[meio + i];
        }
        int i = 0;
        int j = 0;
        for (int k = inicio; k <= fim; k++) {
            if (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    arranjo[k] = A[i++];
                } else {
                    arranjo[k] = B[j++];
                }
            } else if (i < A.length) {
                arranjo[k] = A[i++];
            } else if (j < B.length) {
                arranjo[k] = B[j++];
            }
        }
    }
    
    public void mergesort(int[] arranjo, int inicio, int fim) {
         if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergesort(arranjo, inicio, meio);
            mergesort(arranjo, meio+1, fim);
            merge(arranjo, inicio, meio, fim);
        }      
    }
    
    @Override
    public void ordenar(int[] arranjo) {
        mergesort(arranjo, 0, arranjo.length - 1);
    }
}
