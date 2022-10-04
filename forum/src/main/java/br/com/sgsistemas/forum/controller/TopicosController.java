package br.com.sgsistemas.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import br.com.sgsistemas.forum.dto.TopicoDto;
import br.com.sgsistemas.forum.form.TopicoForm;
import br.com.sgsistemas.forum.modelo.Topico;
import br.com.sgsistemas.forum.repository.CursoRepository;
import br.com.sgsistemas.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
@RequestMapping("/topico")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso) {
        if (nomeCurso == null) {
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
            return TopicoDto.converter(topicos);
        }
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @PutMapping
    public ResponseEntity<TopicoDto> atualizar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converterComId(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));

    }

    @DeleteMapping
    public void deletar(Long id) {
        topicoRepository.deleteById(id);
    }
}
