package com.stefanini.servico;

import com.stefanini.dao.EnderecoDao;
import com.stefanini.model.Endereco;

import javax.ejb.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.io.Serializable;
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
public class EnderecoServico implements Serializable {

    @Inject
    private EnderecoDao dao;

    @Inject
    private ViaCepServico cepServico;

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Endereco salvar(@Valid Endereco endereco) {
        return dao.salvar(cepServico.converterCep(endereco));
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Endereco atualizar(@Valid Endereco endereco) {
        return dao.atualizar(endereco);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remover(Long id) {
        dao.remover(id);
    }

    public Optional<List<Endereco>> getList() {
        return dao.getList();
    }

    public Optional<Endereco> encontrar(Long id) {
        return dao.encontrar(id);
    }

}
