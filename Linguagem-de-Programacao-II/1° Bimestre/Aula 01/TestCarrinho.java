
public class TestCarrinho
{
    public static void main (String []args)
    {
    	CarrinhoDeCompras cart = new CarrinhoDeCompras();
	cart.addProdutos("banana");
	cart.addProdutos("pera");
	cart.addProdutos("melancia");
	cart.removeProdutos("pera");
	cart.showProdutos();
    }
}
