package com.cooperativaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "dividendos")
public class Dividendo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cooperado_id")
    private Cooperado cooperado;
    @Column(nullable = false)
    private String periodo;
    private Double percentualDistribuicao;
    private java.math.BigDecimal valor;
    @Column(nullable = false)
    private String status;
    private java.time.LocalDateTime dataPagamento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cooperado getCooperado() { return cooperado; }
    public void setCooperado(Cooperado cooperado) { this.cooperado = cooperado; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public Double getPercentualDistribuicao() { return percentualDistribuicao; }
    public void setPercentualDistribuicao(Double percentualDistribuicao) { this.percentualDistribuicao = percentualDistribuicao; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.time.LocalDateTime getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(java.time.LocalDateTime dataPagamento) { this.dataPagamento = dataPagamento; }
}
