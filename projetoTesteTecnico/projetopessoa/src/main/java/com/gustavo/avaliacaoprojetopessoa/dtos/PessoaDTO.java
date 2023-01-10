package com.gustavo.avaliacaoprojetopessoa.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.models.Pessoa;

import java.util.List;

public class PessoaDTO {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("dataNascimento")
    private String dataNascimento;
    @JsonProperty("enderecos")
    private List<Endereco> enderecos;

    public PessoaDTO(Long id, String nome, String dataDeNascimento, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataDeNascimento;
        this.enderecos = enderecos;
    }

    public PessoaDTO() {}
    public static PessoaDTO pessoaDTO(Pessoa pessoa) {
        return new PessoaDTO(pessoa.getId(), pessoa.getNome(), pessoa.getDataNascimento(), pessoa.getEnderecos());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa toPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(this.id);
        pessoa.setNome(this.nome);
        pessoa.setDataNascimento(this.dataNascimento);
        pessoa.setEndereco(this.enderecos);
        return pessoa;
    }
}