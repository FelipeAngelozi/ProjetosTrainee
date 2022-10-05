package br.com.sgsistemas.devsg.form;


import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LinguagemForm {

    @Autowired
    EquipeRepository equipeRepository;
    private Integer id;
    @NotNull
    @NotNull
    private String nome;

    public Linguagem converter() {
        return new Linguagem(id, nome);
    }


}
