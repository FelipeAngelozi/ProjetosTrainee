package br.com.sgsistemas.devsg.form;

import br.com.sgsistemas.devsg.dto.LinguagemDTO;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class EquipeForm {

    private Integer id;
    @NotNull
    @NotEmpty
    private String nome;
    private List<Integer> linguagensID;


    public Equipe converter(EquipeRepository equipeRepository, LinguagemRepository linguagemRepository, PessoaRepository pessoaRepository) {
        List<Linguagem> linguagemList = new ArrayList<>();
        linguagensID.forEach(linguagemid -> linguagemList.add(linguagemRepository.findById(linguagemid).get()));
        return new Equipe(id, nome, linguagemList);
    }


}
