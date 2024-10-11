package com.cfa.immo.repository;

import com.cfa.immo.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long>{
  Agent getAgentById(Long id);

}
