package Menu;

import Tudo.Catalogo;
import Tudo.Genero;
import Tudo.Midia;
import Exception.MediaNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MenuCatalogo {
    private Scanner scanner;
    private Catalogo catalogo;


    public MenuCatalogo(Scanner scanner, Catalogo catalogo) {
        this.scanner = scanner;
        this.catalogo = catalogo;
    }


    public void exibir() {
        while (true) {
            System.out.println("\n---- EXPLORAR CATÁLOGO ----");
            System.out.println("Total de mídias: " + catalogo.getTotalMidias());
            System.out.println("1. Buscar por título");
            System.out.println("2. Buscar por artista");
            System.out.println("3. Buscar por gênero");
            System.out.println("4. Listar todas as mídias");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> buscarPorTitulo();
                    case 2 -> buscarPorArtista();
                    case 3 -> buscarPorGenero();
                    case 4 -> listarTodasMidias();
                    case 5 -> { return; }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }


    private void buscarPorTitulo() {
        try {
            System.out.print("Título: ");
            String titulo = scanner.nextLine();
            Midia midia = catalogo.buscarPorTitulo(titulo);
            System.out.println("Encontrado: " + midia);
        } catch (MediaNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private void buscarPorArtista() {
        System.out.print("Artista: ");
        String artista = scanner.nextLine();
        List<Midia> midias = catalogo.buscarPorArtista(artista);

        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada para este artista");
        } else {
            midias.forEach(System.out::println);
        }
    }


    private void buscarPorGenero() {
        System.out.println("Gêneros disponíveis:");
        for (Genero genero : Genero.values()) {
            System.out.println("- " + genero);
        }

        System.out.print("Gênero: ");
        String generoStr = scanner.nextLine().toUpperCase();

        try {
            Genero genero = Genero.valueOf(generoStr);
            List<Midia> midias = catalogo.buscarPorGenero(genero);

            if (midias.isEmpty()) {
                System.out.println("Nenhuma mídia encontrada para este gênero");
            } else {
                midias.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Gênero inválido!");
        }
    }


    private void listarTodasMidias() {
        List<Midia> midias = catalogo.getTodasMidias();
        if (midias.isEmpty()) {
            System.out.println("Nenhuma mídia no catálogo");
        } else {
            midias.forEach(System.out::println);
        }
    }
}
