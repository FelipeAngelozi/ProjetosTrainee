package br.com.sgsistemas.sgsaude.pessoas;

public class Medico extends Pessoa{

    private Integer crm;
    private String especialidade;

    private Integer idEspecialidade;

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getCrm() {
        return crm;
    }

    public void setCrm(Integer crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return String.format("ID : %d%nNome : %s%nData de Nascimento : %s%nEspecialiadade : %s%nCRM : %d%nCPF : %s%n", this.getId(), this.getNome(), this.getDataNascimento(), this.especialidade, this.crm, this.getCpf());
    }
}
