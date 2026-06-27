package com.cooperativaapi.dto;

public class CooperadoResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String municipio;
    private java.time.LocalDateTime dataAdesao;
    private Boolean ativo;
    private Double quota;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
    public java.time.LocalDateTime getDataAdesao() { return dataAdesao; }
    public void setDataAdesao(java.time.LocalDateTime dataAdesao) { this.dataAdesao = dataAdesao; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
    public Double getQuota() { return quota; }
    public void setQuota(Double quota) { this.quota = quota; }
}
