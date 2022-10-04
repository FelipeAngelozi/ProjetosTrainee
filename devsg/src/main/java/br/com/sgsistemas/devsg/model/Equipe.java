package br.com.sgsistemas.devsg.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipe")
@Getter
@Setter
public class Equipe {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "equipe")
    private List<Pessoa> pessoaList;
    @ManyToMany(mappedBy = "equipeList")
    private List<Linguagem> linguagemList;
}
