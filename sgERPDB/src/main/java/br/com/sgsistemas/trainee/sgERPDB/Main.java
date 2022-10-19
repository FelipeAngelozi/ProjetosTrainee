package br.com.sgsistemas.trainee.sgERPDB;

import br.com.sgsistemas.trainee.sgERPDB.DAO.*;
import br.com.sgsistemas.trainee.sgERPDB.model.*;
import br.com.sgsistemas.trainee.sgERPDB.util.JPAUtil;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();



        UF uf = new UF();
        UFDAO ufDAO = new UFDAO(entityManager);

//        uf.setSigla("PR");
//        uf.setDescricao("Paraná");
//        ufDAO.salvarUF(uf);

        Cidade cidade = new Cidade();
        CidadeDAO cidadeDAO = new CidadeDAO(entityManager);

//        cidade.setCodigo("1");
//        cidade.setNome("Maringá");
//        cidade.setUf(uf);
//        cidadeDAO.salvarCidade(cidade);

        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO(entityManager);

        // ################################# BUSCA E ATUALIZACAO #################################
//        endereco = enderecoDAO.buscarEndereco(3);
//        endereco.setLogradouro("Rua Campos Sales");
//        enderecoDAO.atulizarEndereco(endereco);

       // enderecoDAO.salvarEndereco(endereco);


        Cliente cliente = new Cliente();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);

//        cliente.setNome("Felipe Angelozi");
//        cliente.setCpf("123.456.789-10");
//        cliente.setEndereco(endereco);
//        try {
//            cliente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("13/03/1998"));
//        } catch (Exception e) {
//            System.out.println("Erro na data");
//        }
//        clienteDAO.salvarCliente(cliente);

        // ################################# REMOCAO #################################
//        cliente = clienteDAO.buscarCliente(1);
//        clienteDAO.removerCliente(cliente);

        // ################################# LISTAGEM DE TODOS OS CLIENTES #################################
//        List<Cliente> listaCliente = clienteDAO.listarCliente();
//        listaCliente.forEach(clientelista -> System.out.println(clientelista));

        // ################################# BUSCA DO NOME POR ID #################################
       // System.out.println(clienteDAO.buscarNomeClientePorId(4));

        //################################# BUSCA DE CLIENTE POR ENDERCO #################################
//        List<Cliente> listaCliente = clienteDAO.buscarPorEndereco(3);
//        listaCliente.forEach(cliente1 -> System.out.println(cliente1));


        entityManager.getTransaction().commit();
        entityManager.close();





    }
}