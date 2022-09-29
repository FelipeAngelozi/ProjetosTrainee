package br.com.sgsistemas.programa;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.apache.http.client.fluent.Request;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o CEP que deseja consultar:");
        String cep = sc.nextLine();
        System.out.println("Agora, escolha o formato do arquivo:\n" +
                "[1] - XML\n" +
                "[2] - JSON");
        Integer respostaMenu = sc.nextInt();

        FileWriter fileWriter = null;

        switch (respostaMenu) {
            case 1 : {
                XStream xStream= new XStream();
                String url = "https://viacep.com.br/ws/" + cep + "/json/";
                String respostaXML = xStream.toXML(Request.Get(url).execute().returnContent().asString());
                System.out.println(respostaXML);
                break;
            } case 2: {
                Gson gson = new Gson();
                String url = "https://viacep.com.br/ws/" + cep + "/xml/";
                String respostaJSON = gson.toJson(Request.Get(url).execute().returnContent().asString());
                System.out.println(respostaJSON);
                break;
            } default: {
                System.out.println("Comando inválido no menu.");
                break;
            }
        }
      ;
    }
}
