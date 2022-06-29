package com.example.demo.dtos;

//import javax.validation.constraints.NotBlank;

import com.example.demo.models.Jogador;

public class PagamentoDto {
	
	private int ano;
	
	private int mes;
	
	private double valor;
	
	private long ID_JOGADOR;

	//private Jogador jogador;
	
	public long getID_JOGADOR() {
		return ID_JOGADOR;
	}

	public void setID_JOGADOR(long iD_JOGADOR) {
		ID_JOGADOR = iD_JOGADOR;
	}

//	public void setJogador(Jogador jogador) {
//		this.jogador = jogador;
//	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

//	public Jogador getJogador() {
//		return jogador;
//	}
//
//	public void setJogadorModel(Jogador jogador) {
//		this.jogador = jogador;
//	}
	
}
