package Modelo;

import java.util.ArrayList;
import Exception.PlaylistNotFoundException;

public class Usuario {
    private String nome;
    private String email;
    private ArrayList<Playlist> playlists;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void criarPlaylist(String nome) {
        Playlist playlist = new Playlist(nome, this);
        playlists.add(playlist);
    }

    public Playlist getPlaylist(String nome) throws PlaylistNotFoundException {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nome)) {
                return playlist;
            }
        }
        throw new PlaylistNotFoundException("Playlist não encontrada: " + nome);
    }

    public void removerPlaylist(String nome) throws PlaylistNotFoundException {
        Playlist playlist = getPlaylist(nome);
        playlists.remove(playlist);
    }

    public void visualizarPlaylists() {
        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist encontrada.");
            return;
        }

        System.out.println("Playlists de " + nome + ":");
        for (int i = 0; i < playlists.size(); i++) {
            Playlist playlist = playlists.get(i);
            System.out.println((i + 1) + ". " + playlist.getNome() +
                    " (" + playlist.getQuantidadeMidias() + " mídias, " +
                    playlist.getDuracaoTotalFormatada() + ")");
        }
    }
}
