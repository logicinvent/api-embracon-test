package br.com.embracon.api.dto;

public record ViaCepResult(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf) {
}
