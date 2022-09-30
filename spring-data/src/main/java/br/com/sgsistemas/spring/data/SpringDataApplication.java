package br.com.sgsistemas.spring.data;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.CargoRespository;
import br.com.sgsistemas.spring.data.service.CargoService;
import br.com.sgsistemas.spring.data.service.FuncionarioService;
import br.com.sgsistemas.spring.data.service.RelatorioService;
import br.com.sgsistemas.spring.data.service.UnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CargoService cargoService;
    private final FuncionarioService funcionarioService;
    private final UnidadeTrabalhoService unidadeTrabalhoService;
    private final RelatorioService relatorioService;

    private boolean system = true;

    public SpringDataApplication(CargoService cargoService, FuncionarioService funcionarioService, UnidadeTrabalhoService unidadeTrabalhoService, RelatorioService relatorioService) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
        this.relatorioService = relatorioService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (system) {
            system = true; System.out.println("Qual acao voce quer executar?\n" +
                    "[0] - SAIR\n" +
                    "[1] - CARGO\n" +
                    "[2] - FUNCIONARIO\n" +
                    "[3] - UNIDADE DE TRABALHO\n" +
                    "[4] - RELATÓRIO\n");

            Integer action = sc.nextInt();

            switch (action) {
                case 0: {
                    system = false;
                    break;
                }
                case 1: {
                    cargoService.iniciar(sc);
                    break;
                }
                case 2: {
                    funcionarioService.iniciar(sc);
                    break;
                }
                case 3: {
                    unidadeTrabalhoService.iniciar(sc);
                    break;
                }
                case 4: {
                    relatorioService.iniciar(sc);
                    break;
                }

            }

        }
    }
}
