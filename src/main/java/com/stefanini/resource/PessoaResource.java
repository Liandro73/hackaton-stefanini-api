package com.stefanini.resource;

import com.stefanini.dto.ErroDto;
import com.stefanini.model.Pessoa;
import com.stefanini.servico.PessoaServico;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Optional;

@Path("pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaResource {
	/**
	 * Classe de servico da Pessoa
	 */
	@Inject
	private PessoaServico pessoaServico;
	/**
	 *
	 */
	@Context
	private UriInfo uriInfo;


	/**
	 *
	 * @return
	 */
	@GET
	public Response obterPessoas() {
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
		Optional<List<Pessoa>> listPessoa = pessoaServico.getList();
		return listPessoa.map(pessoas -> Response.ok(pessoas).build()).orElseGet(() -> Response.status(Status.NOT_FOUND).build());

	}

	/**
	 *
	 * @param pessoa
	 * @return
	 */
	@POST
	public Response adicionarPessoa(@Valid Pessoa pessoa) {
		if(pessoaServico.validarPessoa(pessoa)){
			return Response.ok(pessoaServico.salvar(pessoa)).build();
		}
		return Response.status(Status.METHOD_NOT_ALLOWED).entity(new ErroDto("email","email já existe", pessoa.getEmail())).build();
	}


	/**
	 *
	 * @param pessoa
	 * @return
	 */
	@PUT
	public Response atualizarPessoa(@Valid Pessoa pessoa) {
		return Response.ok(pessoaServico.atualizar(pessoa)).build();
	}


	/**
	 *
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("{id}")
	public Response deletarPessoa(@PathParam("id") Long id) {
		pessoaServico.encontrar(id);
		pessoaServico.remover(id);
		return Response.ok().build();
	}


	/**
	 *
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	public Response obterPessoa(@PathParam("id") Long id) {
		return pessoaServico.encontrar(id).map(pessoas -> Response.ok(pessoas).build()).orElseGet(() -> Response.status(Status.NOT_FOUND).build());
	}

}
