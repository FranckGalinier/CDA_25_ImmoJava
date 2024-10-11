package com.cfa.immo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique=true)
  private String username;

  @Column(nullable=false)
  private String password;

  @Column(nullable=false)
  private boolean enable;

  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),
  inverseJoinColumns = @JoinColumn(name="role_id"))
  private Set<Role> roles;

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public boolean isEnable() {
    return enable;
  }

  public void setEnable(boolean enable) {
    this.enable = enable;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
