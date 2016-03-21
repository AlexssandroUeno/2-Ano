
import java.util.ArrayList;
public class CarrinhoDeCompras
{
  private ArrayList<String> produtos = new ArrayList<String>();

  public void addProdutos(String produtos)
  {
    this.produtos.add(produtos);
     System.out.println("Produto adicionado !!");
  }
  public void removeProdutos(String produtos)
  {
      
      System.out.println("produto removido!!");
  	this.produtos.remove(produtos);
  	
  } 
  public void showProdutos()
  {
  	for(String qualquercoisanafrente : produtos )
	{
		System.out.println("Lista ->"+qualquercoisanafrente);
	}
  	
  }
  
}





