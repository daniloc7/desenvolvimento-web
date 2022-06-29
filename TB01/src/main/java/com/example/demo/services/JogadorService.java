package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Jogador;
import com.example.demo.repositories.JogadorRepository;

@Service
public class JogadorService {
  
	final JogadorRepository jogadorRepository;

	public JogadorService(JogadorRepository jogadorRepository) {
		this.jogadorRepository = jogadorRepository;
	}
	
	@Transactional//Manter dados atomicos
	public Jogador save(Jogador jogadorModel) {
		return jogadorRepository.save(jogadorModel);
	}
	
	public boolean existsByEmail(String email) {
		return jogadorRepository.existsByEmail(email);
	}
	
	public List<Jogador> findAll(){
		return jogadorRepository.findAll();
	}
	
	public Optional<Jogador> findById(Long id) {
		return jogadorRepository.findById(id);
	}
	
	@Transactional
	public void delete(Jogador jogador){
		jogadorRepository.delete(jogador);
	}
		
}
