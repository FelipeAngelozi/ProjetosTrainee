package br.com.sgsistemas.trainee.sgERPDB.model;

import javax.persistence.*;

@Entity
@Table(name = "Cidade")
public class Cidade {

    @Id
    private String codigo;
    private String nome;
    @ManyToOne
    private UF uf;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", uf=" + uf +
                '}';
    }
}
