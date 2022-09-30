package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class RelatorioService {

    private Boolean system;
    private FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void iniciar(Scanner scanner) {
        system = true;
        while (system) {
            System.out.println("Qual ação em FUNCIONARIO dejesa executar?\n" +
                    "[0] - SAIR\n" +
                    "[1] - BUSCAR FUNCIONARIO PELO NOME\n"
            );
            Integer actionRelatorio = scanner.nextInt();

            switch (actionRelatorio) {
                case 1: {
                    buscaFuncionarioNome(scanner);
                    break;
                }
                default: {
                    system = false;
                    break;
                }

            }

        }
    }

    private void buscaFuncionarioNome (Scanner scanner) {
        System.out.println("Qual o nome do funcionario que deseja encontrar?");
        scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        funcionarioRepository.findByNome(nome).forEach(funcionario -> System.out.println(funcionario));
    }
}
