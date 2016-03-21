public class Botao
{
	private String cor;
	private String nome;
	public Botao()
	{
		nome = "";
		cor = "";
	}

	public String getCor(){return cor;}

	public void setColor(String cor){this.cor = cor;}

	public void dePress(){System.out.println("Pressionando botao");}

	public void unPress(){System.out.println("Despressionando botao");}

	public void setNome(String nome){this.nome = nome;}

	public String getNome(){return nome;}

}

