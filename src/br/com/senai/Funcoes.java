package br.com.senai;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcoes {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void criarMenu() {
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
        Main.opcaoMenu = input.nextInt();
    }

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
            input.nextLine();
            System.out.print("Informe o nome do produto: ");
            produtoNovo.nome = input.nextLine();
            System.out.print("Informe a quantidade: ");
            produtoNovo.quantidade = input.nextInt();
            System.out.print("Informe o valor unitário: ");
            produtoNovo.valorUnitario = input.nextDouble();

            produtos.add(produtoNovo);
            System.out.println("--- Produto cadastrado com sucesso ---\n");
        } else {
            System.out.print("""
            
            Não é possivel cadastrar este produto
            pois o mesmo já está cadastrado
            
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

    public static void listarProdutos() {
        int quantidadeTotal = 0;
        double valorTotal = 0;

        for (Produto produto : produtos) {
            System.out.println("--------------------------------------");
            System.out.println("Código: " + produto.codigo);
            System.out.println("Nome: " + produto.nome);
            System.out.println("Quantidade: " + produto.quantidade);
            System.out.println("Valor Unitário: " + produto.valorUnitario);
            System.out.println("Valor Total: " + calculaValorTotalProduto(produto.quantidade, produto.valorUnitario));
            if (!produtos.isEmpty()) {
                quantidadeTotal += produto.quantidade;
                valorTotal += calculaValorTotalProduto(produto.quantidade, produto.valorUnitario);
            }
        }
        if (!produtos.isEmpty()) {
            System.out.println("--------------------------------------");
            System.out.println("Quantidade Total de Produtos: " + quantidadeTotal);
            System.out.println("Valor Total dos Produtos: " + valorTotal + "\n");
        } else {
            System.out.println("--- Nenhum produto encontrado ---\n");
        }
    }

    public static void editarProduto(int codigo) {
        boolean bSeguir = verificaCodigoExiste(codigo);
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
                    System.out.println("--- Produto '" + produto.codigo + "' editado com sucesso ---\n");
                }
            }
        } else {
            System.out.println("---  O Produto não foi encontrado  ---\n");
        }
    }

    public static void excluirProduto(){
        int codigo = buscarProduto();
        boolean bSeguir = verificaCodigoExiste(codigo);
        if (bSeguir) {
            for (int i=0;i < produtos.size(); i++) {
                if (produtos.get(i).codigo == codigo) {
                    System.out.println("--- Produto '" + produtos.get(i).codigo + "' removido com sucesso ---\n");
                    produtos.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("---  O Produto não foi encontrado  ---\n");
        }
    }

    public static void listarProdutoID() {
        int codigo = buscarProduto();
        boolean bSeguir = verificaCodigoExiste(codigo);
        if (bSeguir) {
            for (Produto produto : produtos) {
                if (produto.codigo == codigo) {
                    System.out.println("--------------------------------------");
                    System.out.println("Código: " + produto.codigo);
                    System.out.println("Nome: " + produto.nome);
                    System.out.println("Quantidade: " + produto.quantidade);
                    System.out.println("Valor Unitário: " + produto.valorUnitario);
                    System.out.println("Valor Total: " + calculaValorTotalProduto(produto.quantidade, produto.valorUnitario) + "\n");
                    break;
                }
            }
        } else {
            System.out.println("---  O Produto não foi encontrado  ---\n");
        }
    }

    public static int buscarProduto () {
        int codigo;
        System.out.print("Informe o código do produto: ");
        codigo = input.nextInt();
        return codigo;
    }

    public static void buscarProdutoEdicao() {
        //Funçao usada para obter o código quando for editar o produto diretamente via menu
        int codigo = buscarProduto();
       editarProduto(codigo);
    }

    public static void finalizarSistema () {
        Main.programaAtivo = false;
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

    private static double calculaValorTotalProduto(int quantidade, double valor) {
        return quantidade * valor;
    }
}
