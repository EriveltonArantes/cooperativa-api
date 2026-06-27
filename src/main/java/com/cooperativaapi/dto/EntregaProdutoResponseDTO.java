package com.cooperativaapi.dto;

public class EntregaProdutoResponseDTO {

    private Long id;
    private Long cooperadoId;
    private Long produtoId;
    private java.time.LocalDateTime data;
    private Integer quantidade;
    private Double valorTotal;
    private String qualidade;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCooperadoId() { return cooperadoId; }
    public void setCooperadoId(Long cooperadoId) { this.cooperadoId = cooperadoId; }
    public Long getProdutoId() { return produtoId; }
    public void setProdutoId(Long produtoId) { this.produtoId = produtoId; }
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
