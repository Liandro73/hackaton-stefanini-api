package com.stefanini.servico;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ViaCepServicoTest {

    @Tested
    private ViaCepServico viaCepServico;

    @Tested
    private Endereco endereco;

    @Mocked
    private EnderecoDao enderecoDao;

    @Test
    public void deveConverterCep() {
        fail("Not yet implemented");
    }

    @Test
    public void deveBurcarCep() {
        fail("Not yet implemented");
    }

}
