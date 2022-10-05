package br.com.sgsistemas.devsg.service;

import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public void persistir(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void deletar(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
