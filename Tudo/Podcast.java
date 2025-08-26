package Tudo;

public class Podcast extends Midia {

    public Podcast(String titulo, String artista, int duracao) {
        super(titulo, artista, duracao, Genero.PODCAST);
    }

    @Override
    public String getTipo() {
        return "Podcast";
    }
}
