package padrao;

import java.sql.*;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja_virtual", "postgres", "senha1");

        Statement statement = connection.createStatement();
        statement.execute("SELECT * FROM produto");


        connection.close();

    }
}
