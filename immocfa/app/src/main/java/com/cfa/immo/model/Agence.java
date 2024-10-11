package com.cfa.immo.model;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Agence {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, columnDefinition="TEXT")
  private String nom;

  @Column(nullable=false, columnDefinition="TEXT")
  private String adresse;

  @Column(nullable=false)
  private int tel;

  @ManyToMany
  @Column(nullable=false)
  @JoinTable(name="agence_agent", joinColumns = @JoinColumn(name="agence_id"),
  inverseJoinColumns = @JoinColumn(name="agent_id"))
  private List<Agent> agents;

  public Agence() {
  }

  public Agence(int tel, String adresse, String nom, Long id) {
    this.tel = tel;
    this.adresse = adresse;
    this.nom = nom;
    this.id = id;
  }

  public Agence(int tel, String adresse, String nom) {
    this.tel = tel;
    this.adresse = adresse;
    this.nom = nom;
  }

  public List<Agent> getAgents() {
    return agents;
  }

  public void setAgents(List<Agent> agents) {
    this.agents = agents;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getTel() {
    return tel;
  }

  public void setTel(int tel) {
    this.tel = tel;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String joinedAgent(){
    return agents.stream().map(Agent::getFullName).collect(Collectors.joining(", "));
  }
}
