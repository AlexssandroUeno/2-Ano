package InsertionSort;

public class Insertion extends auxiliaArray.array {

	public static void sort(int[] arranjo) {
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

}
