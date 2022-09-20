package br.com.sgsistemas.trainee.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Pedidos")
public class Pedidos {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataPedido = LocalDate.now();
    @ManyToOne
    private Clientes clientes;
    private BigDecimal valorTotal;
    @OneToMany (mappedBy = "pedidos")
    private List<ItensPedido> listaItem = new ArrayList<>();

    public Pedidos() {
    }

    public Pedidos(Clientes clientes) {
        this.clientes = clientes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void adicionarItem (ItensPedido itensPedido){
        itensPedido.setPedidos(this);
        this.listaItem.add(itensPedido);
    }
}
