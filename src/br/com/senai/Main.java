package br.com.senai;

public class Main {
    static int opcaoMenu;
    public static boolean programaAtivo = true;

    public static void main(String[] args) {
        while (programaAtivo) {
            Funcoes.criarMenu();
            switch (opcaoMenu) {
                case 1:
                    Funcoes.cadastrarProduto();
                    break;
                case 2:
                    Funcoes.listarProdutos();
                    break;
                case 3:
                    Funcoes.buscarProdutoEdicao();
                    break;
                case 4:
                    Funcoes.excluirProduto();
                    break;
                case 5:
                    Funcoes.listarProdutoID();
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
}