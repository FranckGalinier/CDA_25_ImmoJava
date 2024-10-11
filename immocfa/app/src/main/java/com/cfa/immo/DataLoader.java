package com.cfa.immo;

import com.cfa.immo.model.Agence;
import com.cfa.immo.model.Agent;
import com.cfa.immo.model.Bien;
import com.cfa.immo.repository.AgenceRepository;
import com.cfa.immo.repository.AgentRepository;
import com.cfa.immo.repository.BienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

  @Autowired
  private AgentRepository agentRepository;

  @Autowired
  private AgenceRepository agenceRepository;

  @Autowired
  private BienRepository bienRepository;
  @Override
  public void run(String... args) throws Exception {
    if(agentRepository.count() == 0){

    List<Agent> agents = new ArrayList<>();
    agents.add(new Agent("gerard.jugnot@gmail.com", 06060006, "Gerard", "Jugnot"));
    agents.add(new Agent("michel.blanc@gmail.com", 06252525 , "Michel", "Blankc"));
     agentRepository.saveAll(agents);

     Agence agence = new Agence(544554 , "2 rue des lauriesr 66000 Perpignan", "Agence3000");

     agence.setAgents(agents);
     agenceRepository.save(agence);

     List<Bien> biens = new ArrayList<>();
     biens.add(new Bien("Appartement très bien positionné", 400000, 200, 2, "Appartment", agents.get(0)));
     biens.add(new Bien ("Maison de campagne", 2500000, 125, 4 ,"Maisonnette", agents.get(1)));

     bienRepository.saveAll(biens);

    }
  }
}
