package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.models.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer>{
}
