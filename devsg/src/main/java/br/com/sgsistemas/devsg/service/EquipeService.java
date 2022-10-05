package br.com.sgsistemas.devsg.service;

import br.com.sgsistemas.devsg.model.Equipe;
import br.com.sgsistemas.devsg.model.Pessoa;
import br.com.sgsistemas.devsg.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    public EquipeRepository equipeRepository;

    public List<Equipe> listar() {
        List<Equipe> equipeList1 = equipeRepository.findAll();
        return equipeList1;
    }

    public void persistir(Equipe equipe) {
        equipeRepository.save(equipe);
    }

    public void deletar(Integer id) {
        equipeRepository.deleteById(id);
    }
}
