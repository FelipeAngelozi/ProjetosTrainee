package br.com.sgsistemas.sgsaude.DAO.servicos;

import br.com.sgsistemas.sgsaude.factories.ConnectionFactory;
import br.com.sgsistemas.sgsaude.pessoas.Medico;
import br.com.sgsistemas.sgsaude.pessoas.Paciente;
import br.com.sgsistemas.sgsaude.servicos.Atendimento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AtendimentoDAO {

    public void inserirAtendimento(Atendimento atendimento) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "INSERT INTO atendimento (data, paciente_id, medico_id, servico_id, medicamento_id) VALUES (?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, atendimento.getData());
            preparedStatement.setInt(2, atendimento.getIdPaciente());
            preparedStatement.setInt(3, atendimento.getIdMedico());
            preparedStatement.setInt(4, atendimento.getIdServico());
            preparedStatement.setInt(5, atendimento.getIdMedicamento());
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {


                while (resultSet.next()) {
                    atendimento.setNumero(resultSet.getInt(1));
                    atendimento.setData(resultSet.getString(2));
                    atendimento.setIdPaciente(resultSet.getInt(3));
                    atendimento.setIdMedico(resultSet.getInt(4));
                    atendimento.setIdServico(resultSet.getInt(5));
                    atendimento.setIdMedicamento(resultSet.getInt(6));

                    System.out.printf("---Atendimento %d---%nData : %s%nPaciente : %d%nID Medico : %d%nID Servicos : %d%nID Medicamento: %d%n", atendimento.getNumero(), atendimento.getData(), atendimento.getIdPaciente(), atendimento.getIdMedico(), atendimento.getIdServico(), atendimento.getIdMedicamento());
                    System.out.println("O novo atendimento foi inserido no sistema com sucesso!");
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na inserção de novo atendimento!");
        }
    }

    public void listarAtendimento(Atendimento atendimento) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "SELECT atendimento.numero, atendimento.data, paciente.nome, medico.nome, servico.descricao, medicamento.nome  FROM atendimento " +
                "INNER JOIN paciente " +
                "ON ( atendimento.paciente_id = paciente.id) " +
                "INNER JOIN medico " +
                "ON ( atendimento.medico_id = medico.id) " +
                "INNER JOIN servico " +
                "ON ( atendimento.servico_id = servico.numero) " +
                "INNER JOIN medicamento " +
                "ON ( atendimento.medicamento_id = medicamento.codigo) ";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    atendimento.setNumero(resultSet.getInt(1));
                    atendimento.setData(resultSet.getString(2));
                    atendimento.setPacienteNome(resultSet.getString(3));
                    atendimento.setMedicoNome(resultSet.getString(4));
                    atendimento.setServicoDescricao(resultSet.getString(5));
                    atendimento.setMedicamentoNome(resultSet.getString(6));

                    System.out.println(atendimento);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na listagem de atendimentos!");
        }
    }

    public void deletarAtendimento(Integer integer) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "DELETE FROM atendimento WHERE numero = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, integer);
            preparedStatement.execute();
            System.out.println("Atendimento excluido.");
        } catch (Exception e) {
            System.out.println("O código que voce digitou é inválido.");
        }
    }

    public void atualizarAtendimento(Atendimento atendimento) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "UPDATE atendimento SET data = ?, paciente_id = ?, medico_id = ?, servico_id = ?, medicamento_id = ? WHERE numero = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, atendimento.getData());
            preparedStatement.setInt(2, atendimento.getIdPaciente());
            preparedStatement.setInt(3, atendimento.getIdMedico());
            preparedStatement.setInt(4, atendimento.getIdServico());
            preparedStatement.setInt(5, atendimento.getIdMedicamento());
            preparedStatement.setInt(6, atendimento.getNumero());
            preparedStatement.execute();
            System.out.println("Dados atualizados!");
        } catch (Exception e) {
            System.out.println("Erro na atualizacao de dados.");
        }
    }
}
