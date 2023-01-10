package com.gustavo.avaliacaoprojetopessoa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;

public class EnderecoDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("logradouro")
    private String logradouro;
    @JsonProperty("numero")
    private Integer numero;
    @JsonProperty("cidade")
    private String cidade;
    @JsonProperty("cep")
    private String cep;
    @JsonProperty("isPrincipal")
    private Boolean isPrincipal;

    public EnderecoDTO(Long id, String logradouro, Integer numero, String cidade, String cep, Boolean isPrincipal) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.isPrincipal = isPrincipal;
    }

    public EnderecoDTO(){}

    public static EnderecoDTO enderecoDTO(Endereco endereco) {
        return new EnderecoDTO(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(), endereco.getCidade(), endereco.getCep(), endereco.getIsPrincipal());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Boolean getIsPrincipal() {
        return isPrincipal;
    }

    public void setPrincipal(Boolean principal) {
        isPrincipal = principal;
    }

    public Endereco toEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(this.id);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setCidade(this.cidade);
        endereco.setCep(this.cep);
        endereco.setIsPrincipal(this.isPrincipal);
        return endereco;
    }
}