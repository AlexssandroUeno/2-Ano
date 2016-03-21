public class Televisao
{
   private int tamanho;
   private boolean ligada;
   private double preco; 
   private int canal;
   private int volume;
   public Televisao()
   {
        tamanho = 15;
        ligada = false;
        preco = 0;
        canal = 0;
        volume = 0;
   }
   public String isLigada()
   {
        if(ligada)
           return "TV está Ligada";
        else 
            return "TV está desligada"; 
   }
   public int getCanal(){return canal;}
   public int getTamanho(){return tamanho;}
   public double getPreco(){return preco;}
   public int getVolume(){return volume;}   
   public void setTamanho(int tamanho){this.tamanho = tamanho;}
   public void setPreco(int preco){this.preco = preco;}
   public void setCanal(int canal){this.canal = canal;}
   public void aumentarVolume(){this.volume += 5;}
   public void diminuirVolume(){this.volume -= 5;}
   @Override
   public String toString()
   {
       return   "Preço: "+preco
               +"\nCanal: "+canal
               +"\nTamanho: "+tamanho
               +"\nStatus: "+isLigada()
               +"\nVolume: "+volume;   
   }

}
