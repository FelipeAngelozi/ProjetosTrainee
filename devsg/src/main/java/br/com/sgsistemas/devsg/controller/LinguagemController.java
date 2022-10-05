package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.dto.LinguagemDTO;
import br.com.sgsistemas.devsg.form.LinguagemForm;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import br.com.sgsistemas.devsg.service.LinguagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/linguagem")
public class LinguagemController {

    @Autowired
    private LinguagemRepository linguagemRepository;
    @Autowired
    private LinguagemService linguagemService;

    @GetMapping
    public List<LinguagemDTO> listar() {

        return linguagemService.listar();
    }

    @PostMapping
    public ResponseEntity<Linguagem> cadastrar(@RequestBody @Valid LinguagemForm linguagemForm, UriComponentsBuilder uriBuilder) {
        Linguagem linguagem = linguagemForm.converter();
        linguagemService.persistir(linguagem);

        URI uri = uriBuilder.path("/linguagem/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(linguagem);
    }

    @PutMapping
    public ResponseEntity<Linguagem> atualizar(@RequestBody @Valid LinguagemForm linguagemForm, UriComponentsBuilder uriBuilder) {
        Linguagem linguagem = linguagemForm.converter();
        linguagemService.persistir(linguagem);

        URI uri = uriBuilder.path("/linguagem/{id}").buildAndExpand(linguagem.getId()).toUri();
        return ResponseEntity.created(uri).body(linguagem);
    }

    @DeleteMapping
    public void deletar(Integer id) {
        linguagemService.deletar(id);
    }
}
