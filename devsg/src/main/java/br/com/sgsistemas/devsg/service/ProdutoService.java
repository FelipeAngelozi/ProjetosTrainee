package br.com.sgsistemas.devsg.service;

import br.com.sgsistemas.devsg.model.Produto;
import br.com.sgsistemas.devsg.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listar () {
        List<Produto> produtoList = produtoRepository.findAll();
        return produtoList;
    }

    public void persistir(Produto produto) {
        produtoRepository.save(produto);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

}
