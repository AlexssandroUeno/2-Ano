
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
    
    public NumRacional subt(NumRacional b){
        NumRacional result = new NumRacional();
        result.setNumerador((this.numerador * b.getDenominador()) - (b.getNumerador() * this.denominador));
        result.setDenominador(this.denominador * b.getDenominador());
        return result;     
    }
    
    public NumRacional div(NumRacional b){
        NumRacional result = new NumRacional();
        result.setNumerador((this.denominador * b.getDenominador()) * (b.getNumerador() * this.numerador));
        result.setDenominador(this.denominador * this.numerador);
        return result;     
    }
    
      public NumRacional mult(NumRacional b){
        NumRacional result = new NumRacional();
        result.setNumerador((this.numerador * b.getNumerador()));
        result.setDenominador(this.denominador * b.getDenominador());
        return result;     
    }
    
    
}
