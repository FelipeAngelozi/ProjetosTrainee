package principal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Gestor {
    public static void main(String[] args) {

        System.out.println("--- Bem vindo ao Caixa 001 TESTE ---");

        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        Compra compra = new Compra();

        compra.setCliente(cliente);
        while (cliente.verificadorCodigo) {
            System.out.print("\nDigite o código do cliente: ");
            cliente.verificadorCodigo = false;
            compra.cliente.setCodigo(sc.nextInt());
            if (!cliente.verificadorCodigo) {
                System.out.println(compra.cliente.toString());
            }
        }


        while (true) {
            Produto produto = new Produto();
            System.out.println("Digite o código do produto (cod 0000 para terminar compra):\n");
            System.out.print("Codigo: ");
            try {
                sc = new Scanner(System.in);
                produto.setCodigo(sc.nextInt());
                if (produto.codigo == 0000) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println("\nCodigo de produto inválido!");

            }
            if (produto.nome != null) {
                compra.produtos.add(produto);
                System.out.println(produto);
            }
        }

       compra.produtos.sort( (produto1 , produto2) -> {
           String produto1nome = produto1.getNome();
           String produto2nome = produto2.getNome();
           return produto1nome.compareTo(produto2nome);
       });
        Recibo recibo = new Recibo();
        recibo.notaFiscal(compra);

        compra.produtos.sort( (produto1, produto2) -> Double.compare(produto1.getValor(), produto2.getValor()));
        recibo.notaFiscal(compra);

        compra.produtos.sort(null);
        recibo.notaFiscal(compra);

        Collections.reverse(compra.produtos);
        recibo.notaFiscal(compra);
    }
}
