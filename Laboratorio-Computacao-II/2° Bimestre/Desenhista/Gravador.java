import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.awt.Color;

/**
 * My teacher is awesome, look all this project.
 * 
 * Here on Gravador's class we have a bunch of methods to coloring and print the graphics
 * 
 * @author Ricardo I. A. e Silva
 * @student Jose Ricardo G jr. <- '@student' doesnt work, I know !
 */
public class Gravador
{
    public Gravador() {
        this.seqGravacoes = new LinkedList<Transparencia>();
    }
    
    /**
     *  The gravarArranjo, here our array is showed on screen
     * 
     * @param arranjo, Integer's array
     * @param nome, String's name of reference that's going to do
     */
    public void gravarArranjo(int[] arranjo, String nome) {
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, nome);
        seqGravacoes.add(gravacao);
    }
    
    /**
     * The gravarIndiceDestacado, here we are adding color on array's element 
     * 
     * @param arranjo, Integer's array which reference array's element selected wherein we will coloring
     * @param nome, String's name of reference that's going to do
     */
    public void gravarIndiceDestacado(int[] arranjo, int i, String nome) {
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        cores[i] = Color.YELLOW;
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, nome);
        seqGravacoes.add(gravacao);
    }
    
    /**
     * The gravarIndex, here we are adding color to array's elements who is in parameter
     * 
     * @param arranjo, Integer's array that reference collection's element selected where we will coloring
     * @param i, Index's reference in the graphic
     * @param j, Reference element to coloring in graphics
     */
    public void gravarIndex(int[] arranjo, int i, int j) {
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        cores[i] = cores[j] = Color.GREEN;
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, "Comparação");
        seqGravacoes.add(gravacao);
    }
    

    /**
     * The gravarComparaçãoSimples, here we are adding color to array's elements who is in compared
     * 
     * @param arranjo, Integer's array that reference collection's element selected where we will coloring
     * @param i, One of integer that reference element in compare to Another Integer
     * @param j, Another of integer that reference element in compare to Another Integer
     */
    public void gravarComparaçãoSimples(int[] arranjo, int i, int j) {
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        cores[i] = cores[j] = Color.GRAY;
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, "Comparação");
        seqGravacoes.add(gravacao);
    }
    
    /**
     * The gravarPosTrocas, here we are adding color to array's elements on which was on compared(after compare)
     * 
     * @param arranjo, Integer's array that reference collection's element selected where we will coloring
     * @param i, Reference of integer to color after compare 
     * @param j, Another integer's reference after compare
     */
    public void gravarPosTrocas(int[] arranjo, int i, int j) {
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        cores[i] = cores[j] = Color.YELLOW;
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, "Pós-troca");
        seqGravacoes.add(gravacao);
    }    
    
    /**
     * The gravarBuscaBinaria, here we adding color to array at start and in the last one
     * 
     * @param arranjo, Integer's array that reference to first and last element
     * @param inicio, Reference to the inicial element
     * @param fim, This reference the index of end element 
     */
    public void gravarBuscaBinaria(int[]arranjo, int inicio, int fim){
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        cores[inicio] = Color.RED;
        cores[fim] = Color.BLACK;  
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, "Início e fim");
        seqGravacoes.add(gravacao);
    }
    
     /**
     * The gravarComparacao, here we are adding color to array's elements
     * 
     * we have of parameter some vars
     * 
     * @param arranjo, Integer's array that reference collection's element selected where we will coloring
     * @param i, Reference of  index on array's element
     * @param j, Reference of  index on array's element
     * @param k, Reference of  index on array's element
     */
    public void gravarComparacao(int[]arranjo, int i, int j, int k){
        int[] copia = Arrays.copyOf(arranjo, arranjo.length);
        Color[] cores = new Color[arranjo.length];
        cores[i] = cores[j] = Color.GRAY; 
        cores[k] = Color.RED;
        ArranjoGravado gravacao = new ArranjoGravado(copia, cores, "Comparação");
        seqGravacoes.add(gravacao);
    }
    
    /**
     * The getFilme creates an Integer list imported of class's Transparencia
     * 
     * @return ListIterator, Return a list of integer
     */
    public ListIterator<Transparencia> getFilme() {
        return seqGravacoes.listIterator();
    }
    
    private LinkedList<Transparencia> seqGravacoes; //var reference to class's transparencia
}
