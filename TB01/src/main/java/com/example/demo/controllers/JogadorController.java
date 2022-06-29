package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.JogadorDto;
import com.example.demo.services.JogadorService;
import com.example.demo.models.*;

//Criar os metodos
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/jogador")
public class JogadorController {
	
	final JogadorService jogadorService;

	public JogadorController(JogadorService jogadorService) {
		this.jogadorService = jogadorService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveJogador(@RequestBody @Valid JogadorDto jogadorDto){
		
		if(jogadorService.existsByEmail(jogadorDto.getEmail())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse e-mail já está em uso!");
		}
		
		Jogador jogador = new Jogador();
		BeanUtils.copyProperties(jogadorDto, jogador);
		return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.save(jogador));
	}
	
	@GetMapping
	public ResponseEntity<List<Jogador>> getAllJogadores(){
		return ResponseEntity.status(HttpStatus.OK).body(jogadorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getJogadorById(@PathVariable(value="id")Long id){
		Optional<Jogador> jogadorOptional = jogadorService.findById(id);
		if(!jogadorOptional.isPresent() ) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(jogadorOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteJogador(@PathVariable(value="id") Long id){
		Optional<Jogador> jogadorOptional = jogadorService.findById(id);
		if(!jogadorOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado!");
		}
		jogadorService.delete(jogadorOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Jogador excluído!");
	}
	//ID do jogador com o Id do JogadorModel
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateJogador(@PathVariable(value = "id") Long id,
												@RequestBody @Valid JogadorDto jogadorDto){
		Optional<Jogador> jogadorOptional = jogadorService.findById(id);
		if(!jogadorOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Jogador não encontrado");
		}
		Jogador jogador = new Jogador();
		BeanUtils.copyProperties(jogadorDto, jogador);//Testar com optional
		jogador.setId(jogadorOptional.get().getId());
		
		return ResponseEntity.status(HttpStatus.OK).body(jogadorService.save(jogador));
	}
	
}
