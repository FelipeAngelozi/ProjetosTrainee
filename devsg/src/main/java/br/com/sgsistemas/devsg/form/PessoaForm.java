package br.com.sgsistemas.devsg.form;

import br.com.sgsistemas.devsg.model.Cargo;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PessoaForm {


    private Integer id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    private Integer idEquipe;

    public Pessoa converter(EquipeRepository equipeRepository) {
        Equipe equipe = equipeRepository.findById(idEquipe).get();
        return new Pessoa(id, name, cargo, equipe);
    }
}
