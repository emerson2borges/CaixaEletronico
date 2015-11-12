package br.edu.facisa.caixa.modelo;

import java.util.LinkedList;
import java.util.List;

public abstract class MaquinaAdapter implements IMaquinaDeEstados {

	protected static final String ESTADO_INICIAL = "Inicial";

	protected static final String REALIZANDO_DEPOSITO = "Em Deposito";

	protected static final String ESCOLHENDO_BANCO = "Escolhendo Banco";

	protected static final String DIGITANDO_CONTA = "Digitando Conta";

	protected static final String DIGITANDO_SENHA = "Digitando Senha";
	
	protected static final String DIGITANDO_OPCAO = "Digitando Opcao";


	protected List<MaquinaDeEstadosListener> listeners = new LinkedList<MaquinaDeEstadosListener>();

	protected String estado;

	public boolean adicionaMaquinaDeEstadosListener(
			MaquinaDeEstadosListener listener) {
		return this.listeners.add(listener);
	}

	public boolean removeMaquinaDeEstadosListener(
			MaquinaDeEstadosListener listener) {
		return this.listeners.remove(listener);
	}

	public void notificaMudanca(MaquinaDeEstadosEvent evento) {
		for (MaquinaDeEstadosListener listener : listeners) {
			listener.houveMudanca(evento);
		}
	}
	
}
