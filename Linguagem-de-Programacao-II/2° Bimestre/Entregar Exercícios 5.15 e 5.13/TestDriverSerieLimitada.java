public class TestDriverSerieLimitada {
    public static void main(String[] args) {
        SerieLimitada s = null;
        while(true){
            if(s.getInstance()!= null){
              System.out.println("Instancia foi criada!!!");
        }else{
            System.out.println("A classe SerieLimitada so pode ter "+s.maximoDeInstancia+" instancia");
            break;
        }
          
        }
        
    }
}