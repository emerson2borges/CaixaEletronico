package br.edu.facisa.caixa.modelo;

public class DadosFacade {

	private static DadosFacade instance = new DadosFacade();
	
	private DadosFacade() {}
	
	public static DadosFacade getInstance() {
		return instance;
	}

	public boolean validaConta(String string, int contaDigitada,
			int senhaDigitada) {
		return false;
	}

}

















