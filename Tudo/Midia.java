package Tudo;

public abstract class Midia {
    protected String titulo;
    protected String artista;
    protected int duracao;
    protected Genero genero;


    public Midia(String titulo, String artista, int duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getArtista() {
        return artista;
    }


    public int getDuracao() {
        return duracao;
    }


    public Genero getGenero() {
        return genero;
    }


    public abstract String getTipo();


    @Override
    public String toString() {
        return String.format("%s: %s - %s (%d segundos)",
                getTipo(), titulo, artista, duracao);
    }
}
