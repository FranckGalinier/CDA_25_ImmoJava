package com.cfa.immo.service;


import com.cfa.immo.model.Agent;
import com.cfa.immo.model.Bien;
import com.cfa.immo.repository.BienRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class BienServiceImpl implements BienService{

  @Autowired
  private BienRepository bienRepository;

  @Override
  public Bien saveBien(Bien bien) {
    return bienRepository.save(bien);
  }

  @Override
  public Bien updateBien(Bien bien, Long id) {
    Bien existingbien = bienRepository.getBienById(id);
    existingbien.setDescription(bien.getDescription());
    existingbien.setPrix(bien.getPrix());
    existingbien.setType(bien.getType());
    existingbien.setSurface(bien.getSurface());
    existingbien.setNbPieces(bien.getNbPieces());
    return bienRepository.save(existingbien);
  }

  @Override
  public void deleteBien(Long id){
     bienRepository.deleteById(id);
  }

  @Override
  public Bien getBienById(Long id){
    return bienRepository.getBienById(id);
  }

  @Override
  public List<Bien> findAllBien(){
    return bienRepository.findAll();
  }
}
