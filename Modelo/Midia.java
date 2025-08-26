package Modelo;

public abstract class Midia {
    private String titulo;
    private String artista;
    private int duracao;
    private Genero genero;

    public Midia(String titulo, String artista, int duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + " (" + formatarDuracao() + ")";
    }

    public String formatarDuracao() {
        int minutos = duracao / 60;
        int segundos = duracao % 60;
        return String.format("%d:%02d", minutos, segundos);
    }
}
