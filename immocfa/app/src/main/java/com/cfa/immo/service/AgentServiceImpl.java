package com.cfa.immo.service;

import com.cfa.immo.model.Agent;
import com.cfa.immo.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService{

  @Autowired
  private AgentRepository agentRepository;

  @Override
  public Agent saveAgent(Agent agent) {
    return agentRepository.save(agent);
  }

  @Override
  public Agent updateAgent(Agent agent, Long id) {
    Agent existingAgent = agentRepository.getAgentById(id);
    existingAgent.setNom(agent.getNom());
    existingAgent.setPrenom(agent.getPrenom());
    existingAgent.setEmail(agent.getEmail());
    existingAgent.setTel(agent.getTel());
    return agentRepository.save(existingAgent);
  }

  @Override
  public void deleteAgent(Long id) {
    agentRepository.deleteById(id);
  }

  @Override
  public Agent getAgentById(Long id) {
    return agentRepository.getAgentById(id);
  }

  @Override
  public List<Agent> findAllAgent() {
    return agentRepository.findAll();
  }
}
