package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author joaopedromilhome
 */
@Entity
@Data
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID da Tabela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_PESSOA")
    private Long id;

    /**
     * Nome da pessoa
     */
    @NotNull
    @Column(name = "NO_NOME")
    private String nome;

    /**
     * Email da Pessoa
     */
    @NotNull
    @Email
    @Column(name = "DS_EMAIL", unique = true)
    private String email;

    /**
     * Data de Nascimento
     */
    @NotNull
    @Column(name = "DT_NASCIMENTO")
    private LocalDate dataNascimento;

    /**
     * Situacao da Pessoa
     */
    @NotNull
    @Column(name = "ST_PESSOA")
    private Boolean situacao;

    @Column(name = "DS_CAMINHO_IMAGEM")
    private String caminhoImagem;

    /**
     * Mapeamento de Enderecos Unidirecional
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CO_SEQ_PESSOA", referencedColumnName = "CO_SEQ_PESSOA")
    private Set<Endereco> enderecos = new HashSet<>();

    /**
     * Mapeamento de Perfis Unidirecional
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "TB_PESSOA_PERFIL",
            joinColumns = {@JoinColumn(name = "CO_SEQ_PESSOA")},
            inverseJoinColumns = {@JoinColumn(name = "CO_SEQ_PERFIL")}
    )
    private Set<Perfil> perfils = new HashSet<>();

}
