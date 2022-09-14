package padrao;

import java.sql.*;

public class TestaListagem {
    public static void main(String[] args) throws SQLException {

        Statement statement = ConnectionFactory.obterConexao().createStatement();
        statement.execute("SELECT * FROM produto");

        ResultSet resultSet = statement.getResultSet();


        Produto produto = new Produto();

        while (resultSet.next()) {
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setDescricao(resultSet.getString("descricao"));
            System.out.println(produto);
        }

        statement.getConnection().close();
    }
}
