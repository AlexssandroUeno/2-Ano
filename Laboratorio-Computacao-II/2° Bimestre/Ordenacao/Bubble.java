package BubbleSort;

public class Bubble extends auxiliaArray.array{

	public static void sort(int[] arranjo) {
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
	
}
