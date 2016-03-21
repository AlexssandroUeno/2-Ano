
/**
 * Write a description of class NumRacional here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NumRacional
{
    private int numerador;
    private int denominador;

    public NumRacional()
    {
     
    }

    public NumRacional(int numerador, int denominador)
    {
     this.numerador = numerador;
     this.denominador = denominador;
    }
    
    public int getDenominador(){
        return this.denominador;
    }
    
    public int getNumerador(){
        return this.numerador;
    }
    
    public void setDenominador(int denominador){
         this.denominador = denominador;
    }
    
    public void setNumerador(int numerador){
         this.numerador = numerador;
    }
    
    public NumRacional somar(NumRacional b){
        NumRacional result = new NumRacional();
        result.setNumerador((this.numerador * b.getDenominador()) + (b.getNumerador() * this.denominador));
        result.setDenominador(this.denominador * b.getDenominador());
        return result;     
    }
}
