package br.com.sgsistemas.devsg.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "linguagem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Linguagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @ManyToMany(mappedBy = "linguagemList")
    private List<Equipe> equipeList;

    public Linguagem(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
