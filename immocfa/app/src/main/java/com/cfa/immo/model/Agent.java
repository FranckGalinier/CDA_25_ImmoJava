package com.cfa.immo.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agent {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, columnDefinition="TEXT")
  private String nom;

  @Column(nullable=false)
  private String prenom;

  @Column(nullable=false)
  private int tel;

  @Column(nullable=false)
  private String email;

  @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = false)
  List<Bien> biens = new ArrayList<>();

  public Agent() {
  }

  public Agent(String email, int tel, String prenom, String nom, Long id) {
    this.email = email;
    this.tel = tel;
    this.prenom = prenom;
    this.nom = nom;
    this.id = id;
  }

  public Agent(String email, int tel, String prenom, String nom) {
    this.email = email;
    this.tel = tel;
    this.prenom = prenom;
    this.nom = nom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getTel() {
    return tel;
  }

  public void setTel(int tel) {
    this.tel = tel;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getFullName(){
    return this.nom + " " + this.prenom;
  }

  public List<Bien> getBiens() {
    return biens;
  }

  public void addBiens(Bien bien){
    biens.add(bien);
    bien.setAgent(this);
  }

  public void removeBien(Bien bien){
    biens.remove(bien);
    bien.setAgent(null);

  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("<table>")
            .append("<tr><td>nom</td><td>").append(this.nom + "</td></tr>")
            .append("<tr><td>prenom</td><td>").append(this.prenom + "</td></tr>")
            .append("<tr><td>tel</td><td>").append(this.tel + "</td></tr>")
            .append("<tr><td>email</td><td>").append(this.email + "</td></tr>")
            .append("</table>");
    return str.toString();
  }

}

