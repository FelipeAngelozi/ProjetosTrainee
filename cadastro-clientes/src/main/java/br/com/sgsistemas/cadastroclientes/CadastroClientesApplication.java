package br.com.sgsistemas.cadastroclientes;


import br.com.sgsistemas.cadastroclientes.service.ClienteService;
import br.com.sgsistemas.cadastroclientes.service.EnderecoService;
import br.com.sgsistemas.cadastroclientes.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class CadastroClientesApplication implements CommandLineRunner {

    private final ClienteService clienteService;

    private final EnderecoService enderecoService;

    private final RelatorioService relatorioService;

    public CadastroClientesApplication(ClienteService clienteService, RelatorioService relatorioService, EnderecoService enderecoService) {
        this.clienteService = clienteService;
        this.relatorioService = relatorioService;
        this.enderecoService = enderecoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CadastroClientesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);


//        clienteService.salvarCliente(scanner);
//        enderecoService.salvarEndereço(scanner);

        relatorioService.buscaFuncionarioNome();


    }


}



