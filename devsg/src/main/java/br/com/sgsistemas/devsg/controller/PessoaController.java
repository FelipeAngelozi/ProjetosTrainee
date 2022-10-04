package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;


    @GetMapping
    public List<Pessoa> lista() {
        List<Pessoa> pessoaList = pessoaRepository.findAll();
        return pessoaList;
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrar(@RequestBody Pessoa pessoa, UriComponentsBuilder uriBuilder) {
        pessoaRepository.save(pessoa);
        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);

    }
}
