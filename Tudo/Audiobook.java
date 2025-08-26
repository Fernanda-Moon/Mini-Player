package Tudo;

public class Audiobook extends Midia {

    public Audiobook(String titulo, String artista, int duracao) {
        super(titulo, artista, duracao, Genero.AUDIOBOOK);
    }

    @Override
    public String getTipo() {
        return "Audiobook";
    }
}
