package br.com.sgsistemas.trainee.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Clientes {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private DadosPessoais dadosPessoais;

    public Clientes() {
    }

    public Clientes(String nome, String cpf) {
        this.dadosPessoais = new DadosPessoais(nome, cpf);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.dadosPessoais.getNome();
    }

    public void setNome(String nome) {
        this.dadosPessoais.setNome(nome);
    }

    public String getCpf() {
        return this.dadosPessoais.getCpf();
    }

    public void setCpf(String cpf) {
        this.dadosPessoais.setCpf(cpf);
    }
}
