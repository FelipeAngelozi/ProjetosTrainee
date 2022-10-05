package br.com.sgsistemas.devsg.form;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Produto;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ProdutoForm {

    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    private Integer idEquipe;

    public Produto converter(EquipeRepository equipeRepository) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        return new Produto(id, nome, equipe);
    }
}

