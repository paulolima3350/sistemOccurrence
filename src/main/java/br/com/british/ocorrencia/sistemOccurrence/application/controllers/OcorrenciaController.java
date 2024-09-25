package br.com.british.ocorrencia.sistemOccurrence.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaRequestDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.dtos.OcorrenciaResponseDTO;
import br.com.british.ocorrencia.sistemOccurrence.domain.models.enums.Unidade;
import br.com.british.ocorrencia.sistemOccurrence.domain.services.interfaces.OcorrenciaDomainService;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaDomainService ocorrenciaDomainService;

    @PostMapping
    public OcorrenciaResponseDTO post(@RequestBody OcorrenciaRequestDTO request) throws Exception {
        return ocorrenciaDomainService.inserir(request);
    }
    
    // Endpoint para consultar ocorrências por unidade
    
    
    
    @GetMapping("/unidade/{unidade}")
    public ResponseEntity<?> consultarPorUnidade(@PathVariable String unidade) {
        try {
            Unidade unidadeEnum = Unidade.valueOf(unidade.toUpperCase()); // Converte a string para o enum
            return ResponseEntity.ok(ocorrenciaDomainService.consultarPorUnidade(unidadeEnum));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Unidade inválida: " + unidade);
        }
    }
    
    
    
    // Endpoint para gerar relatório filtrado (unidade, status, datas)
    @GetMapping("/relatorio")
    public List<OcorrenciaResponseDTO> gerarRelatorio(
            @RequestParam String unidade,
            @RequestParam String status,
            @RequestParam String dataInicio,
            @RequestParam String dataFim) {
        return ocorrenciaDomainService.gerarRelatorio(unidade, status, dataInicio, dataFim);
    }
}