import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaOrdenadaInvTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaOrdenadaInvTest
{
    /**
     * Default constructor for test class ListaOrdenadaInvTest
     */
    public ListaOrdenadaInvTest()
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
        loi = new ListaOrdenadaInv();
        for (int valor : valores) {
            loi.inserir(valor);
        }
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
    public void verificaOrdemInsercaoInversa() {
        Integer[] ordenados = { 80, 10, 8, 5, 3, 1 };
        for (int i = 0; i < ordenados.length; i++) {
            assertEquals("Falha - ordem errada", ordenados[i], loi.recuperarEm(i));
        }
    }
    
    @Test
    public void verificaBuscaPresente() {
        assertEquals("Falha na busca do primeiro", 0, loi.buscar(80));
        assertEquals("Falha na busca do ultimo", 5, loi.buscar(1));
        assertEquals("Falha na busca do meio", 1, loi.buscar(10));
        assertEquals("Falha na busca do meio", 2, loi.buscar(8));
        assertEquals("Falha na busca do penultimo", 4, loi.buscar(3));
    }
    
    @Test
    public void verificaBuscaAusente() {
        assertEquals("Falha na busca por elemento não presente", -1, loi.buscar(81));
        assertEquals("Falha na busca por elemento não presente", -1, loi.buscar(7));
        assertEquals("Falha na busca por elemento não presente", -1, loi.buscar(0));
    }
    
    @Test
    public void verificaRemocao() {
        assertEquals("Falha no retorno de remoção", new Integer(8), loi.removerEm(2));
        
        Integer[] ordenados = { 80, 10, 5, 3, 1 };
        for (int i = 0; i < ordenados.length; i++) {
            assertEquals("Falha - ordem errada após remoção", ordenados[i], loi.recuperarEm(i));
        }
    }
    
    @Test
    public void verificaExpandir() {
        for (int i = 0; i < 1000; i++) {
            loi.inserir(1);
        }
    }
    
    private ListaOrdenadaInv loi;
    private static final Integer[] valores = { 1 , 5, 10, 3, 8, 80 };
}
