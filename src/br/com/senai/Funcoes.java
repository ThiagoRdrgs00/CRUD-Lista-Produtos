package br.com.senai;

import java.util.ArrayList;
import java.util.Scanner;
public class Funcoes {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void cadastrarProduto() {
        Produto produtoNovo = new Produto();
        int novoProduto;
        boolean bSeguir;
        int opcaoEditar;

        System.out.print("Informe o código do produto: ");
        novoProduto = input.nextInt();
        bSeguir = verificaCodigoExiste(novoProduto);

        if (!bSeguir) {
            produtoNovo.codigo = novoProduto;
            System.out.print("Informe o nome do produto: ");
            input.nextLine();
            produtoNovo.nome = input.nextLine();
            System.out.print("Informe a quantidade: ");
            produtoNovo.quantidade = input.nextInt();
            System.out.print("Informe o valor unitário: ");
            produtoNovo.valorUnitario = input.nextDouble();

            produtos.add(produtoNovo);
            System.out.println("--- Produto cadastrado com sucesso ---");
        } else {
            System.out.print("""
            Não é possivel cadastrar este produto pois o mesmo já está cadastrado.
            
            Deseja editar o produto?
            1 - Sim.
            2 - Não.
            """);
            opcaoEditar = input.nextInt();
            if (opcaoEditar == 1) {
                editarProduto(novoProduto);
            }
        }
    }
    public static void listarProdutos(int codigo) {
        int quantidadeTotal = 0;
        double valorTotal = 0;

        for (Produto produto : produtos) {
            if (produto.codigo == codigo || codigo == 0) {
                System.out.println("--------------------------------------");
                System.out.println("Código: " + produto.codigo);
                System.out.println("Nome: " + produto.nome);
                System.out.println("Quantidade: " + produto.quantidade);
                System.out.println("Valor Unitário: " + produto.valorUnitario);
                System.out.println("Valor Total: " + (produto.quantidade * produto.valorUnitario));

                quantidadeTotal += produto.quantidade;
                valorTotal += produto.quantidade * produto.valorUnitario;
            }
        }
        if (codigo == 0) {
            System.out.println("--------------------------------------");
            System.out.println("Quantidade Total de Produtos: " + quantidadeTotal);
            System.out.println("Valor Total dos Produtos: " + valorTotal);
        }
    }
    public static void excluirProduto(int codigo){
        for (Produto produto : produtos) {
            if (produto.codigo == codigo) {
                produtos.remove(produto);
            }
        }
    }
    public static void editarProduto(int codigo) {
        boolean bSeguir;
        bSeguir = verificaCodigoExiste(codigo);
        if (bSeguir) {
            for (Produto produto : produtos) {
                if (produto.codigo == codigo) {
                    System.out.print("Informe o novo nome do produto: ");
                    input.nextLine();
                    produto.nome = input.nextLine();
                    System.out.print("Informe a nova quantidade: ");
                    produto.quantidade = input.nextInt();
                    System.out.print("Informe o novo valor unitário: ");
                    produto.valorUnitario = input.nextDouble();
                }
            }
        } else {
            System.out.println("O Produto informado não foi encontrado.");
        }

    }
    public static int buscarProduto () {
        int codigo;
        System.out.print("Informe o código do produto (Código 0 = Todos os produtos): ");
        codigo = input.nextInt();
        return codigo;
    }
    private static boolean verificaCodigoExiste(int codigo) {
        boolean codigoExiste = false;
        for (Produto produto : produtos) {
            if (produto.codigo == codigo) {
                codigoExiste = true;
                break;
            }
        }
        return codigoExiste;
    }
    public static void finalizarSistema () {
        Main.programaAtivo = false;
    }
}
