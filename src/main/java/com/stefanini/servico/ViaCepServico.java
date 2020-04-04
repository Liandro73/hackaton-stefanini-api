package com.stefanini.servico;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;
import com.stefanini.model.Endereco;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
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

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public static String buscarCep(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            json = jsonSb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return json;
    }

}