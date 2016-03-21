package Tests;

import Mensuraveis.Ordenacao.MergesortMensuravel;

import java.util.Random;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MergesortMensuravelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MergesortMensuravelTest
{
    @Test
    public void verificaMergeArranjos() {
        int[][] A = {
            {},
            {},
            { 1,2,3 },
            { 1,2,3 },
            { 1,3 },
            { 2,4,6 },
            { 2,3,7,8 }
        };
        int[][] B = {
            {},
            { 1,2,3 },
            {},
            { 4,5,6 },
            { 2,4,6 },
            { 1,3 },
            { 1,4,5,9 }
        };
        int[][] R = { {}, { 1,2,3 }, { 1,2,3 }, { 1,2,3,4,5,6 }, { 1,2,3,4,6 },
            { 1,2,3,4,6 }, { 1,2,3,4,5,7,8,9 } };
        
        for (int i = 0; i < R.length; i++) {
            int[] merged = ordenador.mergeArranjos(A[i], B[i]);
            assertArrayEquals(R[i], merged);
        }
    }
    
    @Test
    public void verificaMerge() {
        // Agradeco a Camila Sonoda pelas correcoes desses numeros chatos. Obrigado Camilinha! ;)
         int[][] toMerge = {
             {},
             { 1,2,3 },
             { 1,2,3 },
             { 1,2,3,4,5,6 },
             { 1,3,2,4,6 },
             { 2,4,6,1,3 },
             { 2,3,7,8,1,4,5,9 },
             { 9,8,5,4,6,8,5,7,9,11,0,3 }
         };
         int[][] pqr = { { 0,0,0 }, { 0,0,3 }, { 2,3,3 }, { 0,3,6 }, { 0,2,5 }, { 0,3,5 },
            { 0,4,8 }, { 3,6,9 } };
         int[][] R = { {}, { 1,2,3 }, { 1,2,3 }, { 1,2,3,4,5,6 }, { 1,2,3,4,6 },
            { 1,2,3,4,6 }, { 1,2,3,4,5,7,8,9 }, { 9,8,5,4,5,6,7,8,9,11,0,3 } };
         
         for (int i = 0; i < R.length; i++) {
             int p = pqr[i][0], q = pqr[i][1], r = pqr[i][2];
             ordenador.merge(toMerge[i], p, q, r);
             assertArrayEquals(R[i], toMerge[i]);
         }
    }
    
    @Test
    public void verificaOrdenarMergesortArranjosPequenos() {
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
    public void verificaBuscaMergesortGrandePar() {
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
    public void verificaBuscaMergesortGrandeImpar() {
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
    private MergesortMensuravel ordenador = new MergesortMensuravel();
}
