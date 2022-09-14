package padrao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {
    public static void main(String[] args) throws SQLException {

        Statement statement = ConnectionFactory.obterConexao().createStatement();
        statement.execute("INSERT INTO produto (nome , descricao) VALUES ('Razer Naga', 'Mouse Gamer')", Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();


        Produto produto = new Produto();

        while (resultSet.next()) {
            produto.setId(resultSet.getInt(1));
            produto.setNome(resultSet.getString(2));
            produto.setDescricao(resultSet.getString(3));
            System.out.println(produto);
        }

        statement.getConnection().close();
    }
}
