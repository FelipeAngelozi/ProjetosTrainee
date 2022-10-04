package br.com.sgsistemas.devsg.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "linguagem")
@Getter
@Setter
public class Linguagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany
    private List<Equipe> equipeList;
}
