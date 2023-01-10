package com.gustavo.avaliacaoprojetopessoa.controllers;

import com.gustavo.avaliacaoprojetopessoa.dtos.PessoaDTO;
import com.gustavo.avaliacaoprojetopessoa.models.Pessoa;
import com.gustavo.avaliacaoprojetopessoa.gateways.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping(value = "/criar")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.criarPessoa(pessoaDTO);
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<Pessoa> updateMyEntity(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.editarPessoa(id, pessoaDTO);
    }

    @GetMapping(value = "/{id}")
    public Pessoa consultarPessoa(@PathVariable Long id) {
        return pessoaService.findById(id);
    }

    @GetMapping(value = "/listar")
    public Iterable<Pessoa> listarPessoas(){
        return pessoaService.listarPessoas();
    }
}
