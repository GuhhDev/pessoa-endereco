package com.gustavo.avaliacaoprojetopessoa.controllers;

import com.gustavo.avaliacaoprojetopessoa.dtos.EnderecoDTO;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.exceptions.FirstPersonException;
import com.gustavo.avaliacaoprojetopessoa.gateways.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping(value = "/criar")
    @ExceptionHandler(FirstPersonException.class)
    public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) throws FirstPersonException {
        return enderecoService.criarEndereco(enderecoDTO);
    }

    @GetMapping(value = "/listar")
    public List<Endereco> listarTodosEnderecos(){
        return enderecoService.listarTodosEnderecos();
    }
}
