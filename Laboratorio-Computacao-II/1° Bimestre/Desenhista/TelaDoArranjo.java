import javax.swing.*;
import java.awt.*;
import java.util.*;
class TelaDoArranjo extends JPanel{

    // Constantes importantes
    final int TAMANHO_MARGEM_TXT = 10;
    final int TAMANHO_LINHA_TXT = 15;
    
    // Campos da classe
    private int[] arranjo = { 1 };
    
    
    /**
     * Construtor principal da Tela.
     * 
     * @param arranjo Arranjo de int a ser desenhado na tela.
     */
    public TelaDoArranjo(int[] arranjo) {
        this();
        
        this.arranjo = arranjo;
    }
    
    /**
     * Outro construtor para a Tela. Possui o mesmo comportamento que o construtor principal, porém
     * aceita receber número em uma String separados por ",".
     * 
     * @param arranjo String com números separados por vírgula.
     */
    public TelaDoArranjo(String arranjo) {
        this(textoParaArranjo(arranjo));
    }
    
    /**
     * Construtor padrão da classe, considera que deva um arranjo com apenas um elemento. Aqui se
     * configura alguns dos comportamentos dos objetos.
     */
    public TelaDoArranjo() {
     
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }
    
    
    /**
     * Define um novo arranjo para ser desenhado na tela.
     * 
     * @param novoArranjo Arranjo com quantos valores forem desejados a serem desenhados.
     */
    public void setArranjo(int[] novoArranjo) {
        this.arranjo = novoArranjo;
    }
    
    /**
     * Define um novo arranjo para ser desenhado na tela.
     * 
     * @param novoArranjo String com valores numéricos separados por ",".
     */
    public void setArranjo(String novoArranjo) {
        setArranjo(textoParaArranjo(novoArranjo));
    }
    
    
    /**
     * Método auxiliar para a classe que converte para um arranjo de ints uma sequencia de valores em
     * String, separados por ",". Valores não numéricos são considerados como 0.
     * 
     * @param textoArranjo String com valores separados por ",".
     * @return Arranjo de inteiros de acordo com a String de entrada.
     */
    private static int[] textoParaArranjo(String textoArranjo) {
        String[] numeros = textoArranjo.split(",");
        int[] arranjo = new int[numeros.length];
        
        for (int i = 0; i < numeros.length; i++) {
            try {
                arranjo[i] = Integer.parseInt(numeros[i]);
            } catch (NumberFormatException nfe) {
                String entradaErrada = nfe.getMessage();
                int posIni = entradaErrada.indexOf("\"") + 1;
                int posFim = entradaErrada.lastIndexOf("\"");
                entradaErrada = entradaErrada.substring(posIni, posFim);
                
                System.out.println("Ignorando entrada '" + entradaErrada + "'. Utilizado valor 0.");
                arranjo[i] = 0;
            }
        }
        
        return arranjo;
    }
    
    /**
     * Método que escreve informações auxiliares úteis. Elas são:
     *  - Dimensões da tela
     *  - Arranjo desenhado
     *  - Maior Elemento
     * @param g2d Pincel utilizado para desenhar na tela.
     */
    private void exibirInfosUteis(Graphics2D g2d) {
        Dimension dim = getSize();
        StringBuilder txtDim = new StringBuilder("Dimensões da tela: ");
        txtDim.append(dim.width).append(" X ").append(dim.height);
        g2d.drawString(txtDim.toString(), TAMANHO_MARGEM_TXT, TAMANHO_LINHA_TXT);
        StringBuilder txtArranjo = new StringBuilder("Arranjo desenhado: ");
        for (int n : arranjo) {
            txtArranjo.append(n).append(",");
        }
        txtArranjo.deleteCharAt(txtArranjo.length() - 1);
        g2d.drawString(txtArranjo.toString(), TAMANHO_MARGEM_TXT, TAMANHO_LINHA_TXT * 2);
        g2d.drawString("Maior Element: "+maiorElem(arranjo), TAMANHO_MARGEM_TXT, TAMANHO_LINHA_TXT * 3);
    }
    
    
    /**
     * Método responsável por desenhar o arranjo, além de outros elementos gráficos secundários e
     * auxiliares. É aqui que os alunos deverão trabalhar. Porém devem evitar de fazerem um código
     * demasiadamente grande, devem separar em métodos auxiliares (subrotinas) sempre que possível.
     * 
     * @param g Pincel do desenhista.
     * @see java.awt.Graphics, java.swing.Graphics2D
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        exibirInfosUteis(g2d);
       // Seu código desenhista começa aqui!
       //REDIMENSIONAVEL
       desenhoRedimensionavel(g2d);
       //não redimensionavel
//        int posi = 0;
//        int max = arranjo.length;
//        int maior = maiorElem(arranjo);
// 
//        while(posi < max)         
//        {
//             Rectangle grafico = new Rectangle(BORDER + (WIDTH*posi)+(SEPARATION*posi),
//             HEIGHT_RECT - HEIGHT*arranjo[posi]/maior,WIDTH,HEIGHT*arranjo[posi]/maior);
//             g2d.setColor(BLUE);         
//             g2d.fill(grafico);
//             g2d.setColor(BORDER_BLACK);
//             g2d.draw(grafico);
//             g2d.drawString(""+arranjo[posi],SEPARATION+(WIDTH*posi)+(SEPARATION*posi), POS_Y);
//             posi+=1;
//        }
    
    }
    /******************************************
     * Todos os seus métodos auxiliares estão daqui para baixo. Lembre-se de sempre escrever o
     * devido javadoc.
     */
    
    /**
     * aqui contem o método redimensionavel
     * 
     * pegamos o tamanho da dimensao da tela, e fazemos desenho em referencia a ela. Com a ajuda da classe
     * Redimensionavel lá contem os dados que será passado para essa classe, afim de redimensionar o gráfico
     * 
     * @param Graphics g2d - parametro para criacao de graficos assim, criando o graficos redimensionaveis.
     * 
     */
       
    public void desenhoRedimensionavel(Graphics g2d)
    {

       int posi = 0;
       int max = arranjo.length;
       int maior = maiorElem(arranjo);
       Dimension dim = getSize();
       float espacamento = .02f;
       float largura_barra = 0.6f;
       float altura_barra = .4f;
       float espacamentoVertical = .7f;
       Redimensionavel r=null;
       
       while(posi < max)         
       {
           
           r = new Redimensionavel(espacamento+.6f*posi/max+.3f*posi/max,
                                                  espacamentoVertical - (altura_barra*arranjo[posi]/maior),
                                                  largura_barra/(max+1),
                                                  altura_barra*arranjo[posi]/maior);
            
            g2d.setColor(BLUE);
            g2d.fillRect(r.getXRel(dim),
                         r.getYRel(dim),
                         r.getLarguraRel(dim),
                         r.getAlturaRel(dim));
                         
            g2d.setColor(BORDER_BLACK);
            g2d.drawRect(r.getXRel(dim),
                         r.getYRel(dim),
                         r.getLarguraRel(dim),
                         r.getAlturaRel(dim));
            g2d.drawString(""+arranjo[posi],r.getXRel(dim)+r.getLarguraRel(dim)/2, r.getYRel(dim)+r.getAlturaRel(dim)+15);
            posi+=1;
       }
    }
    
    
   
    
    
    /**
     * Este método encontra o maior elemento de um arranjo de entrada.
     * 
     * @param arranjo Arranjo a ser procurado pelo seu maior elemento.
     * @return Valor do maior elemento.
     */
    private static int maiorElem(int[] arranjo) {
        int[] novoArranjo = arranjo;
        Arrays.sort(novoArranjo);//ordernar vetor crescente
        return novoArranjo[novoArranjo.length-1];//pegar ultimo elemento do vetor
    }
      final int HEIGHT = 300;
      final int WIDTH  = 72;
      final int BORDER = 20;
      final int SEPARATION  = 50;
      final int HEIGHT_RECT = 400;
      final int POS_Y = 420;
      final Color BORDER_BLACK = new Color(0,0,0);
      final Color BLUE = new Color(0,255,255);
    
      
       
      
}