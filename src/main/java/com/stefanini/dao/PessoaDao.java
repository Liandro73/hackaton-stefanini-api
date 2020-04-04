package com.stefanini.dao;

import com.stefanini.dao.abstracao.GenericDao;
import com.stefanini.model.Pessoa;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

/**
 * O Unico objetivo da Dao 
 * @author joaopedromilhome
 *
 */
public class PessoaDao extends GenericDao<Pessoa, Long> {

	public PessoaDao() {
		super(Pessoa.class);
	}

	/**
	 * Efetuando busca de Pessoa por email
	 * @param email
	 * @return
	 */
	public Optional<Pessoa> buscarPessoaPorEmail(String email){
		TypedQuery<Pessoa> q2 =
				entityManager.createQuery(" select p from Pessoa p where p.email=:email", Pessoa.class);
		q2.setParameter("email", email);
		return q2.getResultStream().findFirst();
	}

	/**
	 * Efetuando busca de Pessoa ordenando pelo nome
	 * @param
	 * @return
	 */
	@Override
	public Optional<List<Pessoa>> getList() {
		return Optional.of(getEntityManager().createQuery(
				"select distinct p from Pessoa p left join fetch p.enderecos left join fetch p.perfils " +
						"ORDER BY p.nome", Pessoa.class).getResultList());
	}

}
