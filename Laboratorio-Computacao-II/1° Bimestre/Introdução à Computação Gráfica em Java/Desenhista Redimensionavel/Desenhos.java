import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Polygon;
import java.text.DecimalFormat;

/**
 * Write a description of class Desenhos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Desenhos
{
    
    public static void desenhoLivre(Graphics2D g2d, Dimension dim) {  
          
        
    }
    
    public static void desenharAsterisco(Graphics2D g2d, Dimension dim) {  
             /** Desenhar Asterisco*/
        Linha linhaH = new Linha(new Ponto(.15f, .46f), new Ponto(.30f, .46f));     //linha horizontal
        Linha linhaV = new Linha(new Ponto(.225f, .22f), new Ponto(.225f, .70f));   //linha vertical
        Linha linhaD1 = new Linha(new Ponto(.15f, .23f), new Ponto(.30f, .70f));    //linhas diagonal1    
        Linha linhaD2 = new Linha(new Ponto(.15f, .70f), new Ponto(.30f, .22f));    //linhas diagonal2            
            linhaH.desenharLinhaRelativa(g2d, dim);
            linhaV.desenharLinhaRelativa(g2d, dim);
            linhaD1.desenharLinhaRelativa(g2d, dim);
            linhaD2.desenharLinhaRelativa(g2d, dim);   
        }
    public static void desenharSmiles(Graphics2D g2d, Dimension dim) {
            /** Desenhar Smiles*/
        
        g2d.setStroke(new BasicStroke(5));      //Deixar linha mais grossa
        /** CARA DO SMILE1*/
        Linha smile1 = new Linha(new Ponto(.1f, .20f), new Ponto(.15f, .16f));     
            smile1.desenharOvalRelativo(g2d, dim,new Color(0,143,0));
            /** OLHOS SMILE1*/
        Linha olho1Smile1 = new Linha(new Ponto(.14f, .25f), new Ponto(.02f, .02f));
            olho1Smile1.desenharOlhoRelativo(g2d, dim); 
        Linha olho2Smile1 = new Linha(new Ponto(.19f, .25f), new Ponto(.02f, .02f));
            olho2Smile1.desenharOlhoRelativo(g2d, dim);
            /** BOCA SMILE1*/   
         Linha bocaSmile1 = new Linha(new Ponto(.13f, .24f), new Ponto(.09f, .1f));     
            bocaSmile1.desenharBocaSmile1(g2d, dim);     
       /****************************************************************************/        
            /** CARA DO SMILE2*/
        Linha smile2 = new Linha(new Ponto(.30f, .20f), new Ponto(.15f, .16f)); 
            smile2.desenharOvalRelativo(g2d, dim,new Color(255,251,0));
            /** OLHOS SMILE2*/
        Linha olho1Smile2 = new Linha(new Ponto(.34f, .25f), new Ponto(.02f, .02f));            
            olho1Smile2.desenharOlhoRelativo(g2d, dim);   
        Linha olho2Smile2 = new Linha(new Ponto(.39f, .25f), new Ponto(.02f, .02f));
            olho2Smile2.desenharOlhoRelativo(g2d, dim);
            /** BOCA SMILE2*/     
        Linha bocaSmile2 = new Linha(new Ponto(.336f, .31f), new Ponto(.414f, .31f));  
            bocaSmile2.desenharLinhaRelativa(g2d, dim);
       /****************************************************************************/
            /** CARA DO SMILE2*/
        Linha smile3 = new Linha(new Ponto(.50f, .20f), new Ponto(.15f, .16f)); 
            smile3.desenharOvalRelativo(g2d, dim, new Color(255,38,0));
             /** OLHOS SMILE2*/
        Linha olho1Smile3 = new Linha(new Ponto(.54f, .259f), new Ponto(.02f, .02f));            
            olho1Smile3.desenharOlhoRelativo(g2d, dim); 
        Linha olho2Smile3 = new Linha(new Ponto(.59f, .259f), new Ponto(.02f, .02f));
            olho2Smile3.desenharOlhoRelativo(g2d, dim);
            /** BOCA SMILE3*/  
        Linha bocaSmile3 = new Linha(new Ponto(.54f, .297f), new Ponto(.07f, .038f));
            bocaSmile3.desenharArcRelativo(g2d, dim);
            /** Sobrancelhas*/
            g2d.setColor(Color.BLACK);
        Linha sobrancelha1 = new Linha(new Ponto(.53f, .23f), new Ponto(.577f, .247f));    
            sobrancelha1.desenharLinhaRelativa(g2d, dim);
        Linha sobrancelha2 = new Linha(new Ponto(.578f, .247f), new Ponto(.619f, .23f));    
            sobrancelha2.desenharLinhaRelativa(g2d, dim); 
    }
    public static void desenharComputador(Graphics2D g2d, Dimension dim) {
            /** Desenhar Computador*/
            
                /** Gabinete*/
              Linha gabinete = new Linha (new Ponto(.20f, .37f), new Ponto(.15f, .40f));
              gabinete.desenharRetanguloRelativo(g2d, dim, Color.BLACK);
                    
                /** BAIAS*/
                g2d.setStroke(new BasicStroke(2));        
                  Linha cd = new Linha (new Ponto(.21f, .39f), new Ponto(.13f, .043f));
                    cd.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);
                  Linha dvd = new Linha (new Ponto(.21f, .43f), new Ponto(.13f, .043f));
                    dvd.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);
                  Linha blueray = new Linha (new Ponto(.21f, .47f), new Ponto(.13f, .043f));
                    blueray.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);
                    
                    /** Disquetes*/
                  Linha disquete1 = new Linha (new Ponto(.21f, .513f), new Ponto(.10f, .043f));
                    disquete1.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);
                  Linha disquete2 = new Linha (new Ponto(.21f, .553f), new Ponto(.10f, .043f));
                    disquete2.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);
                    
                    /** USBS*/
                  Linha usb = new Linha (new Ponto(.313f, .514f), new Ponto(.017f, .015f));
                    usb.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);  
                  Linha usb2 = new Linha (new Ponto(.313f, .529f), new Ponto(.017f, .015f));
                    usb2.desenharRetanguloRelativo(g2d, dim, Color.LIGHT_GRAY);
                    
                    /** HEADSET*/
                   g2d.setStroke(new BasicStroke(1));     
                  Linha microfone = new Linha (new Ponto(.23f, .601f), new Ponto(.0127f, .0127f));
                    g2d.setColor(Color.RED);
                    microfone.desenharOlhoRelativo(g2d, dim);
                  Linha foneOuvido = new Linha (new Ponto(.257f, .601f), new Ponto(.013f, .013f));
                      g2d.setColor(Color.GREEN);
                      foneOuvido.desenharOlhoRelativo(g2d, dim);
                   
                      /** turn ON/OFF*/
                   Linha turn = new Linha (new Ponto(.26f, .66f), new Ponto(.020f, .020f));
                    turn.desenharOvalRelativo(g2d,dim,Color.LIGHT_GRAY);

                    /**  Nome do PC*/
                    g2d.setColor(Color.RED);
                     Linha string = new Linha (new Ponto(.26f, .66f), new Ponto(.020f, .020f));
                    string.desenharString(g2d,dim);
    }
    public static void desenharPoligono(Graphics2D g2d, Dimension dim) {
            /** Desenhar Poligono*/
              Linha p = new Linha(new Ponto(.2f, .10f), new Ponto(.30f, .10f));
           p.desenharPolygon(g2d, dim, 3);
           
            Linha p1 = new Linha(new Ponto(.5f, .10f), new Ponto(.30f, .10f));
           p1.desenharPolygon(g2d, dim, 5);
           
            Linha p2 = new Linha(new Ponto(.25f, .10f), new Ponto(.50f, .10f));
           p2.desenharPolygon(g2d, dim, 7);
           
            Linha p3 = new Linha(new Ponto(.55f, .14f), new Ponto(.50f, .14f));
           p3.desenharPolygon(g2d, dim, 9);
            
    }
    
}
