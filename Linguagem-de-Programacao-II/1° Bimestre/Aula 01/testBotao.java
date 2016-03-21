public class testBotao
{
   public static void main(String [] args)
   {
       Botao b = new Botao();
       b.setColor("PRETO");
       b.setNome("EXPLOSION");
      
       /**Informações do botao*/
       System.out.println("Nome : "+ b.getNome());
       System.out.println("Cor  : "+b.getCor());
       b.dePress();
       b.unPress();
       
   }
}
