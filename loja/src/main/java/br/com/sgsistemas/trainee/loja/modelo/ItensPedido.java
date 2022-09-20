package br.com.sgsistemas.trainee.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItensPedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal precoUnitario;
    private Integer quantidade;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Pedidos pedidos;

    public ItensPedido() {
    }

    public ItensPedido(Integer quantidade, Produto produto, Pedidos pedidos) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = produto.getPreco();
        this.pedidos = pedidos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}
