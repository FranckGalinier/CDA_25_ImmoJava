package com.cfa.immo.service;

import com.cfa.immo.model.Agent;

import java.util.List;

public interface AgentService {

  Agent saveAgent(Agent agent);
  Agent updateAgent(Agent agent, Long id);
  void deleteAgent(Long id);
  Agent getAgentById(Long id);
  List<Agent> findAllAgent();

}
