package Grafos;

import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class GrafoAdjacencias here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrafoAdjacencias<V, A> implements Grafo<V, A>
{
    /**
     * Constructor for objects of class GrafoAdjacencias
     */
    public GrafoAdjacencias() {
        this.vertices = new ArrayList<Vertice<V>>();
        this.adjacencias = new ArrayList<Aresta<A>>();
    }
    
    @Override
    public List<Vertice<V>> vertices() {
        return this.vertices;
    }
    
    @Override
    public List<Aresta<A>> arestas() {
        return this.adjacencias;
    }
    
    @Override
    public List<Aresta<A>> arestasIncidentes(Vertice<V> v) {
        ArrayList<Aresta<A>> incidentes = new ArrayList();
        
        for (Aresta a : adjacencias) {
            if (a == null) break;
            
            if((a.getOrigem().equals(v)) || (a.getDestino().equals(v))) {
                incidentes.add(a);
            }
        }
        
        return incidentes;
    }
    
    @Override
    public Vertice<V> oposto(Vertice<V> v, Aresta<A> e) {
        if (e.getOrigem().equals(v)) {
            return e.getDestino();
        } else if (e.getDestino().equals(v)) {
            return e.getOrigem();
        } else {
            return null;
        }
    }
    
    @Override
    public List<Vertice<V>> verticesFim(Aresta<A> e) {
        ArrayList<Vertice<V>> vFim = new ArrayList();
        vFim.add(e.getOrigem());
        vFim.add(e.getDestino());
        return vFim;
    }
    
    @Override
    public boolean saoAdjacentes(Vertice<V> v, Vertice<V> w) {
        for(Aresta a: adjacencias){            
            if (a == null) break;
            
            if(a.getOrigem().equals(v)){
                if(a.getDestino().equals(w)) return true; 
                
            }else if(a.getDestino().equals(v)){                
                if(a.getOrigem().equals(w)) return true;                
            }
        }
        return false;
    }
    
    @Override
    public V mudarPeso(Vertice<V> v, V x) {
        return(v.setAtributos(x));
    }
    
    @Override
    public A mudarPeso(Aresta<A> e, A x) {
        return(e.setAtributos(x));
    }
    
    @Override
    public Vertice<V> inserirVertice(V x) {
        Vertice<V> ins = new Vertice<V>(x);
        vertices.add(ins);
        return ins;
        //throw new UnsupportedOperationException("Funcionalidade ainda não implementada pelo aluno.");
    }
    
    public Vertice<V> inserirVertice(Vertice<V> vertice) {
        vertices.add(vertice);
        return vertice;
    }
    
    @Override
    public Aresta<A> inserirAresta(Vertice<V> v, Vertice<V> w, A x) {
        Aresta<A> ins = new Aresta(v, w, x);
        adjacencias.add(ins);
        return ins;
    }
    
    public Aresta<A> inserirAresta(Aresta<A> aresta) {
        adjacencias.add(aresta);
        return aresta;
    }
    
    @Override
    public V removerVertice(Vertice<V> v) {
        ArrayList<Aresta<A>> removidas = new ArrayList();
        for (Aresta a : adjacencias) {
            if (a == null) break;
            
            if ((a.getOrigem().equals(v)) || (a.getDestino().equals(v))) {
                removidas.add(a);
            }
        }
        
        for (Aresta a : removidas) {
            if (a == null) break;
            
            adjacencias.remove(a);
        }
        
        for (Vertice vert : vertices) {
            if (vert.equals(v)) {
                vertices.remove(vert);
                return v.getAtributos();
            }
        }
        
        return null;
    }
    
    @Override
    public A removerAresta(Aresta<A> e) {
        for (Aresta a : adjacencias) {
            if (a.equals(e)) {
                adjacencias.remove(a);
                return e.getAtributos();
            }
        }
        
        return null;
    }
    
    private ArrayList<Vertice<V>> vertices;
    private ArrayList<Aresta<A>> adjacencias;
}
