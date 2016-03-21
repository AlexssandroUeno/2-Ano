
public class testMusica
{
    public static void main(String[] args) {
        Musica som = new Musica();
        som.setNome("Whisper in the dark");
        som.setArtista("Skillet");
        System.out.println(som.tocar());
    }
}
