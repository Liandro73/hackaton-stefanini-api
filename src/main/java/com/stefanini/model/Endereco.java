package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID da Tabela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CO_SEQ_ENDERECO")
    private Long id;

    @Column(name = "DS_CEP")
    private String cep;

    @Column(name = "CO_UF")
    private String uf;

    @Column(name = "DS_CIDADE")
    private String localidade;

    @Column(name = "DS_BAIRRO")
    private String bairro;

    @Column(name = "DS_COMPLEMENTO")
    private String complemento;

    @Column(name = "DS_LOGRADOURO")
    private String logradouro;

    /**
     * Unidirecional
     * Somente Pessoa acessa endereco
     */
    @Column(name = "CO_SEQ_PESSOA")
    private Long idPessoa;

}
