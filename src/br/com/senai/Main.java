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
        System.out.println("================Menu==============");
        System.out.println("1 - Cadastrar produtos");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Editar produtos");
        System.out.println("4 - Remover produtos");
        System.out.println("5 - Buscar produto por id");
        System.out.println("0 - Finalizar o sistema");
        System.out.println("==================================");
        System.out.print("Qual opção deseja acessar: ");
        opcaoMenu = input.nextInt();
    }
}
