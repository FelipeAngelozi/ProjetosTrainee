package br.com.sgsistemas.sgsaude.principal;

import br.com.sgsistemas.sgsaude.DAO.medicamento.MedicamentoDAO;
import br.com.sgsistemas.sgsaude.DAO.pessoas.MedicoDAO;
import br.com.sgsistemas.sgsaude.DAO.pessoas.PacienteDAO;
import br.com.sgsistemas.sgsaude.DAO.servicos.AtendimentoDAO;
import br.com.sgsistemas.sgsaude.DAO.servicos.ServicoPrestadoDAO;
import br.com.sgsistemas.sgsaude.factories.ConnectionFactory;
import br.com.sgsistemas.sgsaude.medicamento.Medicamentos;
import br.com.sgsistemas.sgsaude.pessoas.Medico;
import br.com.sgsistemas.sgsaude.pessoas.Paciente;
import br.com.sgsistemas.sgsaude.servicos.Atendimento;
import br.com.sgsistemas.sgsaude.servicos.ServicoPrestado;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Scanner sc = new Scanner(System.in);


//        //######################### MEDICO #########################
//        Medico medico = new Medico();
//        MedicoDAO medicoDAO = new MedicoDAO();

//        medico.setNome("Medico Teste");
//        medico.setDataNascimento("11/11/11111");
//        medico.setIdEspecialidade(1);
//        medico.setCrm(1111);
//        medico.setCpf("111.111.111-11");
//
//        System.out.println("---------COMANDOS MÉDICO---------");
////        medicoDAO.inserirMedico(medico);
//        System.out.println("------------------");
//        medicoDAO.listarMedico(medico);
//        System.out.println("------------------");
//        //passa a id no medico como parametro:
//        medicoDAO.deletarMedico(0);
//        System.out.println("------------------");
//        medicoDAO.atualizarMedico(medico);
//        System.out.println("------------------");

//        //######################### PACIENTES #########################
//        Paciente paciente = new Paciente();
//        PacienteDAO pacienteDAO = new PacienteDAO();

//        paciente.setNome("Paciente Teste");
//        paciente.setDataNascimento("22/22/2222");
//        paciente.setNomeDaMae("Nome da mae teste");
//        paciente.setNumeroCarteirinha(1);
//        paciente.setIdCorPulseira(1);
//        paciente.setCpf("222.222.222-22");

//        System.out.println("---------COMANDOS PACIENTE---------");
//        pacienteDAO.inserirPaciente(paciente);
//        System.out.println("------------------");
//        pacienteDAO.listarPaciente(paciente);
//        System.out.println("------------------");
//        //passa a id do paciente como parametro:
//        pacienteDAO.deletarPaciente(0);
//        System.out.println("------------------");
//        pacienteDAO.atualizarPaciente(paciente);
//
//        //######################### MEDICAMENTOS #########################
//        Medicamentos medicamentos = new Medicamentos();
//        MedicamentoDAO medicamentoDAO = new MedicamentoDAO();

//        medicamentos.setCodigo(1234);
//        medicamentos.setNome("Reconter");
//        medicamentos.setDosagem("50mg");

//        System.out.println("---------COMANDOS MEDICAMENTOS---------");
//        try {
//            medicamentoDAO.inserirMedicamento(medicamentos);
//        } catch (Exception e) {
//            System.out.println("Numero inválido ou medicamento já cadastrado");
//        }
//        System.out.println("------------------");
//        medicamentoDAO.listarMedicamento(medicamentos);
//        System.out.println("------------------");
//        //passa o codigo do medicamento como parametro:
//        medicamentoDAO.deletarMedicamento(0);
//        System.out.println("------------------");
//        medicamentoDAO.atualizarMedicamento(medicamentos);

        //######################### SERVICOS #########################
//        ServicoPrestado servicoPrestado = new ServicoPrestado();
//        ServicoPrestadoDAO servicoPrestadoDAO = new ServicoPrestadoDAO();


//        servicoPrestado.setDescricao("Teste");
//        servicoPrestado.setCodigoTipoServico(1);
//
//        System.out.println("---------COMANDOS SERVICOS---------");
//        servicoPrestadoDAO.inserirServicoPrestado(servicoPrestado);
//        System.out.println("------------------");
//        servicoPrestadoDAO.listarServicoPrestado(servicoPrestado);
//        System.out.println("------------------");
//        //passa o numero do serviço como parametro:
//        servicoPrestadoDAO.deletarServico(0);
//        System.out.println("------------------");
//        servicoPrestadoDAO.atualizarServico(servicoPrestado);

        //######################### ATENDIMENTO #########################
//        //LEONARDO
//        Atendimento atendimento = new Atendimento();
//        AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

//        try {
//            atendimento.setData("00/00/0000");
//            atendimento.setIdPaciente(8);
//            atendimento.setIdMedico(30);
//            atendimento.setIdServico(1);
//            atendimento.setIdMedicamento(1234);

//            System.out.println("---------COMANDOS ATENDIMENTO---------");
//            atendimentoDAO.inserirAtendimento(atendimento);
//            System.out.println("------------------");
//            atendimentoDAO.listarAtendimento(atendimento);
//            System.out.println("------------------");
//            atendimentoDAO.deletarAtendimento(0);
//            System.out.println("------------------");
//            atendimentoDAO.atualizarAtendimento(atendimento);
//        } catch (Exception e) {
//            System.out.println("Os valores que voce digitou nao estao corretos!");
//        }
    }
}
//######################### TENTATIVA DE FAZER UM MENU QUE SERIA MUDADO PRA UMA CLASSE MENU POSTERIORMENTE #########################
//        System.out.println("------ SG SAUDE ------");
//        System.out.println();
//        System.out.println("Selecione o que deseja fazer:\n" +
//                "[1] - INSERIR" +
//                "[2] - LISTAR" +
//                "[3] - DELETAR");
//
//        Integer respostaMetodos = sc.nextInt();
//
//
//        switch (respostaMetodos) {
//            case 1: {
//                System.out.println("--- INSERIR ---");
//                System.out.println("O que deseja inserir?:");
//                System.out.println("[1] - ATENDIMENTO" +
//                        "\n[2] - PACIENTE" +
//                        "\n[3] - MEDICAMENTO" +
//                        "\n[4] - SERVICO" +
//                        "\n[5] - MEDICO");
//
//                Integer respostaInsercao = sc.nextInt();
//
//                switch (respostaInsercao) {
//
//                    case 1: {
//                        System.out.println("--- NOVO ATENDIMENTO ---");
//                        System.out.println("Insira as informações do atendimento:");
//                        System.out.println("Data : ");
//                        String data = sc.nextLine();
//                        System.out.println("ID do Paciente: ");
//                        Integer idPaciente = sc.nextInt();
//                        System.out.println("ID do Médico: ");
//                        Integer idMedico = sc.nextInt();
//                        System.out.println("ID do Servico: ");
//                        Integer idServico = sc.nextInt();
//                        System.out.println("ID do Medicamento: ");
//                        Integer idMedicamento = sc.nextInt();
//
//                        try {
//                            atendimento.setData(data);
//                            atendimento.setIdPaciente(idPaciente);
//                            atendimento.setIdMedico(idMedico);
//                            atendimento.setIdServico(idServico);
//                            atendimento.setIdMedicamento(idMedicamento);
//
//                            System.out.println("------------------");
//                            atendimentoDAO.inserirAtendimento(atendimento);
//                            System.out.println("------------------");
//                        } catch (Exception e) {
//                            System.out.println("Os valores que voce digitou nao estao corretos!");
//                        }
//                        break;
//                    }
//
//                    case 2: {
//                        System.out.println("--- NOVO PACIENTE ---");
//                        System.out.println("Insire as informações do paciente:");
//                    }
//                }
//            }
//        }
//    }
//}
