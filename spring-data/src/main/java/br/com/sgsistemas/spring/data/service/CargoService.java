package br.com.sgsistemas.spring.data.service;

import br.com.sgsistemas.spring.data.model.Cargo;
import br.com.sgsistemas.spring.data.repository.CargoRespository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Scanner;

@Service
public class CargoService {

    private final CargoRespository cargoRespository;
    private boolean system = true;

    public CargoService(CargoRespository cargoRespository) {
        this.cargoRespository = cargoRespository;
    }

    public void iniciar(Scanner scanner) {

        while (system) {
            System.out.println("Qual ação em CARGO dejesa executar?\n" +
                    "[0] - SAIR\n" +
                    "[1] - SALVAR\n" +
                    "[2] - ATUALIZAR\n" +
                    "[3] - VISUALIZAR\n" +
                    "[4] - DELETAR POR ID\n" +
                    "[5] - DELETAR TODOS\n");
            Integer actionCargo = scanner.nextInt();

            switch (actionCargo) {
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
        System.out.println("Descricao do cargo:");
        Cargo cargo = new Cargo();
        String descricao = scanner.nextLine();
        cargo.setDescricao(descricao);
        cargoRespository.save(cargo);
        System.out.println("Salvo");
    }

    public void atualizar(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cargo que deseja alterar:");
        Integer cargoID = scanner.nextInt();
        System.out.println("Digite a nova descricao do cargo:");
        scanner = new Scanner(System.in);
        String novoCargo = scanner.nextLine();
        Cargo cargo = new Cargo();
        cargo.setId(cargoID);
        cargo.setDescricao(novoCargo);
        cargoRespository.save(cargo);
    }

    public void visualizar() {
        Iterable<Cargo> cargos = cargoRespository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }

    public void deletarPorId(Scanner scanner) {
        System.out.println("Digite o ID do cargo que deseja deletar:");
        scanner = new Scanner(System.in);
        Integer cargoID = scanner.nextInt();
        cargoRespository.deleteById(cargoID);
    }

    public void deletarTodos(Scanner scanner) {
        System.out.println("Voce está prestes a deletar TODOS os arquivos. Deseja continuar? (S/N)");
        scanner = new Scanner(System.in);
        String resposta = scanner.nextLine();
        resposta = resposta.toUpperCase();
        if (resposta.equals("S")) {
            cargoRespository.deleteAll();
        }

    }
}
