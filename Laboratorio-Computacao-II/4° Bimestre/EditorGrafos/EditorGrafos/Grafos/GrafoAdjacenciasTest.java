package Grafos;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class GrafoAdjacenciasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GrafoAdjacenciasTest
{
    /**
     * Default constructor for test class GrafoAdjacenciasTest
     */
    public GrafoAdjacenciasTest()
    {
        a = new Vertice<Integer>(1);
        b = new Vertice<Integer>(2);
        c = new Vertice<Integer>(3);
        d = new Vertice<Integer>(4);
        
        aresta1 = new Aresta(a, b, 5);
        aresta2 = new Aresta(b, c, 10);
        aresta3 = new Aresta(c, d, 15);
        aresta4 = new Aresta(d, a, 20);
        aresta5 = new Aresta(d, b, 25);
    
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        
        adjacencias.add(aresta1);
        adjacencias.add(aresta2);
        adjacencias.add(aresta3);
        adjacencias.add(aresta4);
        adjacencias.add(aresta5);
        
        grafoAdj.inserirVertice(a);
        grafoAdj.inserirVertice(b);
        grafoAdj.inserirVertice(c);
        grafoAdj.inserirVertice(d);
        
        grafoAdj.inserirAresta(aresta1);
        grafoAdj.inserirAresta(aresta2);
        grafoAdj.inserirAresta(aresta3);
        grafoAdj.inserirAresta(aresta4);
        grafoAdj.inserirAresta(aresta5);
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
    public void testInsercao() {
        assertEquals(vertices, grafoAdj.vertices());
        assertEquals(adjacencias, grafoAdj.arestas());
    }
    
    
    @Test
    public void testArestasIncidentes() {
        ArrayList<Aresta<Integer>> incidentes = new ArrayList();
        incidentes.add(aresta1);
        incidentes.add(aresta4);
        
        assertEquals(incidentes, grafoAdj.arestasIncidentes(a));
    }

    @Test
    public void testOposto() {
        assertEquals(a, grafoAdj.oposto(b, aresta1));
    }
    
    @Test
    public void testVerticesFim() {
        ArrayList<Vertice<Integer>> vFim = new ArrayList();
        vFim.add(a);
        vFim.add(b);
        
        assertEquals(vFim, grafoAdj.verticesFim(aresta1));
    }
    
    @Test
    public void testSaoAdjacentes() {
        assertEquals(true, grafoAdj.saoAdjacentes(a, b));
        assertEquals(false, grafoAdj.saoAdjacentes(a, c));
    }
    
    
    @Test
    public void testRemover() {
        vertices.remove(a);
        grafoAdj.removerVertice(a);
        assertEquals(vertices, grafoAdj.vertices());
    }
    
    @Test
    public void showLista() {
        Aresta<Integer> aux;
        for (int i = 0; i < grafoAdj.arestas().size(); i++) {
            aux = (Aresta<Integer>)grafoAdj.arestas().get(i);
            System.out.println("Vértice 1:" + aux.getOrigem().getAtributos());
            System.out.println("Vértice 2:" + aux.getDestino().getAtributos());
            System.out.println("Atributo (peso - Integer):" + aux.getAtributos());
            System.out.println("-----------------");
        }
    }
    
    
    Vertice<Integer> a, b, c, d;
    Aresta<Integer> aresta1, aresta2, aresta3, aresta4, aresta5;
    private GrafoAdjacencias grafoAdj = new GrafoAdjacencias();
    private ArrayList<Vertice<Integer>> vertices = new ArrayList<Vertice<Integer>>();
    private ArrayList<Aresta<Integer>> adjacencias = new ArrayList<Aresta<Integer>>();
    
}
