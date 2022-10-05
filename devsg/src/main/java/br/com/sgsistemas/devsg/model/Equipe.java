package br.com.sgsistemas.devsg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipe")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "equipe")
    private List<Pessoa> pessoaList;
    @ManyToMany
    @JsonIgnore
    private List<Linguagem> linguagemList;
    @OneToMany(mappedBy = "equipe")
    private List<Produto> produtos;


    public Equipe(Integer id, String nome, List<Linguagem> linguagemList) {
        this.id = id;
        this.nome = nome;
        this.linguagemList = linguagemList;
    }
}
