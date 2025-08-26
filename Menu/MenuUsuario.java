package Menu;

import Tudo.Usuario;
import Tudo.Catalogo;
import java.util.Scanner;

public class MenuUsuario {
    private Scanner scanner;
    private Usuario usuario;
    private Catalogo catalogo;


    public MenuUsuario(Scanner scanner, Usuario usuario, Catalogo catalogo) {
        this.scanner = scanner;
        this.usuario = usuario;
        this.catalogo = catalogo;
    }


    public void exibir() {
        while (true) {
            System.out.println("\n---- MENU DO USUÁRIO ----");
            System.out.println("Usuário: " + usuario.getNome());
            System.out.println("1. Gerenciar playlists");
            System.out.println("2. Explorar catálogo");
            System.out.println("3. Ver minhas playlists");
            System.out.println("4. Logout");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> gerenciarPlaylists();
                    case 2 -> explorarCatalogo();
                    case 3 -> verPlaylists();
                    case 4 -> {
                        System.out.println("Logout realizado!");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }


    private void gerenciarPlaylists() {
        MenuPlaylist menuPlaylist = new MenuPlaylist(scanner, usuario, catalogo);
        menuPlaylist.exibir();
    }


    private void explorarCatalogo() {
        MenuCatalogo menuCatalogo = new MenuCatalogo(scanner, catalogo);
        menuCatalogo.exibir();
    }


    private void verPlaylists() {
        var playlists = usuario.getPlaylists();

        if (playlists.isEmpty()) {
            System.out.println("Nenhuma playlist encontrada");
            return;
        }

        System.out.println("\n~~~~ SUAS PLAYLISTS ~~~~");
        for (int i = 0; i < playlists.size(); i++) {
            var playlist = playlists.get(i);
            System.out.printf("%d. %s\n", i + 1, playlist);

            var midias = playlist.getMidias();
            if (!midias.isEmpty()) {
                System.out.println("   Mídias:");
                for (var media : midias) {
                    System.out.println("   - " + media);
                }
            }
            System.out.println();
        }
    }
}
