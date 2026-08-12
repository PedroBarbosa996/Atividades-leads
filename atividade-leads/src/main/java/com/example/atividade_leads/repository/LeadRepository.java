package com.example.atividade_leads.repository;

import com.example.atividade_leads.domain.Lead;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LeadRepository extends CrudRepository<Lead, UUID> {

}
