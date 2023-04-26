package br.com.loja.modelo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "valor_total")
    private BigDecimal valorTotal = BigDecimal.ZERO;
    private LocalDate data = LocalDate.now();
    @OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<>();
    @ManyToOne
    private Cliente cliente;

    public Pedido(){

    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);
        this.valorTotal = item.getValorTotal();
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
