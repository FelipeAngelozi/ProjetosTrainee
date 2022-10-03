package br.com.sgsistemas.forum.controller;

import br.com.sgsistemas.forum.dto.TopicoDTO;
import br.com.sgsistemas.forum.modelo.Curso;
import br.com.sgsistemas.forum.modelo.Topico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicoController {

    //@ResponseBody
    @RequestMapping("/topico")
    public List<TopicoDTO> lista() {
        Topico topico = new Topico("Duvida", "Duvidas com Sprig", new Curso("Spring","Programação"));
        return TopicoDTO.converter(Arrays.asList(topico ,topico ,topico));
    }
}
