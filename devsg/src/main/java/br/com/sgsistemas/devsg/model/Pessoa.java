package br.com.sgsistemas.devsg.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @ManyToOne
    private Equipe equipe;
}
