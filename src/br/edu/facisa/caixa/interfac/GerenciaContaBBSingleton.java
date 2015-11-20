package br.edu.facisa.caixa.interfac;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.List;

import br.edu.facisa.caixa.modelo.Conta;

public class GerenciaContaBBSingleton {
	
	private static GerenciaContaBBSingleton unicaInstacia;
	private static Conta conta;
	private static List<Conta> contas = new ArrayList<Conta>();
	
	private GerenciaContaBBSingleton(){
		conta = new Conta("Banco do Brasil", 123456, 842324, 1000);
		contas.add(conta);
	}
	
	public static synchronized GerenciaContaBBSingleton getInstancia(){
		if(unicaInstacia == null){
			unicaInstacia = new GerenciaContaBBSingleton();
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