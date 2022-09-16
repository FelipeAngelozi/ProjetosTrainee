package br.com.sgsistemas.sgsaude.medicamento;

public class Medicamentos {

    private Integer codigo;
    private String nome;

    private String dosagem;

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("Código : %d%nNome : %s%nDosagem : %s%n", this.codigo, this.nome, this.dosagem );
    }
}
