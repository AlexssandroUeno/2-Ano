
/**
 * VeiculoAVenda.java
 * 
 * @author Jose Ricardo Guidetti Junior
 * @version 08/13/2015
 */
public class VeiculoAVenda
{
   private String tipo;     
   private int ano;
   private double precoDeVenda;
   
   public VeiculoAVenda( String t, int a, double p ) {
       this.tipo = t;
       this.ano = a;
       this.precoDeVenda = p;
   }
   
   public String toString(){
       return "Tipo: "+tipo+"\nAno: "+ano+"\nPreço de venda: "+precoDeVenda;
   }
}
