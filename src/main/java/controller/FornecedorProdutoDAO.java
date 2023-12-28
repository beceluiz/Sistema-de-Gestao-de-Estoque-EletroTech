package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FornecedorProdutoDAO {
    Connection conn;

    public FornecedorProdutoDAO() throws SQLException {
        this.conn = ConexaoSQLite.getConexao();
    }
     /* public void insert() throws SQLException {
         String sql = "INSERT INTO Fornecedor_Produto VALUES(null, ?, ?)";
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
*/

}
