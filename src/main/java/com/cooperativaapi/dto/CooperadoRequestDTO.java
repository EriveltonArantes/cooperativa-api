package com.cooperativaapi.dto;

import jakarta.validation.constraints.*;

public class CooperadoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "municipio não pode estar em branco")
    private String municipio;
    @NotNull(message = "data adesao não pode ser nulo")
    private java.time.LocalDateTime dataAdesao;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;
    @NotNull(message = "quota não pode ser nulo")
    private Double quota;

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
