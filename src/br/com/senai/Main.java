package br.com.senai;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int opcaoMenu;
    static int codigo;
    public static boolean programaAtivo = true;

    public static void main(String[] args) {
        while (programaAtivo) {
            MenuDescritivo();
            switch (opcaoMenu) {
                case 1:
                    Funcoes.cadastrarProduto();
                    break;
                case 2:
                    Funcoes.listarProdutos();
                    break;
                case 3:
                    codigo = Funcoes.buscarProduto();
                    Funcoes.editarProduto(codigo);
                    break;
                case 4:
                    codigo = Funcoes.buscarProduto();
                    Funcoes.excluirProduto(codigo);
                    break;
                case 5:
                    codigo = Funcoes.buscarProduto();
                    Funcoes.listarProdutoID(codigo);
                    break;
                case 0:
                    Funcoes.finalizarSistema();
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
            }
        }
        System.out.println("\nFinalizando Sistema!");
    }

    public static void MenuDescritivo() {
        System.out.print("""
                ================ Menu ================
                       1 - Cadastrar produto
                       2 - Listar produtos
                       3 - Editar produto
                       4 - Remover produto
                       5 - Buscar produto por código
                       0 - Finalizar o sistema
                ======================================
                """);
        System.out.print("Qual opção deseja acessar: ");
        opcaoMenu = input.nextInt();
    }
}