package com.cfa.immo.repository;
import com.cfa.immo.model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BienRepository extends JpaRepository<Bien, Long>{
  Bien getBienById(Long id);
}
