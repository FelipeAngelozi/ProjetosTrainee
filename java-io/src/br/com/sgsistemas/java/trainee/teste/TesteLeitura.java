package br.com.sgsistemas.java.trainee.teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeitura {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("lorem ipsum");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String loremIpsum = bufferedReader.readLine();

        while (loremIpsum != null) {
            System.out.println(loremIpsum);
            loremIpsum = bufferedReader.readLine();
        }

        bufferedReader.close();


    }
}
