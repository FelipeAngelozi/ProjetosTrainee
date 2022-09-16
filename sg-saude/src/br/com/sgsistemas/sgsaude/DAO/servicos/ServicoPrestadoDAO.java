package br.com.sgsistemas.sgsaude.DAO.servicos;

import br.com.sgsistemas.sgsaude.factories.ConnectionFactory;
import br.com.sgsistemas.sgsaude.servicos.Atendimento;
import br.com.sgsistemas.sgsaude.servicos.ServicoPrestado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicoPrestadoDAO {

    public void inserirServicoPrestado(ServicoPrestado servicoPrestado) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "INSERT INTO servico (codigo_tipo_servico, descricao) VALUES (?,?)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, servicoPrestado.getCodigoTipoServico());
            preparedStatement.setString(2, servicoPrestado.getDescricao());
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {


                while (resultSet.next()) {
                    servicoPrestado.setCodigoTipoServico(resultSet.getInt(1));
                    servicoPrestado.setDescricao(resultSet.getString(2));
                    servicoPrestado.setNumero(resultSet.getInt(3));

                    System.out.printf("Numero : %d%nCodigo do tipo de servico : %d%nDescricao : %s%n" , servicoPrestado.getNumero(), servicoPrestado.getCodigoTipoServico(), servicoPrestado.getDescricao());
                    System.out.println("O novo servico foi inserido no sistema com sucesso!");
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na inserção de novo serviço!");
        }
    }

    public void listarServicoPrestado(ServicoPrestado servicoPrestado) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "SELECT servico.numero, tipo_servico.tipo, servico.descricao  FROM servico " +
                "INNER JOIN tipo_servico " +
                "ON (servico.codigo_tipo_servico = tipo_servico.codigo)";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {

                while (resultSet.next()) {
                    servicoPrestado.setNumero(resultSet.getInt(1));;
                    servicoPrestado.setTipoServico(resultSet.getString(2));
                    servicoPrestado.setDescricao(resultSet.getString(3));


                    System.out.println(servicoPrestado);
                }
            }
        } catch (Exception e) {
            System.out.println("Falha na listagem de serviços!");
        }
    }

    public void deletarServico(Integer integer) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "DELETE FROM servico WHERE numero = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, integer);
            preparedStatement.execute();
            System.out.println("Servico excluido.");
        } catch (Exception e) {
            System.out.println("O código que voce digitou é inválido.");
        }
    }

    public void atualizarServico(ServicoPrestado servicoPrestado) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        String sql = "UPDATE servico SET codigo_tipo_servico = ?, descricao = ? WHERE numero = ?";

        try (PreparedStatement preparedStatement = connectionFactory.obterConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, servicoPrestado.getCodigoTipoServico());
            preparedStatement.setString(2, servicoPrestado.getDescricao());
            preparedStatement.setInt(3,servicoPrestado.getNumero());
            preparedStatement.execute();
            System.out.println("Dados atualizados!");
        } catch (Exception e) {
            System.out.println("Erro na atualizacao de dados.");
        }
    }
}

