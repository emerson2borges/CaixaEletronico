package br.edu.facisa.caixa.modelo;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

public class GerenciaContaSingleton {
	
	private static GerenciaContaSingleton unicaInstacia;
	private static Conta conta;
	private static Conta conta1;
	private static List<Conta> contas = new ArrayList<Conta>();
	
	private GerenciaContaSingleton(){
		conta = new Conta("Caixa Economica", 1234,123,1000);
		contas.add(conta);
		conta = new Conta("Banco do Brasil", 123,1234,500);
		contas.add(conta);
	}
	
	public static synchronized GerenciaContaSingleton getInstancia(){
		if(unicaInstacia == null){
			unicaInstacia = new GerenciaContaSingleton();
		}
		return unicaInstacia;
	}
	
	public List<Conta> getContas(){
		return this.contas;
	}
	public Conta getConta(int numeroConta){
		Conta contaAtual = new Conta();
		for(int i = 0; i < this.contas.size(); i++){
			if(numeroConta == this.contas.get(i).getNumeroConta()){
				contaAtual = this.contas.get(i);
			}
		}
		return contaAtual;
	}

}