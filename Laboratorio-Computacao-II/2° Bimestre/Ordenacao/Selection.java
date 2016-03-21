/**
 * 
 */
package SelectionSort;

/**
 * @author Thelokys
 *
 */
public class Selection extends auxiliaArray.array {

	public static void sort(int[] arranjo) {
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

	public static void sortSemFor(int[] arranjo) {

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
}
