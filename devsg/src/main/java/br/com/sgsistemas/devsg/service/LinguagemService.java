package br.com.sgsistemas.devsg.service;

import br.com.sgsistemas.devsg.dto.LinguagemDTO;
import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Linguagem;
import br.com.sgsistemas.devsg.repository.LinguagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinguagemService {

    @Autowired
    LinguagemRepository linguagemRepository;

    public List<LinguagemDTO> listar() {
        return LinguagemDTO.converter(linguagemRepository.findAll());
    }

    public void persistir(Linguagem linguagem) {
        linguagemRepository.save(linguagem);
    }

    public void deletar(Integer id) {
        linguagemRepository.deleteById(id);
    }


}
