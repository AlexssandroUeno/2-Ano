
/**
 * Ordenacao.java
 * 
 * @author Thelokys
 * @version (a version number or a date)
 */
public class Ordenacao
{
    public static void bubblesort(int[] arranjo) {
        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < arranjo.length; i++) {
                if (arranjo[i-1] > arranjo[i]) {
                    trocar(arranjo, i-1, i);
                    trocou = true;
                }
            }
        } while (trocou);
    }

    public static void selectionsort(int[] arranjo) {
        for (int i = 0; i < arranjo.length; i++) {
            int minimum = i;
            for (int j = i + 1; j < arranjo.length; j++) {
                if (arranjo[minimum] > arranjo[j]) {
                    minimum = j;
                }
            }
            trocar(arranjo, i, minimum);
        }
    }

    public static void selectionsortSemFor(int[] arranjo) {

        for (int i = 0; i < arranjo.length; i++) {
            int minimum = i;
            int j = i + 1;
            while (j < arranjo.length) {
                if (arranjo[minimum] > arranjo[j]) {
                    minimum = j;
                }
                j++;
            }
            trocar(arranjo, i, minimum);
        }
    }

    public static void insertionsort(int[] arranjo) {
        for (int i = 1; i < arranjo.length; i++) {
            int anterior = i - 1;
            int atual = i;
            while (anterior >= 0 && arranjo[anterior] > arranjo[atual]) {
                trocar(arranjo, anterior, atual);
                anterior--;
                atual--;
            }
        }
    }

    private static void trocar(int[] ordenado, int i, int j) {
        int seguro = ordenado[i];
        ordenado[i] = ordenado[j];
        ordenado[j] = seguro;
    }
}
