package br.com.embracon.api.service;

import br.com.embracon.api.model.Log;

import java.util.List;

public interface LogService {

    Log save(Log log);
    List<Log> findTop20ByUf(String uf);

}
