package br.com.embracon.api.integrator;

import br.com.embracon.api.dto.ViaCepResult;

public interface ViaCepIntegrator {
    ViaCepResult getCepInfo(String cep);
}
