package Modelo;

import java.util.ArrayList;
import Exception.MediaNotFoundException;

public class Catalogo {
    private ArrayList<Midia> midias;

    public Catalogo() {
        this.midias = new ArrayList<>();
    }

    public void adicionarMidia(Midia media) {
        midias.add(media);
    }

    public ArrayList<Midia> buscarPorTitulo(String titulo) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia media : midias) {
            if (media.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultado.add(media);
            }
        }
        return resultado;
    }

    public ArrayList<Midia> buscarPorArtista(String artista) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia media : midias) {
            if (media.getArtista().toLowerCase().contains(artista.toLowerCase())) {
                resultado.add(media);
            }
        }
        return resultado;
    }

    public ArrayList<Midia> buscarPorGenero(Genero genero) {
        ArrayList<Midia> resultado = new ArrayList<>();
        for (Midia media : midias) {
            if (media.getGenero() == genero) {
                resultado.add(media);
            }
        }
        return resultado;
    }

    public Midia getMidia(String titulo, String artista) throws MediaNotFoundException {
        for (Midia media : midias) {
            if (media.getTitulo().equalsIgnoreCase(titulo) &&
                    media.getArtista().equalsIgnoreCase(artista)) {
                return media;
            }
        }
        throw new MediaNotFoundException("Mídia não encontrada: " + titulo + " - " + artista);
    }

    public void exibirTodasMidias() {
        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia no catálogo.");
            return;
        }

        System.out.println("Catálogo de Mídias:");
        for (int i = 0; i < midias.size(); i++) {
            Midia media = midias.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
    }
}
