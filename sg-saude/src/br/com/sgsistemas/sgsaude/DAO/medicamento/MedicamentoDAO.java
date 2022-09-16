package br.com.sgsistemas.sgsaude.DAO.medicamento;

import br.com.sgsistemas.sgsaude.factories.ConnectionFactory;
import br.com.sgsistemas.sgsaude.medicamento.Medicamentos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicamentoDAO {

    public void inserirMedicamento(Medicamentos medicamentos) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "INSERT INTO medicamento (nome, dosagem, codigo) VALUES (?,?,?)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, medicamentos.getNome());
            preparedStatement.setString(2, medicamentos.getDosagem());
            preparedStatement.setInt(3, medicamentos.getCodigo());
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

                while (resultSet.next()) {
                    medicamentos.setNome(resultSet.getString(1));
                    medicamentos.setDosagem(resultSet.getString(2));
                    medicamentos.setCodigo(resultSet.getInt(3));
                    System.out.println(medicamentos);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na inserção de medicamentos!");
        }
    }

    public void listarMedicamento(Medicamentos medicamentos) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "SELECT * FROM medicamento ORDER BY codigo";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    medicamentos.setNome(resultSet.getString(1));
                    medicamentos.setDosagem(resultSet.getString(2));
                    medicamentos.setCodigo(resultSet.getInt(3));

                    System.out.println(medicamentos);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na listagem de medicamentos!");
        }
    }

    public void deletarMedicamento(Integer integer) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "DELETE FROM medicamento WHERE codigo = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, integer);
            preparedStatement.execute();
            System.out.println("Medicamento excluido.");
            } catch (Exception e) {
            System.out.println("O código que voce digitou é inválido.");
        }
    }

    public void atualizarMedicamento(Medicamentos medicamentos) throws  SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "UPDATE medicamento SET nome = ?, dosagem = ? WHERE codigo = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, medicamentos.getNome());
            preparedStatement.setString(2, medicamentos.getDosagem());
            preparedStatement.setInt(3, medicamentos.getCodigo());
            preparedStatement.execute();

            System.out.println("Dados atualizados!");

        } catch (Exception e) {
            System.out.println("Erro na atualizacao de dados.");
        }
    }
}
