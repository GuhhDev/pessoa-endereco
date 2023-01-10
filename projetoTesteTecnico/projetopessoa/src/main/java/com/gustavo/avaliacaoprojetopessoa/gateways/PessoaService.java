package com.gustavo.avaliacaoprojetopessoa.gateways;

import com.gustavo.avaliacaoprojetopessoa.dtos.PessoaDTO;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.models.Pessoa;
import com.gustavo.avaliacaoprojetopessoa.repositories.PessoaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    public ResponseEntity<Pessoa> criarPessoa(@Validated PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();

        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());

        List<Endereco> enderecos = new ArrayList<>();
        enderecos = pessoaDTO.getEnderecos();

        pessoa.setEndereco(enderecos);
        pessoaRepository.save(pessoa);

        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

    public ResponseEntity<Pessoa> editarPessoa(Long id, @Validated PessoaDTO pessoaDTO) {
        Pessoa pessoaEditada = pessoaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        pessoaEditada.setNome(pessoaDTO.getNome());
        pessoaEditada.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoaEditada.setEndereco(pessoaDTO.getEnderecos());

        pessoaRepository.save(pessoaEditada);

        return new ResponseEntity<>(pessoaEditada, HttpStatus.CREATED);
    }
}
