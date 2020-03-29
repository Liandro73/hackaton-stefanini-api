package com.stefanini.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {

    /**
     * Serializacao da Classe
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_seq_perfil")
    private Long id;

    /**
     *
     */
    @NotNull
    @Column(name = "no_perfil")
    private String nome;

    /**
     *
     */
    @NotNull
    @Column(name = "ds_perfil")
    private String descricao;

    /**
     *
     */
    @Column(name = "dt_hora_inclusao")
//    @NotNull
    private LocalDateTime dataHoraInclusao;

    /**
     *
     */
    @Column(name = "dt_hora_alteracao")
    private LocalDateTime dataHoraAlteracao;
    
}
