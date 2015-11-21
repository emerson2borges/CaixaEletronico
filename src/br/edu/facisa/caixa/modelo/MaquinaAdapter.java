package br.edu.facisa.caixa.modelo;

import java.util.LinkedList;
import java.util.List;

import br.edu.facisa.caixa.interfac.IMaquinaDeEstados;
import br.edu.facisa.caixa.interfac.MaquinaDeEstadosListener;

public abstract class MaquinaAdapter implements IMaquinaDeEstados {

	protected static final String ESTADO_INICIAL = "Inicial";

	protected static final String REALIZANDO_DEPOSITO = "Em Deposito";

	protected static final String ESCOLHENDO_BANCO = "Escolhendo Banco";

	protected static final String DIGITANDO_CONTA = "Digitando Conta";

	protected static final String DIGITANDO_SENHA = "Digitando Senha";
	
	protected static final String DIGITANDO_OPCAO = "Digitando Opcao";
	
	protected static final String VENDO_EXTRATO = "Vendo Extrato";
	
	protected static final String VENDO_SALDO = "Vendo Saldo";
	
	protected static final String SACANDO = "Sacando"; 
	
	protected static final String TRANSFERENCIA = "Transferencia";
	
	protected static final String DIGITANDO_VALOR = "Digitando valor";
	
	protected static final String ESCOLHENDO_OPERADORA = "Escolhendo operadora";
	
	protected static final String VALORES_OI = "Valores oi";
	
	protected static final String VALORES_TIM = "Valores tim";
	
	protected static final String VALORES_CLARO = "Valores claro";
	
	protected static final String VALORES_VIVO = "Valores vivo";
	
	protected static final String INFORMANDO_NUMERO = "Informando Numero";


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
