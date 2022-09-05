package programa;

import java.util.Scanner;

public class Escola {

    public static void main(String[] args) {

        String nome = "programa.Escola SG Sistemas";
        Endereco endereco;
        Scanner sc = new Scanner(System.in);

        System.out.printf("*** Bem vindo ao sistema da %s *** %n", nome);
        Endereco escolaEndereco = new Endereco("Maringá", "Paraná");
        System.out.printf("Digite informações sobre o endereço da escola: %n");
        System.out.print("Logradouro: ");
        escolaEndereco.setLogradouro(sc.nextLine());
        System.out.print("Número: ");
        escolaEndereco.setNumero(sc.nextLine());
        System.out.print("Complemento: ");
        escolaEndereco.setComplemento(sc.nextLine());
        System.out.print("CEP: ");
        escolaEndereco.setCEP(sc.nextLine());

        //aluno1 da turma
        Aluno aluno1 = new Aluno();
        aluno1.setNome("João");
        aluno1.setCpf("Teste CPF");
        aluno1.setIdade(14);
        aluno1.setEndereco(new Endereco("Sarandi", "Paraná"));

        //aluno2 da turma
        Aluno aluno2 = new Aluno();
        aluno2.setNome("Maria");
        aluno2.setCpf("Teste CPF222");
        aluno2.setIdade(17);
        aluno2.setEndereco(new Endereco("Maringá" , "Paraná"));

        //aluno3 da turma
        Aluno aluno3 = new Aluno();
        aluno3.setNome("Felipe");
        aluno3.setCpf("132.123.567-09");
        aluno3.setIdade(24);
        aluno3.setEndereco(new Endereco("Iguatemi", "Paraná"));

        //turma
        Turma turma = new Turma();
        turma.setSerie(5);
        turma.listaAlunos.add(aluno1);
        turma.listaAlunos.add(aluno2);
        turma.listaAlunos.add(aluno3);


        System.out.printf("%nTurma %s de %s :%n", turma.getSerie(), turma.getAnoLetivo());
        for(Aluno alunos : turma.listaAlunos ) {
            System.out.println(alunos);
        }






    }


}
