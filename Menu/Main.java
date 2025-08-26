package Menu;

import Tudo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        Catalogo catalogo = new Catalogo();

        inicializarDados(usuarios, catalogo);

        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner, usuarios, catalogo);
        menuPrincipal.exibir();

        scanner.close();
    }

    private static void inicializarDados(List<Usuario> usuarios, Catalogo catalogo) {

        try {
            catalogo.adicionarMedia(new Musica("Bohemian Rhapsody", "Queen", 355, Genero.ROCK));
            catalogo.adicionarMedia(new Musica("BTBT", "B.I e Soulja Boy", 400, Genero.POP));
            catalogo.adicionarMedia(new Musica("Apesar de você", "Chico Buarque", 145, Genero.MPB));
            catalogo.adicionarMedia(new Podcast("Java com Café", "Tech Podcast", 1800));
            catalogo.adicionarMedia(new Audiobook("Príncipe Cruel", "Holly Black", 14400));

            Usuario usuario = new Usuario("Fernanda Travassos", "fernandalua@gmail.com");
            usuarios.add(usuario);

            usuario.criarPlaylist("Diversão");
            var playlist = usuario.getPlaylist("Playlist agitada! >:D");
            playlist.adicionarMedia(catalogo.buscarPorTitulo("BTBT"));

        } catch (Exception e) {
            System.out.println("Erro ao inicializar dados: " + e.getMessage());
        }
    }
}
