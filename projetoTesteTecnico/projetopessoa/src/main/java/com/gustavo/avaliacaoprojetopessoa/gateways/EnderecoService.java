package com.gustavo.avaliacaoprojetopessoa.gateways;

import com.gustavo.avaliacaoprojetopessoa.dtos.EnderecoDTO;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.exceptions.FirstPersonException;
import com.gustavo.avaliacaoprojetopessoa.repositories.EnderecoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public ResponseEntity<Endereco> criarEndereco(@Validated EnderecoDTO enderecoDTO) throws FirstPersonException {
        Endereco enderecoNovo = new Endereco();

        enderecoNovo.setCep(enderecoDTO.getCep());
        enderecoNovo.setCidade(enderecoDTO.getCidade());
        enderecoNovo.setIsPrincipal(enderecoDTO.getIsPrincipal());
        enderecoNovo.setLogradouro(enderecoDTO.getLogradouro());
        enderecoNovo.setNumero(enderecoDTO.getNumero());

        List<Endereco> lista = enderecoRepository.findAll();

        for (Endereco endereco : lista) {
            if (endereco.getIsPrincipal() == true && enderecoNovo.getIsPrincipal() == true || enderecoDTO.getIsPrincipal() == null) {
                throw new FirstPersonException();
            }
            enderecoNovo.setIsPrincipal(enderecoDTO.getIsPrincipal());
        }

        enderecoRepository.save(enderecoNovo);
        return new ResponseEntity<>(enderecoNovo, HttpStatus.CREATED);
    }

    public List<Endereco> listarTodosEnderecos() {
        return enderecoRepository.findAll();
    }
}