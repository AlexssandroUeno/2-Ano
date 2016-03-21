public class Alarme
{
   private int hora;
   private int minuto;
   private boolean ligado;
   
   private boolean ligadoA;
   private int horaA;
   private int minA;
  public Alarme()
  {
       hora   = 00;
       minuto = 00;
       horaA  = 00;
       minA   = 00;
       ligado = false;
       ligadoA= false;
  }
  public void setHora(int hora, int minuto)
  {
        this.hora = hora;
        this.minuto = minuto;
  }
  public String getHora()
  {
    
      return hora+":"+minuto;   
    }
  public void setHoraAlarme(int horaA, int minA)
  {
        this.horaA = horaA;
        this.minA = minA;
  }
  public String getHoraAlarme()
  {
      return horaA+ ":" +minA;
  }
  public void setligado()
  {
      ligado = true;
  }
  public void setligadoA()
  {
      ligadoA = true;
  }
  public String getStatus()
  {
      if(ligado)
      {
          if(ligadoA)
          {
              return "Horas: "+getHora()
              +"\n Alarme marcado para: "+getHoraAlarme();
          }
        return "Horas: "+getHora()
        +"\n Alarme Desligado";
      }
      else
      {
        return "Relógio desligado";
      }     
  }
}
