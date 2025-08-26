package Menu;

import Tudo.Usuario;
import Tudo.Catalogo;
import Tudo.Playlist;
import Tudo.Midia;
import Exception.PlaylistNotFoundException;
import Exception.MediaNotFoundException;
import Exception.DuplicateMediaException;
import java.util.Scanner;

public class MenuPlaylist {
    private Scanner scanner;
    private Usuario usuario;
    private Catalogo catalogo;


    public MenuPlaylist(Scanner scanner, Usuario usuario, Catalogo catalogo) {
        this.scanner = scanner;
        this.usuario = usuario;
        this.catalogo = catalogo;
    }


    public void exibir() {
        while (true) {
            System.out.println("\n---- GERENCIAR PLAYLISTS ----");
            System.out.println("1. Criar playlist");
            System.out.println("2. Adicionar música à playlist");
            System.out.println("3. Remover música da playlist");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> criarPlaylist();
                    case 2 -> adicionarMusicaPlaylist();
                    case 3 -> removerMusicaPlaylist();
                    case 4 -> { return; }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }


    private void criarPlaylist() {
        try {
            System.out.print("Nome da playlist: ");
            String nome = scanner.nextLine();
            usuario.criarPlaylist(nome);
            System.out.println("Playlist criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao criar playlist: " + e.getMessage());
        }
    }


    private void adicionarMusicaPlaylist() {
        try {
            System.out.print("Nome da playlist: ");
            String nomePlaylist = scanner.nextLine();
            Playlist playlist = usuario.getPlaylist(nomePlaylist);

            System.out.print("Título da mídia: ");
            String titulo = scanner.nextLine();
            Midia midia = catalogo.buscarPorTitulo(titulo);

            playlist.adicionarMedia(midia);
            System.out.println("Mídia adicionada à playlist!");
        } catch (PlaylistNotFoundException | MediaNotFoundException | DuplicateMediaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }


    private void removerMusicaPlaylist() {
        try {
            System.out.print("Nome da playlist: ");
            String nomePlaylist = scanner.nextLine();
            Playlist playlist = usuario.getPlaylist(nomePlaylist);

            System.out.print("Título da mídia: ");
            String titulo = scanner.nextLine();
            Midia midia = catalogo.buscarPorTitulo(titulo);

            playlist.removerMedia(midia);
            System.out.println("Mídia removida da playlist!");
        } catch (PlaylistNotFoundException | MediaNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
