package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.dto.PessoaDTO;
import br.com.sgsistemas.devsg.form.PessoaForm;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import br.com.sgsistemas.devsg.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private PessoaService pessoaService;


    @GetMapping
    public List<PessoaDTO> lista() {
        return PessoaDTO.converter( pessoaService.listar());
    }

    @PostMapping
    public ResponseEntity<Pessoa> cadastrar(@RequestBody @Valid PessoaForm pessoaForm, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaForm.converter(equipeRepository);
        pessoaService.persistir(pessoa);
        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);

    }

    @PutMapping
    public ResponseEntity<Pessoa> atualizar(@RequestBody PessoaForm pessoaForm, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = pessoaForm.converter(equipeRepository);
        pessoaService.persistir(pessoa);
        URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);

    }

    @DeleteMapping
    public void deletar(Integer id) {
        pessoaService.deletar(id);
    }
}
