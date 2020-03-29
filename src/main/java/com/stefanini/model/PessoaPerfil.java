package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "tb_pessoa_perfil")
public class PessoaPerfil implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "co_seq_pessoal_perfil")
    private Long id;

    @Column(name = "co_seq_perfil", insertable = false, updatable = false)
    private Long idPerfil;

    @Column(name = "co_seq_pessoa", insertable = false, updatable = false)
    private Long idPessoa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_seq_perfil", referencedColumnName = "co_seq_perfil", nullable = false)
    private Perfil perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_seq_pessoa", referencedColumnName = "co_seq_pessoa", nullable = false)
    private Pessoa pessoa;

}
