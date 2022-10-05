package br.com.sgsistemas.devsg.controller;


import br.com.sgsistemas.devsg.dto.EquipeDTO;
import br.com.sgsistemas.devsg.form.EquipeForm;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import br.com.sgsistemas.devsg.service.EquipeService;
import br.com.sgsistemas.devsg.service.LinguagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    LinguagemRepository linguagemRepository;
    @Autowired
    EquipeService equipeService;

    @GetMapping
    public List<EquipeDTO> listar() {
        return EquipeDTO.converter(equipeService.listar());
    }

    @PostMapping
    public ResponseEntity<Equipe> cadastrar(@RequestBody @Valid EquipeForm equipeForm, UriComponentsBuilder uriBuilder) {
        Equipe equipe = equipeForm.converter(equipeRepository, linguagemRepository,pessoaRepository);
        equipeService.persistir(equipe);

        URI uri = uriBuilder.path("/equipe/{id}").buildAndExpand(equipe.getId()).toUri();
        return ResponseEntity.created(uri).body(equipe);
    }

    @PutMapping
    public ResponseEntity<Equipe> atualizar(@RequestBody @Valid EquipeForm equipeForm, UriComponentsBuilder uriBuilder) {
        Equipe equipe = equipeForm.converter(equipeRepository, linguagemRepository,pessoaRepository);
        equipeService.persistir(equipe);

        URI uri = uriBuilder.path("/equipe/{id}").buildAndExpand(equipe.getId()).toUri();
        return ResponseEntity.created(uri).body(equipe);
    }

    @DeleteMapping
    public void deletar(Integer id) {
        equipeService.deletar(id);
    }
}
