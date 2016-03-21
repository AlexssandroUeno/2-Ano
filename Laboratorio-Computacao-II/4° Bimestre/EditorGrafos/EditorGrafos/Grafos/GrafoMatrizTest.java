package Grafos;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * The test class GrafoMatrizTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GrafoMatrizTest
{
    /**
     * Default constructor for test class GrafoMatrizTest
     */
    public GrafoMatrizTest()
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
        
        grafoMatriz.inserirVertice(a);
        grafoMatriz.inserirVertice(b);
        grafoMatriz.inserirVertice(c);
        grafoMatriz.inserirVertice(d);
        
        grafoMatriz.inserirAresta(aresta1);
        grafoMatriz.inserirAresta(aresta2);
        grafoMatriz.inserirAresta(aresta3);
        grafoMatriz.inserirAresta(aresta4);
        grafoMatriz.inserirAresta(aresta5);
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
        assertEquals(vertices, grafoMatriz.vertices());
        assertEquals(adjacencias, grafoMatriz.arestas());
    }
    
    
    @Test
    public void testArestasIncidentes() {
        ArrayList<Aresta<Integer>> incidentes = new ArrayList();
        incidentes.add(aresta1);
        incidentes.add(aresta4);
        
        assertEquals(incidentes, grafoMatriz.arestasIncidentes(a));
    }

    @Test
    public void testOposto() {
        assertEquals(a, grafoMatriz.oposto(b, aresta1));
    }
    
    @Test
    public void testVerticesFim() {
        ArrayList<Vertice<Integer>> vFim = new ArrayList();
        vFim.add(a);
        vFim.add(b);
        
        assertEquals(vFim, grafoMatriz.verticesFim(aresta1));
    }
    
    @Test
    public void testSaoAdjacentes() {
        assertEquals(true, grafoMatriz.saoAdjacentes(a, b));
        assertEquals(false, grafoMatriz.saoAdjacentes(a, c));
    }
    
    @Test
    public void showLista() {
        Vertice<Integer> aux;
        Aresta<Integer> arestaAux;
        System.out.print("---");
        for (int i = 0; i < grafoMatriz.vertices().size(); i++) {
            aux = (Vertice<Integer>)grafoMatriz.vertices().get(i);
            System.out.print(" " + aux.getAtributos() + "  ");
        }
        System.out.println("");
       
        
        for (int i = 0; i < grafoMatriz.vertices().size(); i++) {
            aux = (Vertice<Integer>)grafoMatriz.vertices().get(i);
            System.out.print(" " + aux.getAtributos() + " ");
            for (int j = 0; j < grafoMatriz.vertices().size(); j++) {
                arestaAux = (Aresta<Integer>)grafoMatriz.arestas().get(j);
               
                if (!aux.equals((Vertice<Integer>)grafoMatriz.vertices().get(j))) {
                     if (arestaAux.getOrigem().equals(aux)){
                         if (arestaAux.getDestino().equals((Vertice<Integer>)grafoMatriz.vertices().get(i))) System.out.print(" " + arestaAux.getAtributos() + " ");
                     } else  if (arestaAux.getDestino().equals(aux)){
                         if (arestaAux.getOrigem().equals((Vertice<Integer>)grafoMatriz.vertices().get(j))) System.out.print(" " + arestaAux.getAtributos() + " ");
                     } else {
                         System.out.print(" \\  ");
                     }
                } else {
                    System.out.print(" 0  ");
                }
            }
            System.out.println("");
        }
    }
    
    @Test
    public void testRemover() {
        vertices.remove(a);
        grafoMatriz.removerVertice(a);
        assertEquals(vertices, grafoMatriz.vertices());
    }
    

    
    
}
