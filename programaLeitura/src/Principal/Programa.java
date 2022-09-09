// melhorar classes e rebaixar os txts novamente

package Principal;


import sun.nio.fs.GnomeFileTypeDetector;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabelas tabelas = new Tabelas();
        String nomeTabela = "";

        while (true) {

            System.out.println("--- Qual tabela deseja visualizar ---\n" +
                    "[1] - Tabela_4_3_10\n" +
                    "[2] - Tabela_4_3_12\n" +
                    "[3] - Tabela_4_3_13\n" +
                    "[4] - Tabela_4_3_14\n" +
                    "[5] - Tabela_4_3_15\n" +
                    "[6] - Tabela_4_3_15\n" +
                    "[0] - Sair\n");

            int respostaMenu = 0;
            respostaMenu = sc.nextInt();

            switch (respostaMenu) {
                case 1: {
                    nomeTabela = "Tabela_4_3_10.txt";
                    break;
                }
                case 2: {
                    nomeTabela = "Tabela_4_3_12.txt";
                    break;
                }
                case 3: {
                    nomeTabela = "Tabela_4_3_13.txt";
                    break;
                }
                case 4: {
                    nomeTabela = "Tabela_4_3_14.txt";
                    break;
                }
                case 5: {
                    nomeTabela = "Tabela_4_3_15.txt";
                    break;
                }
                case 6: {
                    nomeTabela = "Tabela_4_3_16.txt";
                    break;
                }
                default: {
                    break;
                }

            }

            if (respostaMenu == 0) {
                break;
            }

            tabelas.popularLista(nomeTabela);
            tabelas.imprimirLista();
        }


    }
}
