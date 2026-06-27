package com.cooperativaapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cooperados")
public class Cooperado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
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
