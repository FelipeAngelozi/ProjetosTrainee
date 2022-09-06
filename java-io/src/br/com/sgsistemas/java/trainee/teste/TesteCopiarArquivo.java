package br.com.sgsistemas.java.trainee.teste;

import java.io.*;

public class TesteCopiarArquivo {
    public static void main(String[] args) throws IOException {

        //entrada
        FileInputStream fileInputStream = new FileInputStream("lorem ipsum");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //saida
        FileOutputStream fileOutputStream = new FileOutputStream("lorem ipsum2");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        //copia

        String loremIpsum = bufferedReader.readLine();

        while (loremIpsum != null) {
            bufferedWriter.write(loremIpsum);
            bufferedWriter.newLine();
            loremIpsum = bufferedReader.readLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
