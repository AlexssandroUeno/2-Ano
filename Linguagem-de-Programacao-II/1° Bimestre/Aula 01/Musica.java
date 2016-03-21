
public class Musica
{
  private String nome;
  private String artista;

 public void setNome(String nome){this.nome = nome;}
 public void setArtista(String artista){this.artista = artista;}
 public String tocar()
 {
 	return "Musicando tocando\n"+
 			"Nome: "+ nome+"\n"+
 			"Artista: "+artista;

 }
}
