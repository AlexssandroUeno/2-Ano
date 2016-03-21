import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Redimensionavel.java
 * 
 * Classe  que contem os eixos redimensionaveis de acordo com a tela e tambem
 * faz parte da criacao dos graficos
 * 
 * @author Thelokys
 * @version 16/04/2015
 */
public class Redimensionavel
{
    /**
     * Construtor para incialização dos valores
     */
    public Redimensionavel(float x,float y, float largura, float altura)
    {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }
    
    
   public int getXRel(Dimension dim){
        return (int)(x*dim.width);
    }
    
   public int getYRel(Dimension dim){
        return (int)(y*dim.height);
   }
   
   public int getLarguraRel(Dimension dim){
    return (int)(largura*dim.width);
   }
    
   public int getAlturaRel(Dimension dim){
        return (int)(altura*dim.height);
   }
   
   public float x,y,largura,altura;
}
