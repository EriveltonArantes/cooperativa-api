package com.cooperativaapi.dto;

import jakarta.validation.constraints.*;

public class EntregaProdutoRequestDTO {

    @NotNull(message = "CooperadoId é obrigatório")
    @Positive(message = "CooperadoId deve ser um ID válido (positivo)")
    private Long cooperadoId;
    @NotNull(message = "ProdutoId é obrigatório")
    @Positive(message = "ProdutoId deve ser um ID válido (positivo)")
    private Long produtoId;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @Min(value = 0, message = "quantidade não pode ser negativo")
    @NotNull(message = "quantidade não pode ser nulo")
    private Integer quantidade;
    @DecimalMin(value = "0.0", message = "valor total não pode ser negativo")
    @NotNull(message = "valor total não pode ser nulo")
    private Double valorTotal;
    @NotBlank(message = "qualidade não pode estar em branco")
    private String qualidade;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
