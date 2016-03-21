import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
    
/**
 * The test class UtilitariosHeap.
 *
 * @author  Ricardo Inácio Álvares e Silva
 * @version 20150831
 */
public class UtilitariosHeapTest
{
    /**
     * Default constructor for test class UtilitariosHeapTest
     */
    public UtilitariosHeapTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    @Test
    public void verificaVerificarHeap() {
        Integer[][] intRnd = { {null, 3, 7, 4, 5, 49, 35, 39, 25, 13, 18},
			       {null, 41, 31, 30, 10, 17, 11, 29, 12, 47, 43} };
	Integer[][] intHeap = { {null, 3, 5, 4, 7, 18, 35, 39, 25, 13, 49},
				{null, 10, 12, 11, 31, 17, 30, 29, 41, 47, 43} };

	assertFalse("Identificou heap erroneamente.", UtilitariosHeap.verificarHeap(intRnd[0]));
	assertFalse("Identificou heap erroneamente.", UtilitariosHeap.verificarHeap(intRnd[1]));
	
	assertTrue("Deveria ter identificado heap.", UtilitariosHeap.verificarHeap(intHeap[0]));
	assertTrue("Deveria ter identificado heap.", UtilitariosHeap.verificarHeap(intHeap[1]));
    }
}
