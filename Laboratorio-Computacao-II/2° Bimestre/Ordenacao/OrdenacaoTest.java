

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrdenacaoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrdenacaoTest
{
    /**
     * Default constructor for test class OrdenacaoTest
     */
    public OrdenacaoTest()
    {
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
    
    @Test
    public void bubblesortTest() {
        int[] a  = { 3, 5, 2, 6, 4, 8, 7, 9, 0, 1 },
              ca = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
              b  = { 3, 5, 2, 6, 4, 8, 7, 9, 0 },
              cb = { 0, 2, 3, 4, 5, 6, 7, 8, 9 },
              c  = { 3, 5, 3, 5, 3, 5 },
              cc = { 3, 3, 3, 5, 5, 5 },
              d  = { 1, 0 },
              cd = { 0, 1 };
        
        Ordenacao.bubblesort(a);
        assertArrayEquals("Não ordena quantidades pares", a, ca);
        
        Ordenacao.bubblesort(b);
        assertArrayEquals("Não ordena quantidades ímpares", b, cb);
        
        Ordenacao.bubblesort(c);
        assertArrayEquals("Não ordena números repetidos", c, cc);
        
        Ordenacao.bubblesort(d);
        assertArrayEquals("Arranjo com apenas 2 elementos", d, cd);
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
}
