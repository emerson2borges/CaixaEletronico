package br.edu.facisa.caixa.modelo;

public class MaquinaDeEstadosFactory {

	public static IMaquinaDeEstados criaMaquinaSatander() {
		return new MaquinaSantander();
	}
	
	public static IMaquinaDeEstados criaMaquinaBancoDoBrasil() {
		return new MaquinaBancoBrasil();
	}

	public static IMaquinaDeEstados criaMaquinaPadraoCaixa() {
		return new MaquinaPadrao();
	}
	
	public static IMaquinaDeEstados criaMaquinaCaixaEconomica(){
		return new MaquinaCaixaEconomica();
	}
	
}
