package br.edu.facisa.caixa.modelo;

public class MaquinaSantander extends MaquinaAdapter {

	private int contaDigitada;
	private int senhaDigitada;
	private String asteriscos = "";

	public void inicia() {
		this.estado = DIGITANDO_CONTA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("BEM-VINDO AO SANTANDER\n - Informe a sua conta:");
		notificaMudanca(evento);
	}

	public void para() {
		// TODO Auto-generated method stub
		
	}

	public void teclaNum01Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(1);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(1);
		}
	}

	private void processaSenha(int i) {
		this.senhaDigitada *= 10;
		this.senhaDigitada += i;
		this.asteriscos += "*";
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a senha ou digite CONFIRMA\n - Senha atual : " + asteriscos);
		notificaMudanca(evento);
	}

	private void processaConta(int i) {
		this.contaDigitada *= 10;
		this.contaDigitada += i;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a conta ou digite CONFIRMA\n - Conta atual : " + this.contaDigitada);
		notificaMudanca(evento);
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
			this.estado = DIGITANDO_SENHA;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite a senha ou digite CONFIRMA");
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_SENHA) {
			if (DadosFacade.getInstance().validaConta("Santander", contaDigitada, senhaDigitada)) {
				this.estado = ESTADO_INICIAL;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Escolha uma das operações do SANTANDER");
				notificaMudanca(evento);
			} else {
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("Santander");
				notificaMudanca(evento);
			}
		}
	}

	public void teclaCorrigeDigitada() {
		// TODO Auto-generated method stub
		
	}

	public void teclaCancelarDigitada() {
		// TODO Auto-generated method stub
		
	}

	public void teclaEsquerda01Digitada() {
		// TODO Auto-generated method stub
		
	}

	public void teclaEsquerda02Digitada() {
		// TODO Auto-generated method stub
		
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
