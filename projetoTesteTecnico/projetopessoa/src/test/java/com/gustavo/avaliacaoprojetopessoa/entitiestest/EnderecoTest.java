package com.gustavo.avaliacaoprojetopessoa.entitiestest;

import com.gustavo.avaliacaoprojetopessoa.models.Endereco;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoTest {
    @Test
    public void testarGettersESetters() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setLogradouro("rua irma tal");
        endereco.setCep("12345-678");
        endereco.setNumero(4);
        endereco.setCidade("taguatinga");

        //testando os getters
        assertEquals(1L, (long)endereco.getId());
        assertEquals("rua irma tal", endereco.getLogradouro(), "Verificado logradouro...");
        assertEquals("12345-678", endereco.getCep(), "Verificado cep...");
        assertEquals(4, endereco.getNumero(), "Verificado numero...");
        assertEquals("taguatinga", endereco.getCidade(), "Verificado cidade...");
    }
}
