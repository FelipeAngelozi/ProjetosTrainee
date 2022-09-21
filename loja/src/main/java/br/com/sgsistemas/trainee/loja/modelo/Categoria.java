package br.com.sgsistemas.trainee.loja.modelo;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String nome;


    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
