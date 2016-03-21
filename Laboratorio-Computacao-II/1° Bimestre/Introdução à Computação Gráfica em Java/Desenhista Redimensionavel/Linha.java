import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Polygon;
/**
 * Linha.java
 * Trabalho feito pelo professor Ricardo com algumas modificações minha
 * @author Thelokys 
 * @version 16/03/2015... 21/03/2015
 */
public class Linha
{
    public Linha(Ponto p0, Ponto p1) {
        this.p0 = p0;
        this.p1 = p1;
    }
    public void desenharLinhaRelativa(Graphics2D pincel, Dimension dim){
        //DESENHO DE LINHA
        pincel.drawLine(
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim));
        
    }
    public void desenharRetanguloRelativo(Graphics2D pincel, Dimension dim, Color color){
        pincel.setColor(color);
         pincel.fillRect(p0.getXRelativo(dim), p0.getYRelativo(dim), p1.getXRelativo(dim),p1.getYRelativo(dim)); 
         pincel.setColor(Color.BLACK);
        pincel.drawRect(
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim));
    }
    public void desenharOvalRelativo(Graphics2D pincel, Dimension dim, Color color){
         pincel.setColor(color);
         pincel.fillOval(p0.getXRelativo(dim), p0.getYRelativo(dim), p1.getXRelativo(dim),p1.getYRelativo(dim)); 
         pincel.setColor(Color.BLACK);
         pincel.drawOval(
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim));
            
    }
     public void desenharOlhoRelativo(Graphics2D pincel, Dimension dim){
        pincel.fillOval(p0.getXRelativo(dim), p0.getYRelativo(dim), p1.getXRelativo(dim),p1.getYRelativo(dim)); 
        pincel.setColor(Color.BLACK);
        pincel.drawOval(
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim));
    }
     public void desenharArcRelativo(Graphics2D pincel, Dimension dim){
        pincel.drawArc(
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim),
            0,180);
    }
     public void desenharBocaSmile1(Graphics2D pincel, Dimension dim){
         
         pincel.fillArc( 
            p0.getXRelativo(dim),
            p0.getYRelativo(dim),
            p1.getXRelativo(dim),
            p1.getYRelativo(dim),180, 180);
         
    }
    public void desenharString(Graphics2D pincel, Dimension dim){
         pincel.setColor(Color.RED);
         pincel.drawString( 
            "AlunoTEC",
            p0.getXRelativo(dim),
            p0.getYRelativo(dim));
            
         
    }
    public void desenharPolygon(Graphics2D pincel, Dimension dim, int numLados)
    {
        Polygon p = new Polygon();
           
        for (int i = 0; i < numLados; i++){
          p.addPoint((int) (p0.getXRelativo(dim) + p0.getYRelativo(dim) *
                Math.cos(i * 2 * Math.PI / numLados)),
                (int) (p1.getXRelativo(dim)+ p1.getYRelativo(dim)* 
                Math.sin(i * 2 * Math.PI / numLados)));
            }
         pincel.setColor(Color.ORANGE);
         pincel.fill(p);
         pincel.setColor(Color.BLACK);
         pincel.drawPolygon(p);
       
    }

    public Ponto p0;
    public Ponto p1;
}
