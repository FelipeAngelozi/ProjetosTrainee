package br.com.sgsistemas.sgsaude.DAO.pessoas;

import br.com.sgsistemas.sgsaude.factories.ConnectionFactory;
import br.com.sgsistemas.sgsaude.pessoas.Medico;
import br.com.sgsistemas.sgsaude.pessoas.Paciente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacienteDAO {

    public void inserirPaciente(Paciente paciente) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "INSERT INTO paciente (nome, data_nascimento, nome_da_mae, numero_carteirinha, id_cor_da_pulseira, cpf) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getDataNascimento());
            preparedStatement.setString(3, paciente.getNomeDaMae());
            preparedStatement.setInt(4, paciente.getNumeroCarteirinha());
            preparedStatement.setInt(5, paciente.getIdCorPulseira());
            preparedStatement.setString(6, paciente.getCpf());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                paciente.setId(resultSet.getInt(1));
                paciente.setNome(resultSet.getString(2));
                paciente.setDataNascimento(resultSet.getString(3));
                paciente.setNomeDaMae(resultSet.getString(4));
                paciente.setNumeroCarteirinha(resultSet.getInt(5));
                paciente.setIdCorPulseira(resultSet.getInt(6));
                paciente.setCpf(resultSet.getString(7));


                System.out.println(paciente);
                System.out.println("O novo paciente foi inserido no sistema com sucesso!");
            }


        } catch (Exception e) {
            System.out.println("Falha na inserção de paciente!");
        }
    }

    public void listarPaciente(Paciente paciente) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "SELECT paciente.id, paciente.nome, paciente.data_nascimento, paciente.nome_da_mae, paciente.numero_carteirinha, pulseira.cor, paciente.cpf FROM paciente " +
                "INNER JOIN pulseira " +
                "ON (paciente.id_cor_da_pulseira = pulseira.id)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();


            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    paciente.setId(resultSet.getInt(1));
                    paciente.setNome(resultSet.getString(2));
                    paciente.setDataNascimento(resultSet.getString(3));
                    paciente.setNomeDaMae(resultSet.getString(4));
                    paciente.setNumeroCarteirinha(resultSet.getInt(5));
                    paciente.setCorPulseira(resultSet.getString(6));
                    paciente.setCpf(resultSet.getString(7));


                    System.out.println(paciente);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na listagem de pacientes!");
        }
    }

    public void deletarPaciente(Integer integer) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "DELETE FROM paciente WHERE id = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, integer);
            preparedStatement.execute();
            System.out.println("Paciente excluido.");
        } catch (Exception e) {
            System.out.println("O código que voce digitou é inválido.");
        }
    }

    public void atualizarPaciente(Paciente paciente) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "UPDATE paciente SET nome = ?, data_nascimento = ?, nome_da_mae = ?, numero_carteirinha = ?, id_cor_da_pulseira = ?, cpf = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getDataNascimento());
            preparedStatement.setString(3, paciente.getNomeDaMae());
            preparedStatement.setInt(4, paciente.getNumeroCarteirinha());
            preparedStatement.setInt(5, paciente.getIdCorPulseira());
            preparedStatement.setString(6, paciente.getCpf());
            preparedStatement.setInt(7, paciente.getId());
            preparedStatement.execute();

            System.out.println("Dados atualizados!");
        } catch (Exception e) {
            System.out.println("Erro na atualizacao de dados.");
        }
    }
}
