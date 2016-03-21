package Tests;

import Mensuraveis.Ordenacao.SelecaoMensuravel;

import java.util.Random;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SelecaoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SelecaoTest
{    
    @Test
    public void verificaOrdenarSelecaoArranjosPequenos() {
        int[][] desordenado = { {}, {1}, {1, 2}, { 2, 1 }, { 3, 1, 2}, { 3, 2, 1 } };
        int[][] ordenado = { {}, {1}, {1, 2}, { 1, 2 }, { 1, 2, 3}, { 1, 2, 3 } };
        
        for (int[] arranjo : desordenado) {
            ordenador.ordenar(arranjo);
        }
        for (int i = 0; i < desordenado.length; i++) {
            assertArrayEquals(ordenado[i], desordenado[i]);
        }
    }
    
    @Test
    public void verificaBuscaSelecaoGrandePar() {
        int[] desordenado = new int[TAMANHO];
        int[] ordenado = new int[TAMANHO];
        Random r = new Random(SEED);
        for (int i = 0; i < desordenado.length; i++) {
            ordenado[i] = desordenado[i] = r.nextInt(MAX_INT);
        }
        
        ordenador.ordenar(desordenado);
        Arrays.sort(ordenado);
        assertArrayEquals(ordenado, desordenado);
    }
    
    @Test
    public void verificaBuscaSelecaoGrandeImpar() {
        final int TAMANHO_IMPAR = TAMANHO + 1;
        int[] desordenado = new int[TAMANHO_IMPAR+1];
        int[] ordenado = new int[TAMANHO_IMPAR+1];
        Random r = new Random(SEED);
        for (int i = 0; i < desordenado.length; i++) {
            ordenado[i] = desordenado[i] = r.nextInt(MAX_INT);
        }
        
        ordenador.ordenar(desordenado);
        Arrays.sort(ordenado);
        assertArrayEquals(ordenado, desordenado);
    }
    
    private final int TAMANHO = 4096;
    private final int SEED = 0;
    private final int MAX_INT = 10000;
    private SelecaoMensuravel ordenador = new SelecaoMensuravel();
}
