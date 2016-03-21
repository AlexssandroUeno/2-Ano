package Mensuraveis.Ordenacao;

import Mensuraveis.Cronometro;

/**
 * Abstract class OrdenacaoMensuravel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class OrdenacaoMensuravel
{
    public abstract void ordenar(int[] arranjo);
    
    
    /**
     * Realiza busca pela posição de um valor.
     * 
     * @param lista Lista de valores a serem procurados.
     * @param valor Valor a ser procurado na lista.
     * @return A posição do valor encontrado, ou -1 caso não encontre.
     */
    public double benchmarkOrdenacao(int[] lista, int repeticoes) {
        Cronometro crono = new Cronometro();
   
        // Executar repetições para o código avaliado
        while (repeticoes > 0) {
            // Marcar tempo de inicio
            crono.parar();
            int[] copia = copiarArranjo(lista);
            crono.iniciar();        
            ordenar(copia);
            repeticoes--;
        }
        
        // Marcar tempo de fim        
        // Retornar tempo total de execução
        return crono.parar();
    }
    
    private int[] copiarArranjo(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}
