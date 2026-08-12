package com.example.atividade_leads.service;

import com.example.atividade_leads.domain.Faixa;
import org.springframework.stereotype.Component;

@Component
public class ClassificationService {

    public record ClassificationResult(String faixa, int prioridade, String sugestao) {}

    public ClassificationResult classify(Double consumo) {
        if (consumo == null) {
            consumo = 0.0;
        }

        if (consumo < 100.0) {
            return new ClassificationResult(Faixa.BAIXO.name(), 4, "Nutrição mensal por e-mail");
        }

        if (consumo < 300.0) {
            return new ClassificationResult(Faixa.MEDIO.name(), 3, "Contato em até 72h + material educativo");
        }

        if (consumo < 700.0) {
            return new ClassificationResult(Faixa.ALTO.name(), 2, "Contato em até 48h + proposta personalizada");
        }

        return new ClassificationResult(Faixa.VIP.name(), 1, "Contato em até 24h + consultoria especializada");
    }
}
