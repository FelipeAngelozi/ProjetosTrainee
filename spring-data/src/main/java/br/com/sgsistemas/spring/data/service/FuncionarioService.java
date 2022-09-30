package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.model.Funcionario;
import br.com.sgsistemas.spring.data.model.UnidadeTrabalho;
import br.com.sgsistemas.spring.data.repository.CargoRespository;
import br.com.sgsistemas.spring.data.repository.FuncionarioRepository;
import br.com.sgsistemas.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
    private final CargoRespository cargoRespository;
    private boolean system;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, UnidadeTrabalhoRepository unidadeTrabalhoRepository, CargoRespository cargoRespository) {
        this.funcionarioRepository = funcionarioRepository;
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
        this.cargoRespository = cargoRespository;
    }

    public void iniciar(Scanner scanner) {
        system = true;
        while (system) {
            System.out.println("Qual ação em FUNCIONARIO dejesa executar?\n" +
                    "[0] - SAIR\n" +
                    "[1] - SALVAR\n" +
                    "[2] - ATUALIZAR\n" +
                    "[3] - VISUALIZAR\n" +
                    "[4] - DELETAR POR ID\n" +
                    "[5] - DELETAR TODOS\n");
            Integer actionFuncionario = scanner.nextInt();

            switch (actionFuncionario) {
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
        scanner = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        System.out.println("Nome:");
        scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("CPF:");
        scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();
        System.out.println("Salário:");
        scanner = new Scanner(System.in);
        BigDecimal salario = scanner.nextBigDecimal();
        scanner = new Scanner(System.in);
        System.out.println("Data contratacao:");
        scanner = new Scanner(System.in);
        String dataContratacao = scanner.nextLine();
        System.out.println("ID do cargo;");
        scanner = new Scanner(System.in);
        Integer cargoID = scanner.nextInt();
        Cargo cargo = new Cargo();
        cargo = cargoRespository.findById(cargoID).get();
        funcionario.setCargo(cargo);
        funcionario.setNome(nome);
        funcionario.setSalario(salario);
        funcionario.setCpf(cpf);
        funcionario.setDataContratacao(dataContratacao);
        List<UnidadeTrabalho> unidadeTrabalhoList = unidades(scanner);
        funcionario.setUnidadeTrabalhos(unidadeTrabalhoList);
        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }

    private List<UnidadeTrabalho> unidades(Scanner scanner) {
        Boolean isTrue = true;
        List<UnidadeTrabalho> unidades = new ArrayList<>();

        while(isTrue) {
            System.out.println("Digite o ID da unidade (para sair digite 0)");
            scanner = new Scanner(System.in);
            Integer unidadeID = scanner.nextInt();
            if(unidadeID != 0) {
                Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeID);
                unidades.add(unidade.get());
            } else {
                isTrue = false;
            }
        }
        return unidades;
    }
    public void atualizar(Scanner scanner) {
        scanner = new Scanner(System.in);
        Funcionario funcionario = new Funcionario();
        System.out.println("Digite o ID do funcionario que deseja alterar:");
        Integer ID = scanner.nextInt();
        System.out.println("Nome:");
        scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        System.out.println("CPF:");
        scanner = new Scanner(System.in);
        String cpf = scanner.nextLine();
        System.out.println("Salário:");
        scanner = new Scanner(System.in);
        BigDecimal salario = scanner.nextBigDecimal();
        scanner = new Scanner(System.in);
        System.out.println("Data contratacao:");
        scanner = new Scanner(System.in);
        String dataContratacao = scanner.nextLine();

        funcionario.setId(ID);
        funcionario.setNome(nome);
        funcionario.setSalario(salario);
        funcionario.setCpf(cpf);
        funcionario.setDataContratacao(dataContratacao);
        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }

    public void visualizar() {
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }

    public void deletarPorId(Scanner scanner) {
        System.out.println("Digite o ID do funcionario que deseja deletar:");
        scanner = new Scanner(System.in);
        Integer ID = scanner.nextInt();
        funcionarioRepository.deleteById(ID);
    }

    public void deletarTodos(Scanner scanner) {
        System.out.println("Voce está prestes a deletar TODOS os arquivos. Deseja continuar? (S/N)");
        scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        resposta = resposta.toUpperCase();
        if (resposta.equals("S")) {
            funcionarioRepository.deleteAll();
        }

    }
}
