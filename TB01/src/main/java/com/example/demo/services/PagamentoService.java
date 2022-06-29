package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.models.Jogador;
//import com.example.demo.models.Jogador;
import com.example.demo.models.Pagamento;
import com.example.demo.repositories.PagamentoRepository;

@Service
public class PagamentoService {	
	
	final PagamentoRepository pagamentoRepository;

	public PagamentoService(PagamentoRepository pagamentoRepository) {		
		this.pagamentoRepository = pagamentoRepository;
	}
	
	public Pagamento save(Pagamento pagamentoModel) {
		return pagamentoRepository.save(pagamentoModel);
	}
	
	public List<Pagamento> findByMesContainingAndJogadorId(Integer mes, Long jogador){
		return pagamentoRepository.findByMesContainingAndJogadorId(mes,jogador);
	}
	
	public List<Pagamento> findAll(){
		return pagamentoRepository.findAll();
	}
	
	public boolean existsByAnoAndMesAndJogador(Integer ano, Integer mes, Long jogador) {
		return pagamentoRepository.existsByAnoAndMesAndJogador(ano, mes, jogador);
	}
	
	public List<Pagamento> findByMesBetweenAndJogadorId(Integer mesI, Integer mesF, Long jogador){
		return pagamentoRepository.findByMesBetweenAndJogadorId(mesI, mesF,jogador);
	}
	
	public Optional<Pagamento> findById(Long id) {
		return pagamentoRepository.findById(id);
	}
	
	@Transactional
	public void delete(Pagamento pagamento){
		pagamentoRepository.delete(pagamento);
	}
	
}
