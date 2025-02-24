package br.com.embracon.api.controller;


import br.com.embracon.api.dto.CepSearchResult;
import br.com.embracon.api.dto.LogResult;
import br.com.embracon.api.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Consultas", description = "Endpoints para consultas de CEPs e logs")
@CrossOrigin
@RestController
@RequestMapping("")
public class CepController {

    private final ConsultaService service;

    public CepController(ConsultaService service) {
        this.service = service;
    }

    @GetMapping("/consulta-cep/{cep}")
    @Operation(summary = "Consulta um CEP", description = "Retorna os detalhes do endereço com base no CEP informado.")
    public ResponseEntity<CepSearchResult> findByCep(@PathVariable(required = true) String cep) {
        return ResponseEntity.ok(service.findByCep(cep));
    }

    @GetMapping("/lista-ceps")
    @Operation(summary = "Lista os 20 últimos registros por UF", description = "Retorna os 20 registros mais recentes filtrados pela UF.")
    public ResponseEntity<List<LogResult>> findTop20ByUf(@RequestParam(required = true) String uf) {
        return ResponseEntity.ok(service.findTop20ByUf(uf));
    }



}
