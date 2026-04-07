package com.upiiz.db.repositories;

import com.upiiz.db.entities.EntrenadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<EntrenadorEntity, Long>{

}
