package br.edu.facisa.caixa.modelo;

public class MaquinaDeEstadosEvent {

	private String novaTela;
	private TipoOperacaoHardware operacaoDeHardware;
	private String novaMaquina;

	public void setNovaTela(String string) {
		this.novaTela = string;
	}

	public String getNovaTela() {
		return novaTela;
	}

	public void setOperacaoHardware(TipoOperacaoHardware operacao) {
		this.operacaoDeHardware = operacao;
	}

	public TipoOperacaoHardware getOperacaoHardware() {
		return this.operacaoDeHardware;
	}

	public void setTrocaMaquinaDeEstados(String string) {
		this.novaMaquina = string;
	}

	public String getTrocaMaquinaDeEstados() {
		return this.novaMaquina;
	}

}
