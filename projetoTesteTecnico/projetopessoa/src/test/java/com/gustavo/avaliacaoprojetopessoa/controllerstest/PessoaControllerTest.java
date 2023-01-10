package com.gustavo.avaliacaoprojetopessoa.controllerstest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavo.avaliacaoprojetopessoa.controllers.PessoaController;
import com.gustavo.avaliacaoprojetopessoa.dtos.PessoaDTO;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.models.Pessoa;
import com.gustavo.avaliacaoprojetopessoa.gateways.PessoaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PessoaService pessoaService;

    private List<Endereco> enderecos;
    private PessoaDTO pessoaDTO;
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @Before
    public void setup() {
        enderecos = new ArrayList<>();
        enderecos.add(new Endereco(1L, "rua teste", 1, "Maringá", "12345-678", false));

        pessoaDTO = new PessoaDTO(1L, "Gustavo Batista", "01/01/2000", enderecos);
        pessoa1 = new Pessoa("Gustavo Batista", "01/01/2000", enderecos);
        pessoa2 = new Pessoa("Carol", "01/01/2002", enderecos);
    }

    @Test
    public void criarPessoaTest() throws Exception {

        when(pessoaService.criarPessoa(pessoaDTO))
                .thenReturn(new ResponseEntity<>(pessoa1, HttpStatus.CREATED));

        mvc.perform(MockMvcRequestBuilders.post("/pessoa/criar")
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(pessoaDTO)))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void editarPessoaTest() throws Exception {

        given(pessoaService.editarPessoa(1L, pessoaDTO)).willReturn(new ResponseEntity<>(pessoa1, HttpStatus.OK));
    }

    @Test
    public void consultarPessoaTest() throws Exception {

        given(pessoaService.findById(1L)).willReturn(pessoa1);
    }

    @Test
    public void listarPessoasTest() throws Exception {

        List<Pessoa> pessoas = pessoaService.listarPessoas();

        given(pessoaService.listarPessoas()).willReturn(pessoas);
    }
}
