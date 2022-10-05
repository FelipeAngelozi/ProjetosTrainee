package br.com.sgsistemas.devsg.dto;

import br.com.sgsistemas.devsg.model.Cargo;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String nomeCargo;
    private String nomeEquipe;

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getName();
        this.nomeCargo = pessoa.getCargo().toString();
        this.nomeEquipe = pessoa.getEquipe().getNome();
    }

    public static List<PessoaDTO> converter(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }
}
