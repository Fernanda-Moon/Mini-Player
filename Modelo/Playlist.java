package Modelo;

import java.util.ArrayList;

public class Playlist {
    private String nome;
    private Usuario proprietario;
    private ArrayList<Midia> midias;

    public Playlist(String nome, Usuario proprietario) {
        this.nome = nome;
        this.proprietario = proprietario;
        this.midias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public ArrayList<Midia> getMidias() {
        return midias;
    }

    public int getQuantidadeMidias() {
        return midias.size();
    }

    public void adicionarMidia(Midia media) {
        midias.add(media);
    }

    public void removerMidia(Midia media) {
        midias.remove(media);
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Midia media : midias) {
            total += media.getDuracao();
        }
        return total;
    }

    public String getDuracaoTotalFormatada() {
        int totalSegundos = getDuracaoTotal();
        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segundos = totalSegundos % 60;

        if (horas > 0) {
            return String.format("%d:%02d:%02d", horas, minutos, segundos);
        } else {
            return String.format("%d:%02d", minutos, segundos);
        }
    }

    public void visualizarMidias() {
        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada na playlist " + nome);
            return;
        }

        System.out.println("Mídias na playlist " + nome + ":");
        for (int i = 0; i < midias.size(); i++) {
            Midia media = midias.get(i);
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("Duração total: " + getDuracaoTotalFormatada());
    }
}
