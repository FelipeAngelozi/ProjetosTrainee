package br.com.sgsistemas.devsg.controller;

import br.com.sgsistemas.devsg.dto.ProdutoDTO;
import br.com.sgsistemas.devsg.form.PessoaForm;
import br.com.sgsistemas.devsg.form.ProdutoForm;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.model.Produto;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import br.com.sgsistemas.devsg.repository.ProdutoRepository;
import br.com.sgsistemas.devsg.service.PessoaService;
import br.com.sgsistemas.devsg.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public List<ProdutoDTO> lista() {
        return ProdutoDTO.converter(produtoService.listar());
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
        Produto produto = produtoForm.converter(equipeRepository);
        produtoService.persistir(produto);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);

    }

    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
        Produto produto = produtoForm.converter(equipeRepository);
        produtoService.persistir(produto);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @DeleteMapping
    public void deletar(Integer id) {
        produtoService.deletar(id);
    }
}
