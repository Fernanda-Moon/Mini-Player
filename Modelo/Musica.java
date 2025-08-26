package Modelo;

public class Musica extends Midia {
    private String album;

    public Musica(String titulo, String artista, int duracao, Genero genero, String album) {
        super(titulo, artista, duracao, genero);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return super.toString() + " [Álbum: " + album + "]";
    }
}
