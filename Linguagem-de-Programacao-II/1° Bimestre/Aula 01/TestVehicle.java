
public class TestVehicle
{
 public static void main(String []args)
 {
    Vehicle car = new Vehicle();
    car.setColor("BLACK");
    car.setAno(2005);
    car.setModelo("Fiat");
    car.setPreco(35000.00);
    
    /**Mostrando dados*/
    System.out.println("Cor: "+ car.getColor());
    System.out.println("Ano: "+car.getAno());
    System.out.println("Modelo: "+car.getModelo());
    System.out.println("Preço: "+car.getPreco());
 }
}
