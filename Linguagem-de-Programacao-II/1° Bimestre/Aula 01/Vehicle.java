public class Vehicle
{
  private double preco;
  private String color;
  private String modelo;
  private int ano;

  public Vehicle()
  {
  	preco = 0;
  	color = "";
  	modelo = "";
  	ano = 0;
  }
    public double getPreco(){return preco;}
    public String getColor(){return color;}
    public String getModelo(){return modelo;} 
    public int getAno(){return ano;}
    public void setPreco(double preco){this.preco = preco;}
    public void setColor(String color){this.color = color;}
    public void setModelo(String modelo){this.modelo = modelo; }
    public void setAno(int ano) {this.ano = ano;}
}