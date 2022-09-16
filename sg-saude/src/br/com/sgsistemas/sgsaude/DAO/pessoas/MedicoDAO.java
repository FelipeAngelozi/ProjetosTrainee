package br.com.sgsistemas.sgsaude.DAO.pessoas;

import br.com.sgsistemas.sgsaude.factories.ConnectionFactory;
import br.com.sgsistemas.sgsaude.medicamento.Medicamentos;
import br.com.sgsistemas.sgsaude.pessoas.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicoDAO {


    public void inserirMedico(Medico medico) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "INSERT INTO medico (nome, data_nascimento, crm, cpf, id_especialidade) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getDataNascimento());
            preparedStatement.setInt(3, medico.getCrm());
            preparedStatement.setString(4, medico.getCpf());
            preparedStatement.setInt(5, medico.getIdEspecialidade());
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {


                while (resultSet.next()) {
                    medico.setId(resultSet.getInt(1));
                    medico.setNome(resultSet.getString(2));
                    medico.setDataNascimento(resultSet.getString(3));
                    medico.setCrm(resultSet.getInt(4));
                    medico.setCpf(resultSet.getString(5));
                    medico.setEspecialidade(resultSet.getString(6));

                    System.out.println(medico);
                    System.out.println("O novo medico foi inserido no sistema com sucesso!");
                }
            }
        } catch (Exception e){
            System.out.println("Falha da inserção de médico!");
        }
    }

    public void listarMedico(Medico medico) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "SELECT medico.id, medico.nome, medico.data_nascimento, medico.crm, medico.cpf, especialidade.descricao FROM medico " +
                "INNER JOIN especialidade " +
                "ON (medico.id_especialidade = especialidade.id)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    medico.setId(resultSet.getInt(1));
                    medico.setNome(resultSet.getString(2));
                    medico.setDataNascimento(resultSet.getString(3));
                    medico.setCrm(resultSet.getInt(4));
                    medico.setCpf(resultSet.getString(5));
                    medico.setEspecialidade(resultSet.getString(6));


                    System.out.println(medico);
                }
            }
        } catch (Exception e){
            System.out.println("Falha na listagem de médicos!");
        }
    }

    public void deletarMedico(Integer integer) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "DELETE FROM medico WHERE id = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, integer);
            preparedStatement.execute();
            System.out.println("Medico excluido.");
        } catch (Exception e) {
            System.out.println("O ID que voce digitou é inválido.");
        }
    }

    public void atualizarMedico(Medico medico) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "UPDATE medico SET nome = ?, data_nascimento = ?, crm = ?, cpf = ?, id_especialidade = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getDataNascimento());
            preparedStatement.setInt(3, medico.getCrm());
            preparedStatement.setString(4, medico.getCpf());
            preparedStatement.setInt(5, medico.getIdEspecialidade());
            preparedStatement.setInt(6, medico.getId());
            preparedStatement.execute();

            System.out.println("Dados atualizados!");

        } catch (Exception e) {
            System.out.println("Erro na atualizacao de dados.");
        }
    }
}
