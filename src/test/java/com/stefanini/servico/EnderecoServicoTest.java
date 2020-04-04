package com.stefanini.servico;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.fail;

public class EnderecoServicoTest {

    @Tested
    private EnderecoServico enderecoServico;

    @Tested
    private Endereco endereco;

    @Mocked
    private EnderecoDao enderecoDao;

    @Test
    public void deveConsultarEnderecos() {
        fail("Not yet implemented");
    }

    @Test
    public void deveConsultarEnderecoPeloId() {
        fail("Not yet implemented");
    }

    @Test
    public void deveSalvarUmEndereco() {
        fail("Not yet implemented");
    }

    @Test
    public void deveAtualizarUmEndereco() {
        fail("Not yet implemented");
    }

    @Test
    public void deveRemoverUmEndereco() {
        fail("Not yet implemented");
    }
}
