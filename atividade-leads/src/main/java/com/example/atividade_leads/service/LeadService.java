package com.example.atividade_leads.service;

import com.example.atividade_leads.domain.Lead;
import com.example.atividade_leads.repository.LeadRepository;
import com.example.atividade_leads.dto.LeadRequest;
import com.example.atividade_leads.dto.LeadResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LeadService {

    private final LeadRepository repository;
    private final ClassificationService classifier;

    public LeadService(LeadRepository repository, ClassificationService classifier) {
        this.repository = repository;
        this.classifier = classifier;
    }

    public LeadResponse create(LeadRequest req) {
        validate(req);

        var result = classifier.classify(req.getConsumoMedio());

        Lead lead = new Lead(
                UUID.randomUUID(),
                req.getNome(),
                req.getEmail(),
                req.getTelefone(),
                req.getCpf(),
                req.getConsumoMedio(),
                result.faixa(),
                result.prioridade(),
                result.sugestao()
        );

        Lead saved = repository.save(lead);

        return toDto(saved);
    }

    public List<LeadResponse> listAll() {
        return ((List<Lead>) repository.findAll()).stream().map(this::toDto).collect(Collectors.toList());
    }

    private LeadResponse toDto(Lead l) {
        return new LeadResponse(
                l.getId(), l.getNome(), l.getEmail(), l.getTelefone(), l.getCpf(), l.getConsumoMedio(), l.getFaixa(), l.getPrioridade(), l.getSugestao()
        );
    }

    private void validate(LeadRequest req) {
        if (req.getEmail() == null || !req.getEmail().contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email inválido");
        }

        if (req.getCpf() != null && !req.getCpf().isBlank()) {
            String cpf = req.getCpf();
            boolean ok = cpf.matches("\\d{11}") || cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
            if (!ok) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF com formato inválido");
            }
        }

        if (req.getTelefone() == null || countDigits(req.getTelefone()) < 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Telefone inválido");
        }
    }

    private int countDigits(String s) {
        int c = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) c++;
        }
        return c;
    }
}
