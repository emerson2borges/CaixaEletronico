package br.edu.facisa.caixa.interfac;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.modelo.Conta;

public class GerenciaContaSingleton {
	
	private static GerenciaContaSingleton unicaInstacia;
	private static Conta conta;
	private static List<Conta> contas = new ArrayList<Conta>();
	
	private GerenciaContaSingleton(){
		conta = new Conta("Caixa Economica", 1234,123,1000);
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