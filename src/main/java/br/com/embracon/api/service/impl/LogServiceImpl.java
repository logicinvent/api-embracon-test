package br.com.embracon.api.service.impl;

import br.com.embracon.api.exception.LogException;
import br.com.embracon.api.model.Log;
import br.com.embracon.api.repository.LogRepository;
import br.com.embracon.api.service.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    public static final String NO_LOG_FOUND = "No log found";
    private final LogRepository repository;

    public LogServiceImpl(LogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Log save(Log log){
        return repository.save(log);
    }

    @Override
    public List<Log> findTop20ByUf(String uf){

        var logs = repository.findTop20ByUf(uf);

        if (logs.isEmpty())
            throw new LogException(NO_LOG_FOUND);

        return logs;
    }

}
