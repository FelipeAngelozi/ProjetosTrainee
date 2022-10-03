package br.com.sgsistemas.cadastroclientes.service;

import br.com.sgsistemas.cadastroclientes.model.ClienteDTO;
import br.com.sgsistemas.cadastroclientes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {

    private final ClienteRepository clienteRepository;

    public RelatorioService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void buscaFuncionarioNome () {
        List<ClienteDTO> list = clienteRepository.findClienteNomeENasc();
        list.forEach(clienteDTO -> {
            System.out.println("Nome: " + clienteDTO.getNome() +
                    "\nData de Nascimento: " + clienteDTO.getDataNascimento());
        });
    }
}
