package com.cooperativaapi.dto;

import jakarta.validation.constraints.*;

public class ProdutoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @NotBlank(message = "unidade não pode estar em branco")
    private String unidade;
    @DecimalMin(value = "0.0", message = "preco bruto não pode ser negativo")
    @NotNull(message = "preco bruto não pode ser nulo")
    private Double precoBruto;
    @DecimalMin(value = "0.0", message = "preco liquido não pode ser negativo")
    @NotNull(message = "preco liquido não pode ser nulo")
    private Double precoLiquido;
    @Min(value = 0, message = "estoque não pode ser negativo")
    @NotNull(message = "estoque não pode ser nulo")
    private Integer estoque;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getUnidade() { return unidade; }
    public void setUnidade(String unidade) { this.unidade = unidade; }
    public Double getPrecoBruto() { return precoBruto; }
    public void setPrecoBruto(Double precoBruto) { this.precoBruto = precoBruto; }
    public Double getPrecoLiquido() { return precoLiquido; }
    public void setPrecoLiquido(Double precoLiquido) { this.precoLiquido = precoLiquido; }
    public Integer getEstoque() { return estoque; }
    public void setEstoque(Integer estoque) { this.estoque = estoque; }
}
