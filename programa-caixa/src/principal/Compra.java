package principal;

import java.util.ArrayList;
import java.util.Date;

public class Compra {

    Date data;
    Cliente cliente;
    ArrayList<Produto> produtos;
    double total;

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Compra() {
        this.total = 0;
        this.data = new Date();
        produtos = new ArrayList<Produto>();
    }

    public void getProdutosLista() {
        for (Produto produto : produtos) {
            this.total += produto.getValor();
            System.out.println(produto.toString());
        }
    }

    public double getTotal() {
        return this.total;
    }
}
