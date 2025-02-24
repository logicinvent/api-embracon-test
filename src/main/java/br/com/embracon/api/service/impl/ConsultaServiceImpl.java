package br.com.embracon.api.service.impl;

import br.com.embracon.api.dto.CepSearchResult;
import br.com.embracon.api.dto.LogResult;
import br.com.embracon.api.dto.ViaCepResult;
import br.com.embracon.api.integrator.ViaCepIntegrator;
import br.com.embracon.api.model.Log;
import br.com.embracon.api.service.ConsultaService;
import br.com.embracon.api.service.LogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final LogService service;
    private final ViaCepIntegrator integrator;
    private final LogService logService;

    public ConsultaServiceImpl(LogService service, ViaCepIntegrator integrator, LogService logService) {
        this.service = service;
        this.integrator = integrator;
        this.logService = logService;
    }

    @Override
    public CepSearchResult findByCep(String cep){

        ViaCepResult cepInfo = integrator.getCepInfo(cep);
        logService.save(getLog(cepInfo));
        return new CepSearchResult(
                cepInfo.cep(),
                cepInfo.logradouro(),
                cepInfo.bairro(),
                cepInfo.localidade(),
                cepInfo.uf()
        );

    }

    private Log getLog(ViaCepResult cepInfo) {
        Log log = new Log();
        log.setCep(cepInfo.cep());
        log.setDtHrConsulta(LocalDateTime.now());
        log.setUf(cepInfo.uf());
        return log;
    }

    @Override
    public List<LogResult> findTop20ByUf(String uf){
        return service.findTop20ByUf(uf)
                .stream().map(
                        log -> new LogResult(log.getCep(), log.getDtHrConsulta().toLocalDate()))
                .collect(Collectors.toList());
    }

}
