package Principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Tabela1 {

    ArrayList<String> listaTabela1 = new ArrayList<String>();

    public Tabela1() {
        try {

            Scanner scanner = new Scanner(new File("Tabela_4_3_10.txt"), "windows-1252");

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                Scanner linhaScanner = new Scanner(linha);


                linhaScanner.useDelimiter("\\|");


                Integer codigo = linhaScanner.nextInt();
                String descricao = linhaScanner.next();
                String DTinicio = linhaScanner.next();
                String DTfim = linhaScanner.next();
                String NCM = linhaScanner.next();
                String NCM_EX = linhaScanner.next();
                String EX_IPI = linhaScanner.next();
                double aliq_pis = linhaScanner.nextDouble();
                double aliq_cofin = linhaScanner.nextDouble();

                String itemLista = String.format(Locale.GERMAN, "Cód           : %04d%n" +
                        "Descrição     : %s%n" +
                        "DTInício      : %S%n" +
                        "DTFim         : %s%n" +
                        "NCM           : %s%n" +
                        "NCM_EX        : %s%n" +
                        "EX_IPI        : %s%n" +
                        "Alíquota PIS  : %.2f%n" +
                        "Alíquota Cofin: %.2f%n", codigo, descricao, DTinicio, DTfim, NCM , NCM_EX, EX_IPI, aliq_pis , aliq_cofin);

                this.listaTabela1.add(itemLista);
            }

        } catch (FileNotFoundException exception) {
            System.out.println("Arquivo não encontrado.");
        }
    }

    public void imprimirLista() {
        this.listaTabela1.forEach(String -> System.out.println(String));
    }
}





