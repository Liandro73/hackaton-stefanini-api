package com.stefanini.servico;

import com.stefanini.dao.PerfilDao;
import com.stefanini.model.Perfil;
import mockit.Mocked;
import mockit.Tested;
import org.junit.Test;

import static org.junit.Assert.fail;

public class PerfilServicoTest {

    @Tested
    private PerfilServico perfilServico;

    @Tested
    private Perfil perfil;

    @Mocked
    private PerfilDao perfilDao;

    @Test
    public void deveConsultarPerfis() {
        fail("Not yet implemented");
    }

    @Test
    public void deveConsultarPerfilPeloId() {
        fail("Not yet implemented");
    }

    @Test
    public void deveSalvarUmPerfil() {
        fail("Not yet implemented");
    }

    @Test
    public void deveAtualizarUmPerfil() {
        fail("Not yet implemented");
    }

    @Test
    public void deveValidarPerfil() {
        fail("Not yet implemented");
    }

    @Test
    public void deveRemoverUmPerfil() {
        fail("Not yet implemented");
    }

}
