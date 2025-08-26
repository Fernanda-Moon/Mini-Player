package Menu;

import Tudo.Usuario;
import Tudo.Catalogo;
import Exception.UserNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private List<Usuario> usuarios;
    private Catalogo catalogo;
    private Usuario usuarioLogado;


    public MenuPrincipal(Scanner scanner, List<Usuario> usuarios, Catalogo catalogo) {
        this.scanner = scanner;
        this.usuarios = usuarios;
        this.catalogo = catalogo;
        this.usuarioLogado = null;
    }


    public void exibir() {
        while (true) {
            System.out.println("\n=== MINI SPOTIFY ===");
            System.out.println("1. Login");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> fazerLogin();
                    case 2 -> cadastrarUsuario();
                    case 3 -> {
                        System.out.println("Saindo...");
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


    private void fazerLogin() {
        try {
            System.out.print("Email: ");
            String email = scanner.nextLine();

            Usuario usuario = usuarios.stream()
                    .filter(u -> u.getEmail().equalsIgnoreCase(email))
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

            usuarioLogado = usuario;

            MenuUsuario menuUsuario = new MenuUsuario(scanner, usuarioLogado, catalogo);
            menuUsuario.exibir();

        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private void cadastrarUsuario() {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            if (usuarios.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email))) {
                System.out.println("Email já cadastrado!");
                return;
            }

            Usuario novoUsuario = new Usuario(nome, email);
            usuarios.add(novoUsuario);
            usuarioLogado = novoUsuario;
            System.out.println("Usuário cadastrado com sucesso!");

            MenuUsuario menuUsuario = new MenuUsuario(scanner, usuarioLogado, catalogo);
            menuUsuario.exibir();

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
