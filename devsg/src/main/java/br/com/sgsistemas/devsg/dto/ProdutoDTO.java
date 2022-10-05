package br.com.sgsistemas.devsg.dto;

import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.model.Produto;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProdutoDTO {

    private Integer id;
    private String nome;
    private String nomeEquipe;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.nomeEquipe = produto.getEquipe().getNome();
    }

    public static List<ProdutoDTO> converter(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
