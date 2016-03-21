

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.Math;

/**
 * The test class BuscaTest.
 *
 * @author  Mario H. Adaniya
 * @version 03/03/2015
 */
public class BuscaTest
{
    /**
     * Default constructor for test class BuscaTest
     */
    public BuscaTest()
    {
    }

    /**
     * Função para auxiliar na geração de um vetor aleatório.
     */
    public int[] gerarVetor(int size, int min, int max){
        int nums[] = new int[size];
        for(int i=0; i<size; i++){
            nums[i] = min + (int)(Math.random()*max); 
        }
        return nums;

    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testeConstrutorVazio()
    {        
        Busca busca = new Busca();
        assertEquals("Should be equals", null, busca.getNumeros());
    }
    
    @Test
    public void testeConstrutorComParametros()
    {   
        int nums[] = gerarVetor(10,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be equals", nums, busca.getNumeros());
        
    }
    
    @Test
    public void testeBuscaLinearNumeroInexistente()
    {   
        int nums[] = {1,2,3,4,5,6};
        Busca busca = new Busca(nums);
        assertEquals("Should be false", false, busca.linear(7));        
    }
    
    @Test
    public void testeBuscaLinearNumeroExistente()
    {   
        int nums[] = gerarVetor(10,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be false", true, busca.linear(nums[5]));        
    }
    
    @Test
    public void testeBuscaLinearUltimaPosicao()
    {   
        int nums[] = gerarVetor(15,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be false", true, busca.linear(nums[nums.length-1]));
    }
    
    @Test
    public void testeBuscaBinariaNumeroInexistente()
    {   
        int nums[] = {1,2,3,4,5,6};
        Busca busca = new Busca(nums);
        assertEquals("Should be false", false, busca.binaria(7));        
    }
    
    @Test
    public void testeBuscaBinariaNumeroExistente()
    {   
        int nums[] = gerarVetor(10,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be false", true, busca.binaria(nums[5]));
    }
        
    @Test
    public void testeBuscaBinariaUltimaPosicao()
    {   
        int nums[] = gerarVetor(10,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be false", true, busca.binaria(nums[nums.length-1]));
    }
    
    @Test
    public void testeBuscaBinariaVetorImpar()
    {   
        int nums[] = gerarVetor(21,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be false", false, busca.binaria(nums[2]));
    }
    
    @Test
    public void testeBuscaArrayGrande()
    {   
        int nums[] = gerarVetor(100000,0,99);
        Busca busca = new Busca(nums);
        assertEquals("Should be false", false, busca.binaria(nums[nums.length-1]));
    }
}