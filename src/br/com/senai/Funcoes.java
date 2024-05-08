package br.com.senai;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void cadastrarProduto() {
        Produto produto = new Produto();

        //valida para verificar se já não existe
        //buscarproduto();


        System.out.print("Informe o código do produto: ");
        produto.codigo = input.nextInt();
        System.out.print("Informe o nome do produto:");
        input.nextLine();
        produto.nome = input.nextLine();
        System.out.print("Informe a quantidade: ");
        produto.quantidade = input.nextInt();
        System.out.print("Informe o valor unitário: ");
        produto.precoUnitario = input.nextDouble();

        produtos.add(produto);
    }

    public static void listarProdutos(int codigo) {
        for (Produto produto : produtos) {
            if (produto.codigo == codigo || codigo == 0) {
                System.out.println("-------------------------");
                System.out.println("Código: " + produto.codigo);
                System.out.println("Nome: " + produto.nome);
                System.out.println("-------------------------");
            }
        }
    }
    public static void excluirProduto(int codigo){
        for (Produto produto : produtos) {
            if (produto.codigo == codigo) {
                produtos.remove(produto);
            }
        }
    }
    public static int buscarProduto() {
        int codigo = 0;
        System.out.print("Informe o código do produto: ");
        codigo = input.nextInt();
        return codigo;
    }

    public static void finalizarSistema() {
        Main.programaAtivo = false;
    }

}
