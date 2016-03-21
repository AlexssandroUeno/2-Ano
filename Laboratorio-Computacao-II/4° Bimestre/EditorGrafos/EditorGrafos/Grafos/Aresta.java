package Grafos;


/**
 * Write a description of class Aresta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aresta<A>
{
    public Aresta(Vertice origem, Vertice destino, A atributos) {
        this.origem = origem;
        this.destino = destino;
        this.atributos = atributos;
    }
    
    public Vertice getOrigem() { return this.origem; }
    public Vertice getDestino() { return this.destino; }
    public A getAtributos() { return this.atributos; }
    
    public void setOrigem(Vertice origem) { this.origem = origem; }
    public void setDestino(Vertice destino) { this.destino = destino; }
    
    public A setAtributos(A a) {
        this.atributos = a;
        return a;
    }
    
    private Vertice origem;
    private Vertice destino;
    private A atributos;
}
