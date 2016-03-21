import java.awt.Dimension;
/**
 * Write a description of class Ponto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ponto
{
    public Ponto(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public int getXRelativo(Dimension dim){
        return (int)(x*dim.width);
    }
    public int getYRelativo(Dimension dim){
        return (int)(y*dim.height);
    }
    public float x;
    public float y;
}
