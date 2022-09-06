package br.com.sgsistemas.java.trainee.teste;

import java.io.*;

public class TesteCopiarArquivo {
    public static void main(String[] args) throws IOException {

        //entrada
        InputStream fileInputStream = System.in; //new FileInputStream("lorem ipsum");
        Reader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //saida
        OutputStream fileOutputStream = System.out; //new FileOutputStream("lorem ipsum2");
        Writer outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        //copia

        String loremIpsum = bufferedReader.readLine();

        while (loremIpsum != null && !loremIpsum.isEmpty()) {
            bufferedWriter.write(loremIpsum);
            bufferedWriter.newLine();
            loremIpsum = bufferedReader.readLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
