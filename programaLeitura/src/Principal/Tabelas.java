package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Tabelas {

    ArrayList<String> listaTabela = new ArrayList<String>();

    public void popularLista(String tabela) {
        try {

            Scanner scanner = new Scanner(new File(tabela), "windows-1252");

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                Scanner linhaScanner = new Scanner(linha);
                linhaScanner.useDelimiter("\\|");
                String codigo = linhaScanner.next();
                String descricao = linhaScanner.next();
                String DTinicio = linhaScanner.next();
                String DTfim = linhaScanner.next();
                String NCM = linhaScanner.next();
                String NCM_EX = linhaScanner.next();
                String EX_IPI = linhaScanner.next();
                String aliq_pis = linhaScanner.next();
                String aliq_cofin = linhaScanner.next();

                String itemLista = String.format(Locale.GERMAN, "Cód           : %s%n" +
                        "Descrição     : %s%n" +
                        "DTInício      : %S%n" +
                        "DTFim         : %s%n" +
                        "NCM           : %s%n" +
                        "NCM_EX        : %s%n" +
                        "EX_IPI        : %s%n" +
                        "Alíquota PIS  : %s%n" +
                        "Alíquota Cofin: %s%n", codigo, descricao, DTinicio, DTfim, NCM , NCM_EX, EX_IPI, aliq_pis , aliq_cofin);

                this.listaTabela.add(itemLista);
            }

        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public void imprimirLista() {
        this.listaTabela.forEach(String -> System.out.println(String));
    }
}





