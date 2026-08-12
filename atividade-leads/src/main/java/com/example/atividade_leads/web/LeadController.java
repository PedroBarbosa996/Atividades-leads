package com.example.atividade_leads.web;

import com.example.atividade_leads.dto.LeadRequest;
import com.example.atividade_leads.dto.LeadResponse;
import com.example.atividade_leads.service.LeadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    private final LeadService service;

    public LeadController(LeadService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LeadResponse> create(@RequestBody LeadRequest req) {
        LeadResponse resp = service.create(req);
        return ResponseEntity.created(URI.create("/leads/" + resp.getId())).body(resp);
    }

    @GetMapping
    public List<LeadResponse> list() {
        return service.listAll();
    }
}
