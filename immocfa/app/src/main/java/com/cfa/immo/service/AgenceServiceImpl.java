package com.cfa.immo.service;

import com.cfa.immo.model.Agence;
import com.cfa.immo.repository.AgenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceServiceImpl implements AgenceService{

  @Autowired
  private AgenceRepository agenceRepository;

  @Override
  public Agence saveAgence(Agence agence) {
    return agenceRepository.save(agence);
  }

  @Override
  public Agence updateAgence(Agence agence, Long id) {
    agence.setId(id);
    return agenceRepository.save(agence);
  }

  @Override
  public void deleteAgence(Long id) {
    agenceRepository.deleteById(id);
  }

  @Override
  public Agence getAgenceById(Long id) {
    return agenceRepository.getAgenceById(id);
  }

  @Override
  public List<Agence> findAllAgences() {
    return agenceRepository.findAll();
  }
}