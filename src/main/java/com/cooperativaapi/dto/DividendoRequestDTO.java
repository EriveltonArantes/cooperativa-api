package com.cooperativaapi.dto;

import jakarta.validation.constraints.*;

public class DividendoRequestDTO {

    @NotNull(message = "CooperadoId é obrigatório")
    @Positive(message = "CooperadoId deve ser um ID válido (positivo)")
    private Long cooperadoId;
    @NotBlank(message = "periodo não pode estar em branco")
    private String periodo;
    @NotNull(message = "percentual distribuicao não pode ser nulo")
    private Double percentualDistribuicao;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @NotNull(message = "data pagamento não pode ser nulo")
    private java.time.LocalDateTime dataPagamento;

    public Long getCooperadoId() { return cooperadoId; }
    public void setCooperadoId(Long cooperadoId) { this.cooperadoId = cooperadoId; }
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
