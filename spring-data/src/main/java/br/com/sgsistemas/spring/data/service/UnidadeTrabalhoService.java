package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import br.com.sgsistemas.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;

@Service
public class UnidadeTrabalhoService {
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private boolean system = true;

    public UnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
    }

    public void iniciar(Scanner scanner) {
        system = true;
        while (system) {
            System.out.println("Qual ação em UNIDADE TRABALHO dejesa executar?\n" +
                    "[0] - SAIR\n" +
                    "[1] - SALVAR\n" +
                    "[2] - ATUALIZAR\n" +
                    "[3] - VISUALIZAR\n" +
                    "[4] - DELETAR POR ID\n" +
                    "[5] - DELETAR TODOS\n");
            Integer actionUnidadeTrabalhoService = scanner.nextInt();

            switch (actionUnidadeTrabalhoService) {
                case 1: {
                    salvar(scanner);
                    break;
                }
                case 2: {
                    atualizar(scanner);
                    break;
                }
                case 3: {
                    visualizar();
                    break;
                } case 4: {
                    deletarPorId(scanner);
                    break;
                } case 5: {
                    deletarTodos(scanner);
                    break;
                }
                default: {
                    system = false;
                    break;
                }

            }

        }
    }


    public void salvar(Scanner scanner) {
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        scanner = new Scanner(System.in);
        System.out.println("Descricao:");
        scanner = new Scanner(System.in);
        String descricao = scanner.nextLine();
        System.out.println("Endereço:");
        scanner = new Scanner(System.in);
        String endereco = scanner.nextLine();
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo");
    }

    public void atualizar(Scanner scanner) {
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID da Unidade de Trabalho que deseja alterar:");
        Integer ID = scanner.nextInt();
        System.out.println("Descricao:");
        scanner = new Scanner(System.in);
        String descricao = scanner.nextLine();
        System.out.println("Endereço:");
        scanner = new Scanner(System.in);
        String endereco = scanner.nextLine();
        unidadeTrabalho.setId(ID);
        unidadeTrabalho.setDescricao(descricao);
        unidadeTrabalho.setEndereco(endereco);
        unidadeTrabalhoRepository.save(unidadeTrabalho);
        System.out.println("Salvo");
    }

    public void visualizar() {
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepository.findAll();
        unidadeTrabalhos.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho));
    }

    public void deletarPorId(Scanner scanner) {
        System.out.println("Digite o ID da Unidade de Trabalho que deseja deletar:");
        scanner = new Scanner(System.in);
        Integer ID = scanner.nextInt();
        unidadeTrabalhoRepository.deleteById(ID);
    }

    public void deletarTodos(Scanner scanner) {
        System.out.println("Voce está prestes a deletar TODOS os arquivos. Deseja continuar? (S/N)");
        scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        resposta = resposta.toUpperCase();
        if (resposta.equals("S")) {
            unidadeTrabalhoRepository.deleteAll();
        }

    }
}
