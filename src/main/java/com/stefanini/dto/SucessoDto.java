package com.stefanini.dto;

import java.io.Serializable;

public class SucessoDto implements Serializable {

    private final String mensagem;

    public SucessoDto(String mensagem) {
        this.mensagem = mensagem;
    }
}
