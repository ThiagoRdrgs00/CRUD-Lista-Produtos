package br.com.senai;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static int opcaoMenu = 0;
    static int codigo = 0;
    public static boolean programaAtivo = true;
    public static void main(String[] args) {
        while (programaAtivo) {
            MenuDescritivo();
            switch (opcaoMenu) {
                case 1:
                    Funcoes.cadastrarProduto();
                    break;
                case 2:
                    Funcoes.listarProdutos(0);
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
                    Funcoes.listarProdutos(codigo);
                    break;
                case 0:
                    Funcoes.finalizarSistema();
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
            }
        }
        System.out.println("Sistema finalizado!");
    }
    public static void MenuDescritivo() {
        System.out.print("""
                =============== Menu =============
                   1 - Cadastrar produtos
                   2 - Listar produtos
                   3 - Editar produtos
                   4 - Remover produtos
                   5 - Buscar produto por id
                   0 - Finalizar o sistema
                ==================================
                Qual opção deseja acessar:
                """);
        opcaoMenu = input.nextInt();
    }
}
