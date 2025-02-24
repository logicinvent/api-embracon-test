package br.com.embracon.api.integrator.impl;

import br.com.embracon.api.dto.ViaCepResult;
import br.com.embracon.api.exception.CepException;
import br.com.embracon.api.integrator.ViaCepIntegrator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ViaCepIntegratorImpl implements ViaCepIntegrator {

    private static final String URL = "https://viacep.com.br/ws/%s/json/";
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;


    public ViaCepIntegratorImpl(HttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public ViaCepResult getCepInfo(String cep) {
        try {
            var request = HttpRequest.newBuilder()
                    .uri(new URI(String.format(URL, cep)))
                    .GET()
                    .build();

            var response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(response.body(), ViaCepResult.class);

        } catch (Exception e) {
            throw new CepException("Cep not found");
        }
    }

}
