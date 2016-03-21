package Grafos;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class GrafoMatriz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrafoMatriz<V, A> implements Grafo<V, A>
{
    /**
     * Constructor for objects of class GrafoMatriz
     */
    public GrafoMatriz() {
        this.vertices = new ArrayList<Vertice<V>>();
        this.arestas = new ArrayList<Aresta<A>>();
        this.matrizArestas = (Aresta<A>[][])new Aresta[vertices.size()][vertices.size()];
    }
    
    @Override
    public List<Vertice<V>> vertices() {
        return vertices;
    }
    
    @Override
    public List<Aresta<A>> arestas() {
        return arestas;
    }
    
    public Aresta<A>[][] getMatriz() {
        return matrizArestas;
    }
    
    @Override
    public List<Aresta<A>> arestasIncidentes(Vertice<V> v) {
        ArrayList<Aresta<A>> incidentes = new ArrayList();
        
        for (Aresta a : arestas) {
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
        for(Aresta a: arestas){            
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
        if (vertices.size() >= matrizArestas.length) {
            Aresta<A>[][] aux = (Aresta<A>[][])new Aresta[vertices.size()*2][vertices.size()*2];
            for (int i = 0; i < matrizArestas.length; i++) {
                for (int j = 0; j < matrizArestas.length; j++) {
                    aux[i][j] = matrizArestas[i][j];
                }
            }
            matrizArestas = aux;
        }
        return ins;
    }
    
    public Vertice<V> inserirVertice(Vertice<V> vertice) {
        vertices.add(vertice);
        
        if (vertices.size() >= matrizArestas.length) {
            Aresta<A>[][] aux = (Aresta<A>[][])new Aresta[vertices.size()*2][vertices.size()*2];
            for (int i = 0; i < matrizArestas.length; i++) {
                for (int j = 0; j < matrizArestas.length; j++) {
                    aux[i][j] = matrizArestas[i][j];
                }
            }
            matrizArestas = aux;
        }
        
        return vertice;
    }
    
    @Override
    public Aresta<A> inserirAresta(Vertice<V> v, Vertice<V> w, A x) {
        Aresta<A> ins = new Aresta(v, w, x);
        arestas.add(ins);
        
        matrizArestas[indiceVertice(v)][indiceVertice(w)] = ins;
        
        return ins;
    }
    
    public Aresta<A> inserirAresta(Aresta<A> aresta) {
        arestas.add(aresta);
        
        matrizArestas[indiceVertice(aresta.getOrigem())][indiceVertice(aresta.getDestino())] = aresta;
        
        return aresta;
    }
    
    @Override
    public V removerVertice(Vertice<V> v) {
        ArrayList<Aresta<A>> removidas = new ArrayList();
        for (Aresta a : arestas) {
            if (a == null) break;
            
            if ((a.getOrigem().equals(v)) || (a.getDestino().equals(v))) {
                removidas.add(a);
            }
        }
        
        for (Aresta a : removidas) {
            if (a == null) break;
            matrizArestas[indiceVertice(a.getOrigem())][indiceVertice(a.getDestino())] = null;
            arestas.remove(a);
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
        for (Aresta a : arestas) {
            if (a.equals(e)) {
                arestas.remove(a);
                matrizArestas[indiceVertice(a.getOrigem())][indiceVertice(a.getDestino())] = null;
                return e.getAtributos();
            }
        }
        
        return null;
    }
    
    private int indiceVertice(Vertice<V> vert) {
        int indice = 0;
        for (Vertice v : vertices) {
            if (v == null) break;
            
            if (v.equals(vert)) {
                return indice;
            }
            indice++;
        }
        
        return indice;
    }
    
    private ArrayList<Vertice<V>> vertices;
    private Aresta<A>[][] matrizArestas;
    private ArrayList<Aresta<A>> arestas;
    private int numVertices;
}
