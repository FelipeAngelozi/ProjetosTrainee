package br.com.sgsistemas.cadastroclientes.service;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import br.com.sgsistemas.cadastroclientes.model.Endereco;
import br.com.sgsistemas.cadastroclientes.repository.ClienteRepository;
import br.com.sgsistemas.cadastroclientes.repository.EnderecoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;

    public ClienteService(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void salvarCliente(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Data de nascimento:");
        String dataNascimentoString = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoCliente = LocalDate.parse(dataNascimentoString, dtf);
        System.out.println("Limite do cliente:");
        BigDecimal limiteCliente = scanner.nextBigDecimal();
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setDataNascimento(dataNascimentoCliente);
        cliente.setLimite(limiteCliente);
        clienteRepository.save(cliente);

    }

    public void atualizarCliente(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que deseja alterar:");
        Integer clienteID = scanner.nextInt();
        System.out.println("Novo nome do cliente:");
        String nomeCliente = scanner.nextLine();
        System.out.println("Nova data de nascimento:");
        String dataNascimentoString = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimentoCliente = LocalDate.parse(dataNascimentoString, dtf);
        System.out.println("Novo limite do cliente:");
        BigDecimal limiteCliente = scanner.nextBigDecimal();
        Cliente cliente = new Cliente();
        cliente.setId(clienteID);
        cliente.setNome(nomeCliente);
        cliente.setDataNascimento(dataNascimentoCliente);
        cliente.setLimite(limiteCliente);
        clienteRepository.save(cliente);
    }

    public void visualizarClientePorPagina(Scanner scanner) {
        System.out.println("Digite a pagina que deseja visualizar");
        Integer pagina = scanner.nextInt();

        Pageable pageable = PageRequest.of(pagina, 10, Sort.by(Sort.Direction.ASC, "nome"));
        Page<Cliente> clientePage = clienteRepository.findAll(pageable);

        System.out.println("Página: " + clientePage.getNumber());
        clientePage.forEach(cliente -> System.out.println(cliente));
    }

    public void visualizarClientes() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> System.out.println(cliente));
    }

    public void excluirClientePorID(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID do cliente que deseja remover:");
        Integer clienteID = scanner.nextInt();
        clienteRepository.deleteById(clienteID);
    }

    public void excluirTodosClientes(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Voce está prestes a excluir TODOS os clientes. Deseja continuar? (S/N)");
        String resposta = scanner.nextLine();
        resposta = resposta.toLowerCase();
        if (resposta.equals("s")) {
            clienteRepository.deleteAll();
        }
    }


    private List<Endereco> unidades(Scanner scanner) {
        Boolean isTrue = true;
        List<Endereco> enderecos = new ArrayList<>();

        while(isTrue) {
            System.out.println("Digite o ID do endereço (para sair digite 0)");
            scanner = new Scanner(System.in);
            Integer unidadeID = scanner.nextInt();

            if(unidadeID != 0) {
                Optional<Endereco> endereco = enderecoRepository.findById(unidadeID);
                enderecos.add(endereco.get());
            } else {
                isTrue = false;
            }
        }
        return enderecos;
    }
}
