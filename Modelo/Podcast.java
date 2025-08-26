package Modelo;

public class Podcast extends Midia {
    private String episodio;

    public Podcast(String titulo, String artista, int duracao, Genero genero, String episodio) {
        super(titulo, artista, duracao, genero);
        this.episodio = episodio;
    }

    public String getEpisodio() {
        return episodio;
    }

    public void setEpisodio(String episodio) {
        this.episodio = episodio;
    }

    @Override
    public String toString() {
        return super.toString() + " [Episódio: " + episodio + "]";
    }
}
