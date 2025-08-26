package Modelo;

import Exception.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Catalogo catalogo = new Catalogo();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioLogado = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDados();
        exibirMenuPrincipal();
    }

    private static void inicializarDados() {
        catalogo.adicionarMidia(new Musica("Bohemian Rhapsody", "Queen", 355, Genero.ROCK, "A Night at the Opera"));
        catalogo.adicionarMidia(new Musica("BTBT", "B.I e Soulja Boy", 183, Genero.POP, "DeVita"));
        catalogo.adicionarMidia(new Musica("Apesar de você", "Chico Buarque", 145, Genero.MPB, "Getz/Gilberto"));
        catalogo.adicionarMidia(new Podcast("Java com café", "TechTalk", 1800, Genero.PODCAST, "Episódio 23"));
        catalogo.adicionarMidia(new Audiobook("Príncipe Cruel", "Holly Black", 14400, Genero.AUDIOBOOK, "Holly Black"));

        Usuario usuario = new Usuario("Fernanda Travassos", "fernandalua@gmail.com");
        usuarios.add(usuario);
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== MINI SPOTIFY ===");
            System.out.println("1. Fazer Login");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Visualizar Catálogo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    catalogo.exibirTodasMidias();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void fazerLogin() {
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        try {
            usuarioLogado = buscarUsuarioPorEmail(email);
            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuarioLogado.getNome());
            exibirMenuUsuario();
        } catch (UserNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static Usuario buscarUsuarioPorEmail(String email) throws UserNotFoundException {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        throw new UserNotFoundException("Usuário não encontrado com o e-mail: " + email);
    }

    private static void cadastrarUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void exibirMenuUsuario() {
        int opcao;
        do {
            System.out.println("\n=== MENU DO USUÁRIO ===");
            System.out.println("1. Gerenciar Playlists");
            System.out.println("2. Visualizar Catálogo");
            System.out.println("3. Buscar Mídias");
            System.out.println("0. Logout");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    gerenciarPlaylists();
                    break;
                case 2:
                    catalogo.exibirTodasMidias();
                    break;
                case 3:
                    buscarMidias();
                    break;
                case 0:
                    usuarioLogado = null;
                    System.out.println("Logout realizado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0 && usuarioLogado != null);
    }

    private static void gerenciarPlaylists() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR PLAYLISTS ===");
            System.out.println("1. Criar Playlist");
            System.out.println("2. Visualizar Playlists");
            System.out.println("3. Gerenciar Mídias em uma Playlist");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    criarPlaylist();
                    break;
                case 2:
                    usuarioLogado.visualizarPlaylists();
                    break;
                case 3:
                    gerenciarMidiasPlaylist();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void criarPlaylist() {
        System.out.print("Digite o nome da nova playlist: ");
        String nome = scanner.nextLine();

        usuarioLogado.criarPlaylist(nome);
        System.out.println("Playlist criada com sucesso!");
    }

    private static void gerenciarMidiasPlaylist() {
        try {
            usuarioLogado.visualizarPlaylists();
            if (usuarioLogado.getPlaylists().isEmpty()) {
                return;
            }

            System.out.print("Digite o nome da playlist que deseja gerenciar: ");
            String nomePlaylist = scanner.nextLine();

            Playlist playlist = usuarioLogado.getPlaylist(nomePlaylist);

            int opcao;
            do {
                System.out.println("\n=== GERENCIANDO PLAYLIST: " + playlist.getNome() + " ===");
                System.out.println("1. Adicionar Mídia");
                System.out.println("2. Remover Mídia");
                System.out.println("3. Visualizar Mídias");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");

                try {
                    opcao = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Opção inválida! Digite um número.");
                    opcao = -1;
                    continue;
                }

                switch (opcao) {
                    case 1:
                        adicionarMidiaPlaylist(playlist);
                        break;
                    case 2:
                        removerMidiaPlaylist(playlist);
                        break;
                    case 3:
                        playlist.visualizarMidias();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);

        } catch (PlaylistNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void adicionarMidiaPlaylist(Playlist playlist) {
        catalogo.exibirTodasMidias();
        if (catalogo.buscarPorTitulo("").isEmpty()) {
            return;
        }

        System.out.print("Digite o título da mídia que deseja adicionar: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o artista da mídia: ");
        String artista = scanner.nextLine();

        try {
            Midia media = catalogo.getMidia(titulo, artista);
            playlist.adicionarMidia(media);
            System.out.println("Mídia adicionada com sucesso!");
        } catch (MediaNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void removerMidiaPlaylist(Playlist playlist) {
        playlist.visualizarMidias();
        if (playlist.getMidias().isEmpty()) {
            return;
        }

        System.out.print("Digite o número da mídia que deseja remover: ");
        try {
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            if (indice >= 0 && indice < playlist.getMidias().size()) {
                Midia media = playlist.getMidias().get(indice);
                playlist.removerMidia(media);
                System.out.println("Mídia removida com sucesso!");
            } else {
                System.out.println("Número inválido!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido!");
        }
    }

    private static void buscarMidias() {
        int opcao;
        do {
            System.out.println("\n=== BUSCAR MÍDIAS ===");
            System.out.println("1. Buscar por Título");
            System.out.println("2. Buscar por Artista");
            System.out.println("3. Buscar por Gênero");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
                continue;
            }

            ArrayList<Midia> resultado = new ArrayList<>();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título para buscar: ");
                    String titulo = scanner.nextLine();
                    resultado = catalogo.buscarPorTitulo(titulo);
                    break;
                case 2:
                    System.out.print("Digite o artista para buscar: ");
                    String artista = scanner.nextLine();
                    resultado = catalogo.buscarPorArtista(artista);
                    break;
                case 3:
                    System.out.println("Gêneros disponíveis:");
                    for (Genero genero : Genero.values()) {
                        System.out.println("- " + genero);
                    }
                    System.out.print("Digite o gênero para buscar: ");
                    String generoStr = scanner.nextLine().toUpperCase();
                    try {
                        Genero genero = Genero.valueOf(generoStr);
                        resultado = catalogo.buscarPorGenero(genero);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gênero inválido!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (!resultado.isEmpty()) {
                System.out.println("Resultados da busca:");
                for (int i = 0; i < resultado.size(); i++) {
                    System.out.println((i + 1) + ". " + resultado.get(i).toString());
                }
            } else if (opcao != 0) {
                System.out.println("Nenhum resultado encontrado.");
            }

        } while (opcao != 0);
    }
}