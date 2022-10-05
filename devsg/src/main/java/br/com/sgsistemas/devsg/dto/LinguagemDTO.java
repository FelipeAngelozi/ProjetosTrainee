package br.com.sgsistemas.devsg.dto;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class LinguagemDTO {

    private Integer id;
    private String nome;
    private List<String> equipeNomeList = new ArrayList<>();

    public LinguagemDTO(Linguagem linguagem) {
        this.id = linguagem.getId();
        this.nome = linguagem.getNome();
        linguagem.getEquipeList().forEach(equipe -> equipeNomeList.add(equipe.getNome()));
    }

    public static List<LinguagemDTO> converter(List<Linguagem> linguagems) {
        return linguagems.stream().map(LinguagemDTO::new).collect(Collectors.toList());
    }
}
