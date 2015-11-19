package br.edu.facisa.caixa.factory;

import br.edu.facisa.caixa.caixaeconomica.MaquinaCaixaEconomica;
import br.edu.facisa.caixa.interfac.IMaquinaDeEstados;
import br.edu.facisa.caixa.modelo.MaquinaBancoBrasil;
import br.edu.facisa.caixa.modelo.MaquinaPadrao;
import br.edu.facisa.caixa.modelo.MaquinaSantander;

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
