package br.com.alura;

import java.util.Iterator;

public class TestaCursoComAluno {
    public static void main(String[] args) {

        Curso javaColecoes = new Curso("Dominando as coleções do Java",
                "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

        Aluno aluno1 = new Aluno("Cassiano", 123);
        Aluno aluno2 = new Aluno("Leonardo H.", 124);
        Aluno aluno3 = new Aluno("Felipe", 125);
        Aluno aluno4 = new Aluno("Aleph", 126);
        Aluno aluno5 = new Aluno("Leonardo P.", 127);

        javaColecoes.matricula(aluno1);
        javaColecoes.matricula(aluno2);
        javaColecoes.matricula(aluno3);
        javaColecoes.matricula(aluno4);
        javaColecoes.matricula(aluno5);

        System.out.println("Alunos matriculados:");
//     uso do map

        System.out.println(javaColecoes.buscarMatriculado(124));

        //teste de uso do iterator
//        Iterator<Aluno> iterator = javaColecoes.getAlunos().iterator();
//
//        while(iterator.hasNext()) {
//            Aluno proximo = iterator.next();
//            System.out.println(proximo);
//        }

        //javaColecoes.getAlunos().forEach(aluno -> System.out.println(aluno));

        //System.out.println(aluno1.hashCode() == aluno2.hashCode());


    }
}
