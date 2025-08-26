package Tudo;

public class Musica extends Midia {

    public Musica(String titulo, String artista, int duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
    }

    @Override
    public String getTipo() {
        return "Música";
    }
}
