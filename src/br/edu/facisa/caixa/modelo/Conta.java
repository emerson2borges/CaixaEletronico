package br.edu.facisa.caixa.modelo;

public class Conta {
	
	private String banco;
	private int numeroConta;
	private int senha;
	private double saldo;
	private int tentativa;
	
	public Conta(){
		
	}
	
	public Conta(String banco, int numeroConta, int Senha, double saldo ){
		this.setBanco(banco);
		this.setNumeroConta(numeroConta);
		this.setSenha(Senha);
		this.setSaldo(saldo);
		this.setTentativa(0);
	}
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getTentativa() {
		return tentativa;
	}

	public void setTentativa(int tentativa) {
		this.tentativa = tentativa;
	}
	
	

}
