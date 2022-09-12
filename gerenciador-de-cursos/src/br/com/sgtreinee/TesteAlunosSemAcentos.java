package br.com.sgtreinee;

import java.util.HashSet;
import java.util.Set;

public class TesteAlunosSemAcentos {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();

        alunos.add("Paulo");
        alunos.add("Alberto");
        alunos.add("Pedro");
        alunos.add("Nico");

        alunos.forEach(aluno -> System.out.println(aluno));

        System.out.println(alunos.size());

        alunos.add("Paulo"); //adicionar membros repetidos compila, mas nao repete no conjunto


        System.out.println(alunos.size());
    }
}
