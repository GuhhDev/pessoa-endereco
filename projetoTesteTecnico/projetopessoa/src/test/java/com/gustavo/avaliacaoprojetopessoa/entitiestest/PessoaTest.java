package com.gustavo.avaliacaoprojetopessoa.entitiestest;

import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import com.gustavo.avaliacaoprojetopessoa.models.Pessoa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaTest {
    @Test
    public void testarGettersESetters() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Gustavo Batista");
        pessoa.setDataNascimento("05/09/2000");

        //cria uma lista de Enderecos
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco(1L, "rua teste", 1, "Maringá", "12345-678", false));
        pessoa.setEndereco(enderecos);

        //testando os getters
        assertEquals(1L, (long)pessoa.getId());
        assertEquals("Gustavo Batista", pessoa.getNome(), "Verificado nome...");
        assertEquals("05/09/2000", pessoa.getDataNascimento(), "Verificado data de nascimento...");
        assertEquals(enderecos, pessoa.getEnderecos(), "Verificado endereços...");
    }
}
