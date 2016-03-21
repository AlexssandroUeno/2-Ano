public class TestAlarme
{
   public static void main(String []args)
   {
       Alarme set = new Alarme();
       set.setligado();
       set.setHora(12,00);
       set.setligadoA();
       set.setHoraAlarme(15,35);
       System.out.println(set.getStatus());
    
    
   }
}
