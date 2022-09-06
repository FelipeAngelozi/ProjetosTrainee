package principal;

public class Recibo {


    public void notaFiscal(Compra compra) {
        System.out.println("\n-------- Lista de compras ---------");
        System.out.println("Cliente: " + compra.cliente.getNome());
        System.out.println("Data: " + compra.getData());
        System.out.println("-----------------------------------");

        compra.produtos.forEach( produto -> {
            System.out.println(produto);
            compra.total += produto.getValor();
        });

        System.out.println("-----------------------------------");
        System.out.printf("Total da compra: R$ %.2f%n", compra.getTotal());
        System.out.println("-----------------------------------");
    }
}
