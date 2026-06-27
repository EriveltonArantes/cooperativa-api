package com.cooperativaapi.dto;

public class ProdutoResponseDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private String unidade;
    private Double precoBruto;
    private Double precoLiquido;
    private Integer estoque;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
