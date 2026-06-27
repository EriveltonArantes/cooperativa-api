package com.cooperativaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "entregaprodutos")
public class EntregaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cooperado_id")
    private Cooperado cooperado;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private java.time.LocalDateTime data;
    private Integer quantidade;
    private Double valorTotal;
    @Column(nullable = false)
    private String qualidade;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cooperado getCooperado() { return cooperado; }
    public void setCooperado(Cooperado cooperado) { this.cooperado = cooperado; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public String getQualidade() { return qualidade; }
    public void setQualidade(String qualidade) { this.qualidade = qualidade; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
