package Tudo;

import java.util.ArrayList;
import java.util.List;
import Exception.DuplicateMediaException;

public class Playlist {
    private String nome;
    private Usuario proprietario;
    private List<Midia> midias;


    public Playlist(String nome, Usuario proprietario) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.midias = new ArrayList<>();
    }


    public void adicionarMedia(Midia midia) throws DuplicateMediaException {
        if (midias.contains(midia)) {
            throw new DuplicateMediaException("Mídia já existe na playlist: " + midia.getTitulo());
        }
        midias.add(midia);
    }


    public void removerMedia(Midia midia) {
        midias.remove(midia);
    }


    public int getDuracaoTotal() {
        return midias.stream().mapToInt(Midia::getDuracao).sum();
    }


    public String getNome() {
        return nome;
    }


    public Usuario getProprietario() {
        return proprietario;
    }


    public List<Midia> getMidias() {
        return new ArrayList<>(midias);
    }


    @Override
    public String toString() {
        return String.format("Playlist: %s (%d mídias, %d segundos)",
                nome, midias.size(), getDuracaoTotal());
    }
}
