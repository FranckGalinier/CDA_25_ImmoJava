package com.cfa.immo.repository;

import com.cfa.immo.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
  Agence getAgenceById(Long id);
}