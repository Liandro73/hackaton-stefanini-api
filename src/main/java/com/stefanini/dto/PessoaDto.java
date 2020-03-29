package com.stefanini.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.stefanini.model.Endereco;
import com.stefanini.model.Perfil;
import lombok.Data;

@Data
public class PessoaDto implements Serializable {

	/**
	 * Serializacao da Classe
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Boolean situacao;
	private Set<Endereco> enderecos = new HashSet<>();
	private Set<Perfil> perfils = new HashSet<>();

}
