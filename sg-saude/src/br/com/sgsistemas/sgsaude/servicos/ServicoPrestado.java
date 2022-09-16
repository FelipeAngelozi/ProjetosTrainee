package br.com.sgsistemas.sgsaude.servicos;

public class ServicoPrestado {

    private Integer numero;
    private Integer codigoTipoServico;
    private String tipoServico;
    private String descricao;

    public Integer getNumero() {
        return numero;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCodigoTipoServico() {
        return codigoTipoServico;
    }

    public void setCodigoTipoServico(Integer codigoTipoServico) {
        this.codigoTipoServico = codigoTipoServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Numero : %d%nTipo do servico : %s%nDescricao : %s%n" ,this.numero, this.tipoServico, this.descricao);
    }
}
