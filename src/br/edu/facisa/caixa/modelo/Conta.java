package br.edu.facisa.caixa.modelo;

public class Conta {
	
	private String banco;
	private int agencia;
	private int numeroConta;
	private String nome;
	private int senha;
	private String senhaS;
	private double saldo;
	private int tentativa;
	
	public Conta(){
		
	}
	
	public Conta(String banco, int agencia, int numeroConta,String nome, int senha, double saldo ){
		this.setBanco(banco);
		this.setNumeroConta(numeroConta);
		this.setSenha(senha);
		this.setSaldo(saldo);
		this.setTentativa(0);
	}
	
	public Conta(String banco, int numeroConta, String senha, double saldo ){
		this.setBanco(banco);
		this.setNumeroConta(numeroConta);
		this.setSenhaS(senha);
		this.setSaldo(saldo);
		this.setTentativa(0);
	}
	
	public String getBanco() {
		return this.banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public int getNumeroConta() {
		return this.numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String getSenhaS() {
		return senhaS;
	}
	public void setSenhaS(String senha) {
		this.senhaS = senha;
	}
	
	public int getSenha() {
		return this.senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return this.saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getTentativa() {
		return this.tentativa;
	}

	public void setTentativa(int tentativa) {
		this.tentativa = tentativa;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	

}
