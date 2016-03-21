package Mensuraveis.Ordenacao;


/**
 * Write a description of class BolhaMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BolhaMensuravel extends OrdenacaoMensuravel
{
    @Override
    public void ordenar(int[] arranjo) {
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
        
        // Marcar o ponto onde a bolha termina
        // por acaso é no final do arranjo
        
        // Repita até que não aconteça nenhuma troca
        
            // Percorra o arranjo, comparando e trocando cada
            // valor adjacente até onde a bolha termina
            
            // atualize a posicao onde a bolha termina
    }
	
	private static void trocar(int[] ordenado, int i, int j) {
        int seguro = ordenado[i];
        ordenado[i] = ordenado[j];
        ordenado[j] = seguro;
    }
	
}
