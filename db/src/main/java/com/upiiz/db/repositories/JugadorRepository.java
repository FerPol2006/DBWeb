package com.upiiz.db.repositories;

import com.upiiz.db.entities.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorEntity, Long>
{


}
