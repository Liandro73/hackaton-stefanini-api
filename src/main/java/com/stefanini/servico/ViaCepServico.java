package com.stefanini.servico;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;
import com.stefanini.model.Endereco;

import java.io.IOException;

public class ViaCepServico {

    public Endereco converterCep(Endereco endereco) {
        ViaCEPClient client = new ViaCEPClient();
        try {
            ViaCEPEndereco enderecoCep = client.getEndereco(endereco.getCep());
            endereco.setBairro(enderecoCep.getBairro());
            endereco.setComplemento(enderecoCep.getComplemento());
            endereco.setLocalidade(enderecoCep.getLocalidade());
            endereco.setUf(enderecoCep.getUf());
            endereco.setLogradouro(enderecoCep.getLogradouro());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }
}