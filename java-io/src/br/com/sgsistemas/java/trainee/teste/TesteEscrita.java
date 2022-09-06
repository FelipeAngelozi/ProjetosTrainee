package br.com.sgsistemas.java.trainee.teste;

import java.io.*;

public class TesteEscrita {
    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("saidateste.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        bufferedWriter.write("TESTE SAIDA DE DADOS JAVA");
        bufferedWriter.newLine();
        bufferedWriter.write("TESTE");
        bufferedWriter.close();


    }
}
