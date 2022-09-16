package br.com.sgsistemas.sgsaude.pessoas;

public class Paciente extends Pessoa{
    private String nomeDaMae;
    private Integer numeroCarteirinha;

    private Integer idCorPulseira;

    private String corPulseira;

    public String getCorPulseira() {
        return corPulseira;
    }

    public void setCorPulseira(String corPulseira) {
        this.corPulseira = corPulseira;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    public Integer getNumeroCarteirinha() {
        return numeroCarteirinha;
    }

    public void setNumeroCarteirinha(Integer numeroCarteirinha) {
        this.numeroCarteirinha = numeroCarteirinha;
    }

    public Integer getIdCorPulseira() {
        return idCorPulseira;
    }

    public void setIdCorPulseira(Integer idCorPulseira) {
        this.idCorPulseira = idCorPulseira;
    }

    @Override
    public String toString() {
        return String.format("ID : %d%nNome : %s%nData de Nascimento : %s%nNome da mãe : %s%nNumero da carteirinha : %d%nCor da pulseira: %s%nCPF : %s%n", this.getId(), this.getNome(), this.getDataNascimento(), this.nomeDaMae, this.numeroCarteirinha,this.corPulseira, this.getCpf());
    }
}
