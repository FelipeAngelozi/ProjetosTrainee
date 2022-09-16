package br.com.sgsistemas.sgsaude.servicos;

import br.com.sgsistemas.sgsaude.medicamento.Medicamentos;
import br.com.sgsistemas.sgsaude.pessoas.Medico;
import br.com.sgsistemas.sgsaude.pessoas.Paciente;

public class Atendimento {

    private Integer numero;
    private String data;
    private Integer idPaciente;
    private Integer idMedico;
    private Integer idServico;
    private Integer idMedicamento;

    private String pacienteNome;
    private String medicoNome;
    private String servicoDescricao;
    private String medicamentoNome;

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    public String getMedicoNome() {
        return medicoNome;
    }

    public void setMedicoNome(String medicoNome) {
        this.medicoNome = medicoNome;
    }

    public String getServicoDescricao() {
        return servicoDescricao;
    }

    public void setServicoDescricao(String servicoDescricao) {
        this.servicoDescricao = servicoDescricao;
    }

    public String getMedicamentoNome() {
        return medicamentoNome;
    }

    public void setMedicamentoNome(String medicamentoNome) {
        this.medicamentoNome = medicamentoNome;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdServico() {
        return idServico;
    }

    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    public Integer getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Integer idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return String.format("---Atendimento %d---%nData : %s%nPaciente : %s%nMedico : %s%nServicos : %s%nMedicamentos: %s%n", this.numero,this.data, this.getPacienteNome(), this.getMedicoNome(), this.getServicoDescricao(), this.getMedicamentoNome());
    }


}
