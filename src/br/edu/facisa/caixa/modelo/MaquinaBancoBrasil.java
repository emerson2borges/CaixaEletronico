package br.edu.facisa.caixa.modelo;

import java.util.LinkedList;
import java.util.List;

public class MaquinaBancoBrasil extends MaquinaAdapter {

	private int contaDigitada;
	private int senhaDigitada;
	private String asteriscos = "";
	private int opcao = 0;

	private List<MaquinaDeEstadosListener> listeners = new LinkedList<MaquinaDeEstadosListener>();

	public boolean adicionaMaquinaDeEstadosListener(MaquinaDeEstadosListener listener) {
		return this.listeners.add(listener);
	}

	public boolean removeMaquinaDeEstadosListener(MaquinaDeEstadosListener listener) {
		return this.listeners.remove(listener);
	}

	public void notificaMudanca(MaquinaDeEstadosEvent evento) {
		for (MaquinaDeEstadosListener listener : listeners) {
			listener.houveMudanca(evento);
		}
	}

	public void inicia() {
		this.estado = DIGITANDO_CONTA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("BEM-VINDO AO BANCO DO BRASIL\n - Informe a sua conta:");
		notificaMudanca(evento);
		// TODO Auto-generated method stub

	}

	public void para() {
		// TODO Auto-generated method stub

	}

	private void processaConta(int i) {
		this.contaDigitada *= 10;
		this.contaDigitada += i;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a conta ou digite CONFIRMA\n - Conta atual : " + this.contaDigitada);
		notificaMudanca(evento);
	}

	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a senha ou digite CONFIRMA\n - Senha atual : " + asteriscos);
		notificaMudanca(evento);
	}

	public void teclaNum01Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(1);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(1);
		}
	}

	public void teclaNum02Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(2);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(2);
		}

	}

	public void teclaNum03Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(3);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(3);
		}

	}

	public void teclaNum04Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(4);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(4);
		}

	}

	public void teclaNum05Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(5);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(5);
		}

	}

	public void teclaNum06Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(6);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(6);
		}
	}

	public void teclaNum07Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(7);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(7);
		}

	}

	public void teclaNum08Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(8);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(8);
		}

	}

	public void teclaNum09Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(9);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(9);
		}

	}

	public void teclaNum00Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(0);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(0);
		}

	}

	public void teclaConfirmaDigitada() {
		if (this.estado == DIGITANDO_CONTA) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Extrato\n" + "B) Saque\n");
			opcao = 1;
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_SENHA && opcao == 1) {
			this.estado = VENDO_EXTRATO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("EXTRATO\n"
						+ "Saldo em 01/11: R$1000,00\n"
						+ "05/11: Saque: R$500,00\n"
						+ "09/11: Deposito: R$200,00\n"
						+ "Saldo Atual: R$700,00");
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_SENHA && opcao == 2) {
			float meuSaldo = 1000;
			this.estado = SACANDO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("SAQUE:\n"
					+ "Seu saldo: " + meuSaldo
					+ "\nDigite o valor a sacar: ");
			opcao = 2;
			notificaMudanca(evento);
		}
	}

	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub

	}

	public void teclaCancelarDigitada() {
		if (this.estado == VENDO_EXTRATO) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Extrato\n" + "B) Saldo\n");
			this.senhaDigitada = 0;
			this.asteriscos = "";
			notificaMudanca(evento);
		}

	}

	public void teclaEsquerda01Digitada() {
		opcao = 1;
		this.estado = DIGITANDO_SENHA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Digite a senha ou digite CONFIRMA\n");
		notificaMudanca(evento);

	}

	public void teclaEsquerda02Digitada() {
		opcao = 2;
		this.estado = DIGITANDO_SENHA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Digite a senha ou digite CONFIRMA\n");
		notificaMudanca(evento);

	}

	public void teclaEsquerda03Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaEsquerda04Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaDireita01Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaDireita02Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaDireita03Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaDireita04Digitada() {
		// TODO Auto-generated method stub

	}

	public void codigoBarraLido(String codigo) {
		// TODO Auto-generated method stub

	}

	public void envelopeInserido(Envelope informacoes) {
		// TODO Auto-generated method stub

	}

}
