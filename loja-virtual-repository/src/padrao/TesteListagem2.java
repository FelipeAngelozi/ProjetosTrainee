package padrao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteListagem2 {
    public static void main(String[] args) throws SQLException {

        PreparedStatement preparedStatement = ConnectionFactory.obterConexao().prepareStatement("SELECT * FROM produto");

        preparedStatement.execute();


        ResultSet resultSet = preparedStatement.getResultSet();

        Produto produto = new Produto();

        while (resultSet.next()) {
            produto.setId(resultSet.getInt(1));
            produto.setNome(resultSet.getString(2));
            produto.setDescricao(resultSet.getString(3));
            System.out.println(produto);
        }

    }
}
