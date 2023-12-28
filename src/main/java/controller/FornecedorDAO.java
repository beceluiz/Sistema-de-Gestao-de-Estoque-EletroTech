package controller;

import model.Fornecedor;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FornecedorDAO {
    Connection conn;

    public FornecedorDAO() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }
    public void insert() throws SQLException {
        String sql = "INSERT INTO Fornecedor VALUES(null, ?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o nome do Fornecedor:");
        String nome = sc.nextLine();
        System.out.print("Informe o CNPJ/CPF do Fornecedor:");
        String cpfCnpj = sc.nextLine();
        System.out.print("Informe a Razão Social do Fornecedor:");
        String razaoSocial = sc.nextLine();

        preparedStatement.setString(1,nome);
        preparedStatement.setString(2,cpfCnpj);
        preparedStatement.setString(3,razaoSocial);
        preparedStatement.executeUpdate();
    }

    public void update () throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o id do Fornecedor que você deseja atualizar?: ");
        String id = sc.nextLine();

        System.out.print("Você deseja atualizar o nome do Fornecedor? responda com Sim ou Não: ");
        String escolha1 = sc.nextLine();
        if(escolha1.equalsIgnoreCase("Sim")) {
            System.out.print("Digite o novo nome: ");
            String novoNome = sc.nextLine();
            String sql = "UPDATE Fornecedor SET nome = ? Where ID = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,novoNome);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();

        }
        System.out.print("Você deseja atualizar o CNPJ/CPF do Fornecedor? responda com Sim ou Não: ");
        String escolha2 = sc.nextLine();
        if(escolha2.equalsIgnoreCase("Sim")) {
            System.out.print("Digite o novo CPF/CNPJ: ");
            String novoCpnjCpf = sc.nextLine();
            String sql = "UPDATE Fornecedor SET CNPJ_CPF = ? Where ID = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,novoCpnjCpf);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
        }
        System.out.print("Você deseja atualizar a Razão social do produto? responda com Sim ou Não: ");
        String escolha3 = sc.nextLine();
        if(escolha3.equalsIgnoreCase("Sim")) {
            System.out.print("Digite uma nova Razão Social: ");
            String novaRazaoSocial = sc.nextLine();
            String sql = "UPDATE Fornecedor SET Razao_Social = ? Where ID = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1,novaRazaoSocial);
            preparedStatement.setString(2,id);
            preparedStatement.executeUpdate();
        }
    }

    public Fornecedor getOne(int id) throws SQLException {

        String sql = "SELECT * FROM Fornecedor WHERE Id = ?;";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(resultSet.getInt("Id"));
        fornecedor.setNome(resultSet.getString("Nome"));
        fornecedor.setCnpjCpf(resultSet.getString("CNPJ_CPF"));
        fornecedor.setRazaoSocial(resultSet.getString("Razao_Social"));

        return fornecedor;
    }

    public ArrayList<Fornecedor> getAll() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM Fornecedor";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {



            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(resultSet.getInt("Id"));
            fornecedor.setNome(resultSet.getString("Nome"));
            fornecedor.setCnpjCpf(resultSet.getString("CNPJ_CPF"));
            fornecedor.setRazaoSocial(resultSet.getString("Razao_Social"));

            fornecedores.add(fornecedor);
        }
        return fornecedores;
    }

    public void delete() throws SQLException {
        String sql = "DELETE FROM Fornecedor WHERE Id = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do Fornecedor que vai ser deletado: ");
        String id = sc.nextLine();

        preparedStatement.setString(1,id);
        preparedStatement.executeUpdate();

    }

}
