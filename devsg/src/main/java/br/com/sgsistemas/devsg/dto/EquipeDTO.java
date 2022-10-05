package br.com.sgsistemas.devsg.dto;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data public class EquipeDTO {
    private Integer id;
    private String nome;
    private List<String> pessoaNomeList = new ArrayList<>();

    private List<String> linguagensNomeList = new ArrayList<>();

    public EquipeDTO(Equipe equipe) {
        this.id = equipe.getId();
        this.nome = equipe.getNome();
        equipe.getPessoaList().forEach(pessoa -> pessoaNomeList.add(pessoa.getName()));
        equipe.getLinguagemList().forEach(linguagem -> linguagensNomeList.add(linguagem.getNome()));
    }

    public static List<EquipeDTO> converter(List<Equipe> equipes) {
        return equipes.stream().map(EquipeDTO::new).collect(Collectors.toList());
    }
}
