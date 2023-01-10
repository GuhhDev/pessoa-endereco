package com.gustavo.avaliacaoprojetopessoa.controllerstest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gustavo.avaliacaoprojetopessoa.controllers.EnderecoController;
import com.gustavo.avaliacaoprojetopessoa.dtos.EnderecoDTO;
import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.gateways.EnderecoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(EnderecoController.class)
public class EnderecoControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EnderecoService enderecoService;

    private Endereco endereco;

    @Before
    public void setup() {
        endereco = new Endereco(1L, "rua teste", 1, "Maringá", "12345-678", false);
    }
    @Test
    public void criarEnderecoTest() throws Exception {
        EnderecoDTO enderecoDTO = new EnderecoDTO(1L, "rua teste", 1, "Maringá", "12345-678", false);

        when(enderecoService.criarEndereco(enderecoDTO))
                .thenReturn(new ResponseEntity<>(endereco, HttpStatus.CREATED));

        mvc.perform(MockMvcRequestBuilders.post("/endereco/criar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(enderecoDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testListarTodosEnderecos() throws Exception {
        //Arrange
        Endereco endereco1 = new Endereco(1L, "rua teste", 1, "Maringá", "12345-678", false);
        Endereco endereco2 = new Endereco(1L, "rua teste dois", 1, "Maringá", "12345-678", false);
        List<Endereco> enderecos = Arrays.asList(endereco1, endereco2);
        Mockito.when(enderecoService.listarTodosEnderecos()).thenReturn(enderecos);

        mvc.perform(get("/endereco/listar").contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk());
    }
}
