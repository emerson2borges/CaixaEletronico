package br.edu.facisa.caixa.modelo;

public class MaquinaDeEstadosFactory {

	public static IMaquinaDeEstados criaMaquinaSatander() {
		return new MaquinaSantander();
	}
	
	public static IMaquinaDeEstados criaMaquinaBancoDoBrasil() {
		return null;
	}

	public static IMaquinaDeEstados criaMaquinaPadraoCaixa() {
		return new MaquinaPadrao();
	}
	
}
