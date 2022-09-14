package padrao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {

        Statement statement = ConnectionFactory.obterConexao().createStatement();
        statement.execute("DELETE FROM produto WHERE id = 6 or id = 7 or id = 8");
        ResultSet resultSet = statement.getResultSet();


//        Produto produto = new Produto();


//        while (resultSet.next()) {
//            produto.setId(resultSet.getInt(1));
//            produto.setNome(resultSet.getString(2));
//            produto.setDescricao(resultSet.getString(3));
//            System.out.println(produto);
//        }

        statement.getConnection().close();
    }
}
