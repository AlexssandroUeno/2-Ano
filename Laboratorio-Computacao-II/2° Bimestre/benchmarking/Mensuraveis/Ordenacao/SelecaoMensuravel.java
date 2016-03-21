package Mensuraveis.Ordenacao;


/**
 * Write a description of class Selecao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelecaoMensuravel extends OrdenacaoMensuravel
{
    /**
     * Este método ordena o arranjo utilizando o algoritmo de selecao.
     * 
     * @param arranjo Arranjo a ser ordenado.
     */
    @Override
    public void ordenar(int[] arranjo) {
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
	
	private static void trocar(int[] ordenado, int i, int j) {
        int seguro = ordenado[i];
        ordenado[i] = ordenado[j];
        ordenado[j] = seguro;
    }
}
