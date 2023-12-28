package org.example;

import controller.FornecedorDAO;
import controller.ProdutoDAO;
import model.Fornecedor;
import model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        int escolha;
        // 1. Cadastrar
        // 2. Buscar
        // 3. Atualizar um produto
        // 4. Deletar um produto
        // 0. Sair


        do {
            System.out.println("Bem vindo ao menu CRUD, escolha uma opção");
            System.out.print(" [1] Cadastrar\n [2] Buscar\n [3] Atualizar\n [4] Deletar\n [0] Sair: ");
            escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.println("O que você deseja cadastrar?\n [1] Produto\n [2] Fornecedor\n [0] Sair");
                int escolhaAserCadastrado = sc.nextInt();
                if (escolhaAserCadastrado == 1) {
                    produtoDAO.insert();
                    System.out.println("Produto cadastrado com sucesso!");
                } else if (escolhaAserCadastrado == 2) {
                    fornecedorDAO.insert();
                }

            } else if (escolha == 2) {
                System.out.println("O que você deseja buscar?: \n [1] Produto\n [2] Fornecedor\n [3] Estoque");
                int escolhaTabela = sc.nextInt();
                if (escolhaTabela == 1) {
                    System.out.println("Escolha uma opção: \n [1] Buscar todos os Produtos\n [2] Buscar um produto\n [0] Sair");
                    int escolhaProduto = sc.nextInt();
                    if (escolhaProduto == 1) {
                        produtos = produtoDAO.getAll();
                        for (Produto produto : produtos) {
                            System.out.println(produto);
                        }
                    } else if (escolhaProduto == 2) {
                        System.out.println("digite o id do Produto que voce deseja buscar ou 0 para sair");
                        int id = sc.nextInt();
                        System.out.println(produtoDAO.getOne(id));
                    }
                } else if(escolhaTabela == 2 ){
                    System.out.println("Escolha uma opção: \n [1] Buscar todos os Fornecedores\n [2] Buscar um Fornecedor\n [0] Sair");
                    int escolhaFornecedor = sc.nextInt();
                    if (escolhaFornecedor == 1) {
                        fornecedores = fornecedorDAO.getAll();
                        for (Fornecedor fornecedor : fornecedores) {
                            System.out.println(fornecedor);
                        }
                    } else if (escolhaFornecedor == 2) {
                        System.out.println("digite o id do Fornecedor que voce deseja buscar ou 0 para sair");
                        int id = sc.nextInt();
                        System.out.println(fornecedorDAO.getOne(id));
                    }
                }
            } else if (escolha == 3) {
                System.out.println("O que você deseja atualizar?\n [1] Produto\n [2] Fornecedor\n [3] Sair");
                int escolhaASerAtualizado = sc.nextInt();
                if(escolhaASerAtualizado == 1) {
                produtoDAO.update();
                System.out.println("Produto atualizado com sucesso!\n");
                } else if(escolhaASerAtualizado == 2) {
                    fornecedorDAO.update();
                System.out.println("Fornecedor atualizado com sucesso!\n");
                }

            } else if (escolha == 4) {
                System.out.println("O que você deseja Deletar?\n [1] Produto\n [2] Fornecedor\n [3] Sair");
                int escolhaASerDeletado = sc.nextInt();
                if(escolhaASerDeletado == 1) {
                produtoDAO.delete();
                System.out.println("Produto deletado com sucesso!\n");
                } else if(escolhaASerDeletado == 2) {
                    fornecedorDAO.delete();
                System.out.println("Fornecedor deletado com sucesso!\n");

                }
            }



          /*  switch (escolha) {
                case 1:
                    produtoDAO.insert();
                    break;
                case 2:
                    produtoDAO.getAll();
                    break;
                case 3:
                    produtoDAO.update();
                    break;
                case 4:
                    produtoDAO.delete();
                    break;
            }
*/


        } while (escolha != 0);


        // produtoDAO.insert();

        //produtos = produtoDAO.getAll();
        //produtoDAO.update();
        //System.out.println(produtoDAO.getOne(10));
        //  produtoDAO.delete();


        // forEach
    }
}