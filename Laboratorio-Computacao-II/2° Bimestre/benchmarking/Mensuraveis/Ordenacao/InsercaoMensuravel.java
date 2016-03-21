package Mensuraveis.Ordenacao;


/**
 * Write a description of class InsercaoMensuravel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InsercaoMensuravel extends OrdenacaoMensuravel
{
    public int[] ordenarCom2Arranjos(int[] monteComprado) {
        int[] mao = new int[monteComprado.length];
		 for(int i = 0; i < monteComprado.length; i++){
			int j = i;
			 while(j > 0 && monteComprado[i] < mao[j-1]){
				 mao[j] = mao[j-1];
				 j--;
			 }
			mao[j] = monteComprado[i];
		 }
		 return mao;
    }
    
    @Override
    public void ordenar(int[] arranjo) {
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
