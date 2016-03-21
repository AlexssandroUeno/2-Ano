import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Arrays;
/**
 * Write a description of class ArranjoGravado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArranjoGravado implements Transparencia
{
    /**
     * Constructor for objects of class ArranjoGravado
     */
    public ArranjoGravado(int[] arranjo, Color[] corIdxs, String nome) {
        this.arranjo = arranjo;
        this.nome = nome;
        this.corIdxs = corIdxs;
    }
    
    public void pintar(Graphics2D pincel, JPanel contexto) {
        Dimension dim = contexto.getSize();
        desenhoRedimensionavel(pincel, dim);
    }
    
    /**
     *  aqui contem o método redimensionavel
     * 
     *  pegamos o tamanho da dimensao da tela, e fazemos desenho em referencia a ela. 
     *  Com a ajuda da classe classe Redimensionavel lá contem os dados que será
     *  passado para essa classe, afim de redimensionar o gráfico.
     * 
     *  @param Graphics g2d - parametro para criacao de graficos assim, criando o graficos redimensionaveis.
     */
    public void desenhoRedimensionavel(Graphics2D g2d, Dimension dim)
    {

        int posi = 0;
        int max = arranjo.length;
        int maior = maiorElem(arranjo);
        float espacamento = .02f;
        float largura_barra = 0.6f;
        float altura_barra = .4f;
        float espacamentoVertical = .7f;
        Redimensionavel r = null;

        while(posi < max)         
        {
            if(corIdxs[posi] == null){
                g2d.setColor(BLUE);
            }else{
                g2d.setColor(corIdxs[posi]);
            }
            r = new Redimensionavel(espacamento+.6f*posi/max+.3f*posi/max,
                                                  espacamentoVertical - (altura_barra*arranjo[posi]/maior),
                                                  largura_barra/(max+1),
                                                  altura_barra*arranjo[posi]/maior);
            
            g2d.fillRect(r.getXRel(dim),
                         r.getYRel(dim),
                         r.getLarguraRel(dim),
                         r.getAlturaRel(dim));
                         
            g2d.setColor(BORDER_BLACK);
            g2d.drawRect(r.getXRel(dim),
                         r.getYRel(dim),
                         r.getLarguraRel(dim),
                         r.getAlturaRel(dim));
                         
            g2d.drawString(""+arranjo[posi],
            r.getXRel(dim)+r.getLarguraRel(dim)/2, 
            r.getYRel(dim)+r.getAlturaRel(dim)+15);
            posi+=1;
        }
    }
    
    /**
     * Este método encontra o maior elemento de um arranjo de entrada.
     * 
     * @param arranjo Arranjo a ser procurado pelo seu maior elemento.
     * 
     * @return Valor do maior elemento.
     */
    private int maiorElem(int[] arranjo) {
        int[] novoArranjo = new int[arranjo.length];
        for(int i= 0; i <arranjo.length; i++){
            novoArranjo[i] = arranjo[i];
        }
        
        Arrays.sort(novoArranjo);//ordernar vetor crescente
        return novoArranjo[novoArranjo.length-1];//pegar ultimo elemento do vetor
    }
    
    private int[] arranjo;
    private Color[] corIdxs;
    private String nome;
    
      final int HEIGHT = 300;
      final int WIDTH  = 72;
      final int BORDER = 20;
      final int SEPARATION  = 50;
      final int HEIGHT_RECT = 400;
      final int POS_Y = 420;
      final Color BORDER_BLACK = new Color(0,0,0);
      final Color BLUE = Color.BLUE;
      final Color RED = new Color(252,31,31);
}
