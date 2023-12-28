package controller;

import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ProdutoDAO {
    Connection conn;

    public ProdutoDAO() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }

    public void update() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o id do produto que você deseja atualizar?: ");
        String id = sc.nextLine();

        System.out.print("Você deseja atualizar o nome do produto? responda com Sim ou Não: ");
        String escolha1 = sc.nextLine();
        if (escolha1.equalsIgnoreCase("Sim")) {
            System.out.print("Digite o novo nome: ");
            String novoNome = sc.nextLine();
            String sql = "UPDATE Produto SET nome = ? Where ID = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, novoNome);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();

        }
        System.out.print("Você deseja atualizar a descrição do produto? responda com Sim ou Não: ");
        String escolha2 = sc.nextLine();
        if (escolha2.equalsIgnoreCase("Sim")) {
            System.out.print("Digite uma nova descrição: ");
            String novaDescricao = sc.nextLine();
            String sql = "UPDATE Produto SET descricao = ? Where ID = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, novaDescricao);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        }
        System.out.print("Você deseja atualizar a categoria do produto? responda com Sim ou Não: ");
        String escolha3 = sc.nextLine();
        if (escolha3.equalsIgnoreCase("Sim")) {
            System.out.print("Digite uma nova Categoria: ");
            String novaCategoria = sc.nextLine();
            String sql = "UPDATE Produto SET categoria = ? Where ID = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, novaCategoria);
            preparedStatement.setString(2, id);
            preparedStatement.executeUpdate();
        }
    }

    public Produto getOne(int id) throws SQLException {

        String sql = "SELECT * FROM Produto WHERE Id = ?;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Produto produto = new Produto();
        produto.setId(resultSet.getInt("Id"));
        produto.setNome(resultSet.getString("Nome"));
        produto.setDescricao(resultSet.getString("Descricao"));
        produto.setCategoria(resultSet.getString("Categoria"));

        return produto;
    }

    public void insert() throws SQLException {
        String sql = "INSERT INTO Produto VALUES(null, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o nome do produto:");
        String nome = sc.nextLine();
        System.out.print("Informe a descrição do produto:");
        String descricao = sc.nextLine();
        System.out.print("Informe a categoria do produto:");
        String categoria = sc.nextLine();

        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.setString(3, categoria);
        preparedStatement.executeUpdate();
    }

    public ArrayList<Produto> getAll() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("Id"));
            produto.setNome(resultSet.getString("Nome"));
            produto.setDescricao(resultSet.getString("Descricao"));
            produto.setCategoria(resultSet.getString("Categoria"));

            produtos.add(produto);
        }
        return produtos;
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM Produto WHERE Id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do produto que vai ser deletado: ");
        String id = sc.nextLine();

        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();

    }


}
