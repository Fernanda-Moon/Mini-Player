package Modelo;

public class Audiobook extends Midia {
    private String autorLivro;

    public Audiobook(String titulo, String artista, int duracao, Genero genero, String autorLivro) {
        super(titulo, artista, duracao, genero);
        this.autorLivro = autorLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    @Override
    public String toString() {
        return super.toString() + " [Autor: " + autorLivro + "]";
    }
}
