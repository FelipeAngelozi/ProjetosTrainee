package br.com.sgsistemas.devsg.dto;

import br.com.sgsistemas.devsg.model.Cargo;
import br.com.sgsistemas.devsg.model.Equipe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PessoaDTO {

    private String nome;
    private Cargo cargo;
}
