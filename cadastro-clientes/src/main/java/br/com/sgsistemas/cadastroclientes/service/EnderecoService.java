package br.com.sgsistemas.cadastroclientes.service;

import br.com.sgsistemas.cadastroclientes.model.Cliente;
import br.com.sgsistemas.cadastroclientes.model.Endereco;
import br.com.sgsistemas.cadastroclientes.repository.ClienteRepository;
import br.com.sgsistemas.cadastroclientes.repository.EnderecoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;

    public EnderecoService(EnderecoRepository enderecoRepository, ClienteRepository clienteRepository) {
        this.enderecoRepository = enderecoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void salvarEndereço(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Logradouro:");
        String logradouroEndereco = scanner.nextLine();
        System.out.println("Numero:");
        String numeroEndereco = scanner.nextLine();
        System.out.println("Bairro");
        String bairroEndereco = scanner.nextLine();
        System.out.println("CEP");
        String cepEndereco = scanner.nextLine();
        System.out.println("Cidade:");
        String cidadeEndereco = scanner.nextLine();
        System.out.println("ID do cliente:");
        Integer clienteID = scanner.nextInt();
        Cliente cliente = clienteRepository.findById(clienteID).get();

        Endereco endereco = new Endereco();
        endereco.setLogradouro(logradouroEndereco);
        endereco.setNumero(numeroEndereco);
        endereco.setBairro(bairroEndereco);
        endereco.setCep(cepEndereco);
        endereco.setCidade(cidadeEndereco);
        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);

    }

    public void atualizarEndereco(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID do endereço que deseja alterar:");
        Integer enderecoID = scanner.nextInt();
        System.out.println("Logradouro:");
        String logradouroEndereco = scanner.nextLine();
        System.out.println("Numero:");
        String numeroEndereco = scanner.nextLine();
        System.out.println("Bairro");
        String bairroEndereco = scanner.nextLine();
        System.out.println("CEP");
        String cepEndereco = scanner.nextLine();
        System.out.println("Cidade:");
        String cidadeEndereco = scanner.nextLine();
        System.out.println("ID do cliente:");
        Integer clienteID = scanner.nextInt();
        Cliente cliente = clienteRepository.findById(clienteID).get();
        Endereco endereco = new Endereco();
        endereco.setId(enderecoID);
        endereco.setLogradouro(logradouroEndereco);
        endereco.setNumero(numeroEndereco);
        endereco.setBairro(bairroEndereco);
        endereco.setCep(cepEndereco);
        endereco.setCidade(cidadeEndereco);
        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);
    }

    public void visualizarEnderecoPorPagina(Scanner scanner) {
        System.out.println("Digite a pagina que deseja visualizar");
        Integer pagina = scanner.nextInt();

        Pageable pageable = PageRequest.of(pagina, 10, Sort.by(Sort.Direction.ASC, "cidade"));
        Page<Endereco> enderecoPage = enderecoRepository.findAll(pageable);

        System.out.println("Página: " + enderecoPage.getNumber());
        enderecoPage.forEach(endereco -> System.out.println(endereco));
    }

    public void visualizarEndereco() {
        Iterable<Endereco> enderecos = enderecoRepository.findAll();
        enderecos.forEach(endereco -> System.out.println(endereco));
    }

    public void excluirEnderecoPorID(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Digite o ID do endereço que deseja remover:");
        Integer enderecoID = scanner.nextInt();
        enderecoRepository.deleteById(enderecoID);
    }

    public void excluirTodosEndereco(Scanner scanner) {
        scanner = new Scanner(System.in);
        System.out.println("Voce está prestes a excluir TODOS os enderecos. Deseja continuar? (S/N)");
        String resposta = scanner.nextLine();
        resposta = resposta.toLowerCase();
        if (resposta.equals("s")) {
            enderecoRepository.deleteAll();
        }
    }
}
