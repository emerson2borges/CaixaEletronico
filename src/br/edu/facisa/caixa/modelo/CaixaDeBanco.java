package br.edu.facisa.caixa.modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.edu.facisa.caixa.caixaeconomica.MaquinaCaixaEconomica;
import br.edu.facisa.caixa.factory.MaquinaDeEstadosFactory;
import br.edu.facisa.caixa.interfac.IMaquinaDeEstados;
import br.edu.facisa.caixa.interfac.MaquinaDeEstadosListener;

public class CaixaDeBanco implements MaquinaDeEstadosListener {

	private IMaquinaDeEstados maquinaPadrao;

	private List<IMaquinaDeEstados> maquinasDeEstados;
	
	private IMaquinaDeEstados maquinaAtual;
	
	public void iniciaOperacoes() {
		this.maquinasDeEstados = new LinkedList<IMaquinaDeEstados>();
		this.maquinaPadrao = MaquinaDeEstadosFactory.criaMaquinaPadraoCaixa();
		this.maquinaPadrao.adicionaMaquinaDeEstadosListener(this);
		this.maquinaAtual = maquinaPadrao;
		this.maquinaAtual.inicia();
	}

	public void adicionaMaquinaDeEstados(IMaquinaDeEstados maquina) {
		this.maquinasDeEstados.add(maquina);
	}

	public void houveMudanca(MaquinaDeEstadosEvent mudanca) {
		if (mudanca.getNovaTela() != null) {
			System.out.println(mudanca.getNovaTela());
		} else if (mudanca.getOperacaoHardware() != null) {
			if (mudanca.getOperacaoHardware() == TipoOperacaoHardware.ABRE_BANDEJA_DEPOSITO) {
				System.out.println("Bandeja aberta.");
			}
		} else if (mudanca.getTrocaMaquinaDeEstados() != null) {
			switch (mudanca.getTrocaMaquinaDeEstados()) {
			case "Santander" :
				this.maquinaAtual.para();
				this.maquinaAtual = new MaquinaSantander();
				this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
				this.maquinaAtual.inicia();
			case "Banco do Brasil" :
				this.maquinaAtual.para();
				this.maquinaAtual = new MaquinaBancoBrasil();
				this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
				this.maquinaAtual.inicia();	
			case "Caixa Economica":
				this.maquinaAtual.para();
				this.maquinaAtual = new MaquinaCaixaEconomica();
				this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
				this.maquinaAtual.inicia();	
			case "Caixa Padrao":
				this.maquinaAtual.para();
				this.maquinaAtual = new MaquinaPadrao();
				this.maquinaAtual.adicionaMaquinaDeEstadosListener(this);
				this.maquinaAtual.inicia();	
			}
		}
		this.exibeTeclado();
	}

	private void exibeTeclado() {
		System.out.println("- DIGITE E PRESSIONE ENTER: \n    1 2 3 4  CONFIRMA\n "
							+ "   5 6 7 8\n      9 0    CANCELA\n"
							+ "    A B C D\n    E F G H  CORRIGE");
		Scanner sc = new Scanner(System.in);
		String resposta = sc.nextLine();
		processaInteracao(resposta);
	}

	private void processaInteracao(String resposta) {
		if (resposta.equals("1")) {
			this.maquinaAtual.teclaNum01Digitada();
		} else if (resposta.equals("2")) {
			this.maquinaAtual.teclaNum02Digitada();
		} else if (resposta.equals("3")) {
			this.maquinaAtual.teclaNum03Digitada();
		} else if (resposta.equals("4")) {
			this.maquinaAtual.teclaNum04Digitada();
		} else if (resposta.equals("5")) {
			this.maquinaAtual.teclaNum05Digitada();
		} else if (resposta.equals("6")) {
			this.maquinaAtual.teclaNum06Digitada();
		} else if (resposta.equals("7")) {
			this.maquinaAtual.teclaNum07Digitada();
		} else if (resposta.equals("8")) {
			this.maquinaAtual.teclaNum08Digitada();
		} else if (resposta.equals("9")) {
			this.maquinaAtual.teclaNum09Digitada();
		} else if (resposta.equals("0")) {
			this.maquinaAtual.teclaNum00Digitada();
		}else if(resposta.toUpperCase().equals("A")){
			this.maquinaAtual.teclaEsquerda01Digitada();
		}else if(resposta.toUpperCase().equals("B")){
			this.maquinaAtual.teclaEsquerda02Digitada();
		}else if(resposta.toUpperCase().equals("C")){
			this.maquinaAtual.teclaEsquerda03Digitada();
		}else if(resposta.toUpperCase().equals("D")){
			this.maquinaAtual.teclaEsquerda04Digitada();
		}else if(resposta.toUpperCase().equals("E")){
			this.maquinaAtual.teclaDireita01Digitada();
		}else if(resposta.toUpperCase().equals("F")){
			this.maquinaAtual.teclaDireita02Digitada();
		}else if(resposta.toUpperCase().equals("G")){
			this.maquinaAtual.teclaDireita03Digitada();
		}else if(resposta.toUpperCase().equals("H")){
			this.maquinaAtual.teclaDireita04Digitada();
		}else if (resposta.toUpperCase().equals("CONFIRMA")) {
			this.maquinaAtual.teclaConfirmaDigitada();
		}else if(resposta.toUpperCase().equals("CANCELA")){
			this.maquinaAtual.teclaCancelarDigitada();
		}else if(resposta.toUpperCase().equals("CORRIGE")){
			this.maquinaAtual.teclaCorrigeDigitada();
		}
	}
}