package padrao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoParametro {

    public static void main(String[] args) throws SQLException {

        String nome = "Goiaba;";
        String descricao = "verde);21'";

        PreparedStatement preparedStatement = ConnectionFactory.obterConexao().prepareStatement("INSERT INTO produto (nome , descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

          preparedStatement.setString(1, nome);
        preparedStatement.setString(2, descricao);
        preparedStatement.execute();


        ResultSet resultSet = preparedStatement.getGeneratedKeys();


        Produto produto = new Produto();

        while (resultSet.next()) {
            produto.setId(resultSet.getInt(1));
            produto.setNome(resultSet.getString(2));
            produto.setDescricao(resultSet.getString(3));
            System.out.println(produto);
        }

        preparedStatement.getConnection().close();
    }
}
