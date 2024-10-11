package com.cfa.immo.service;

import com.cfa.immo.model.Agence;

import java.util.List;

public interface AgenceService {
  Agence saveAgence(Agence agence);
  Agence updateAgence(Agence agence, Long id);
  void deleteAgence(Long id);
  Agence getAgenceById(Long id);
  List<Agence> findAllAgences();
}