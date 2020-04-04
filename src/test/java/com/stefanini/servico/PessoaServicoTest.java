package com.stefanini.servico;

import com.stefanini.dao.PessoaDao;
import com.stefanini.model.Pessoa;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PessoaServicoTest {

    @Tested
    private PessoaServico pessoaServico;

    @Tested
    private Pessoa pessoa;

    @Mocked
    private PessoaDao pessoaDao;

    @Test
    public void deveConsultarPessoas() {
        fail("Not yet implemented");
    }

    @Test
    public void deveConsultarPessoaPeloId() {
        fail("Not yet implemented");
    }

    @Test
    public void deveSalvarUmaPessoa() {
        fail("Not yet implemented");
    }

    @Test
    public void deveAtualizarUmaPessoa() {
        fail("Not yet implemented");
    }

    @Test
    public void deveValidarPessoa() {
        fail("Not yet implemented");
    }

    @Test
    public void deveRemoverUmaPessoa() {
        fail("Not yet implemented");
    }
}
