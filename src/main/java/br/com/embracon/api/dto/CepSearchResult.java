package br.com.embracon.api.dto;

public record CepSearchResult(
        String cep,
        String rua,
        String bairro,
        String cidade,
        String uf
) {}
