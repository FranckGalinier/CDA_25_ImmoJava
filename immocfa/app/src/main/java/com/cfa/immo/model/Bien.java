package com.cfa.immo.model;
import jakarta.persistence.*;

@Entity
public class Bien {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false)
  private int prix;

  @Column(nullable = false)
  private int surface;

  @Column(nullable = false)
  private int nbPieces;

  @Column(nullable = false)
  private String type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="agent_id")
  private Agent agent;

  public Bien() {
  }

  public Bien(String type, int nbPieces, int surface, int prix, Long id, String description, Agent agent) {
    this.type = type;
    this.nbPieces = nbPieces;
    this.surface = surface;
    this.prix = prix;
    this.id = id;
    this.description = description;
    this.agent = agent;
  }

  public Bien(String description, int prix, int surface, int nbPieces, String type, Agent agent) {
    this.description = description;
    this.prix = prix;
    this.surface = surface;
    this.nbPieces = nbPieces;
    this.type = type;
    this.agent = agent;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public int getNbPieces() {
    return nbPieces;
  }

  public void setNbPieces(int nbPieces) {
    this.nbPieces = nbPieces;
  }

  public int getSurface() {
    return surface;
  }

  public void setSurface(int surface) {
    this.surface = surface;
  }

  public int getPrix() {
    return prix;
  }

  public void setPrix(int prix) {
    this.prix = prix;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getId() {
    return id;
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }
}
