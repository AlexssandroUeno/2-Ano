
/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador
{
    public Contador() {
    }
    
    public void contarComparacao() {
        this.comps++;
    }
    
    public int getComparacoes() {
        return this.comps;
    }
    
    public void contarEscritas(int qtde) {
        this.memWrites += qtde;
    }
    
    public int getEscritas() {
        return this.memWrites;
    }
    
    private int memWrites = 0;
    private int comps = 0;
}
