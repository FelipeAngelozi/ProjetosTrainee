package padrao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoParametro2 {
    public static void main(String[] args) throws SQLException {

        try (PreparedStatement preparedStatement = ConnectionFactory.obterConexao().prepareStatement("INSERT INTO produto (nome, descricao) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.getConnection().setAutoCommit(false);
            preparedStatement.setString(1, "Mascara");
            preparedStatement.setString(2, "Preta");
            preparedStatement.execute();
            preparedStatement.getConnection().commit();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                Produto produto = new Produto();

                while (resultSet.next()) {
                    produto.setId(resultSet.getInt(1));
                    produto.setNome(resultSet.getString(2));
                    produto.setDescricao(resultSet.getString(3));
                    System.out.println(produto);
                }
            }
        }
    }
}
