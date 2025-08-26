package Tudo;

import java.util.ArrayList;
import java.util.List;
import Exception.PlaylistNotFoundException;

public class Usuario {
    private String nome;
    private String email;
    private List<Playlist> playlists;


    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.playlists = new ArrayList<>();
    }


    public void criarPlaylist(String nome) {
        Playlist playlist = new Playlist(nome, this);
        playlists.add(playlist);
    }


    public Playlist getPlaylist(String nome) throws PlaylistNotFoundException {
        return playlists.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElseThrow(() -> new PlaylistNotFoundException("Playlist não encontrada: " + nome));
    }


    public void removerPlaylist(String nome) throws PlaylistNotFoundException {
        Playlist playlist = getPlaylist(nome);
        playlists.remove(playlist);
    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public List<Playlist> getPlaylists() {
        return new ArrayList<>(playlists);
    }


    @Override
    public String toString() {
        return String.format("Usuário: %s (%s) - %d playlists", nome, email, playlists.size());
    }
}
