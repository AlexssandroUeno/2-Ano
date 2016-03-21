public class TesteTV
{
   public static void main(String []args)
   {
      Televisao tv = new Televisao();
        tv.setCanal(15);
        tv.setPreco(500);
        tv.setTamanho(42);
        tv.aumentarVolume();
      /** Informações da tv*/
      System.out.println("informações da TV");
      System.out.println(tv);
   }
}
