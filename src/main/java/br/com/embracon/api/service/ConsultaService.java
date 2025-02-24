package br.com.embracon.api.service;

import br.com.embracon.api.dto.CepSearchResult;
import br.com.embracon.api.dto.LogResult;

import java.util.List;

public interface ConsultaService {

    CepSearchResult findByCep(String cep);
    List<LogResult> findTop20ByUf(String uf);

}
