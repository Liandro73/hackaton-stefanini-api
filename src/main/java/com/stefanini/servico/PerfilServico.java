package com.stefanini.servico;

import com.stefanini.dao.PerfilDao;
import com.stefanini.exception.NegocioException;
import com.stefanini.model.Perfil;

import javax.ejb.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Classe de servico, as regras de negocio devem estar nessa classe
 *
 * @author joaopedromilhome
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PerfilServico implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private PerfilDao dao;

    @Inject
    private PessoaPerfilServico pessoaPerfilServico;

    /**
     * Salvar os dados de uma Perfil
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Perfil salvar(@Valid Perfil perfil) {
        perfil.setDataHoraInclusao(LocalDateTime.now());
        return dao.salvar(perfil);
    }

    /**
     * Validando se existe perfil com nome
     */
    public Boolean validarPerfil(@Valid Perfil perfil) {
        Optional<Perfil> perfil1 = dao.buscarPerfilPorNome(perfil.getNome());
        return perfil1.isEmpty();
    }

    /**
     * Atualizar o dados de uma perfil
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Perfil atualizar(@Valid Perfil perfil) {
		perfil.setDataHoraAlteracao(LocalDateTime.now());
        return dao.atualizar(perfil);
    }

    /**
     * Remover uma perfil pelo id
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remover(@Valid Long id) throws NegocioException {
        if (pessoaPerfilServico.buscarPessoaPerfil(null, id).count() == 0) {
            dao.remover(id);
            return;
        }
        throw new NegocioException("Não foi possivel remover o perfil");
    }

    /**
     * Buscar uma lista de Perfil
     */
    public Optional<List<Perfil>> getList() {
        return dao.getList();
    }

    /**
     * Buscar uma Perfil pelo ID
     */
//	@Override
    public Optional<Perfil> encontrar(Long id) {
        return dao.encontrar(id);
    }

}
