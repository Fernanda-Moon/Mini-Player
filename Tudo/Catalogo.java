package Tudo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Exception.MediaNotFoundException;

public class Catalogo {
    private List<Midia> midias;


    public Catalogo() {
        this.midias = new ArrayList<>();
    }


    public void adicionarMedia(Midia midia) {
        midias.add(midia);
    }


    public Midia buscarPorTitulo(String titulo) throws MediaNotFoundException {
        return midias.stream()
                .filter(m -> m.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElseThrow(() -> new MediaNotFoundException("Mídia não encontrada: " + titulo));
    }


    public List<Midia> buscarPorArtista(String artista) {
        return midias.stream()
                .filter(m -> m.getArtista().equalsIgnoreCase(artista))
                .collect(Collectors.toList());
    }


    public List<Midia> buscarPorGenero(Genero genero) {
        return midias.stream()
                .filter(m -> m.getGenero() == genero)
                .collect(Collectors.toList());
    }


    public List<Midia> getTodasMidias() {
        return new ArrayList<>(midias);
    }


    public int getTotalMidias() {
        return midias.size();
    }
}
