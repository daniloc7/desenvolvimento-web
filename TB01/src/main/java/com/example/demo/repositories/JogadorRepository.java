package com.example.demo.repositories;

//import java.util.List;
//import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Jogador;

//Aqui ja tem varios metodos prontos.
@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	
	public boolean existsByEmail(String email);
	 
}
