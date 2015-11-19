package br.edu.facisa.caixa.modelo;

//import br.edu.facisa.caixa.dao.GenericDao;

public class MaquinaPadrao extends MaquinaAdapter {

	private static final String PARADO = null;

	public void inicia() {
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("Escolha uma opção:\n1) Realizar Deposito\n2) Escolher Banco");
		this.estado = ESTADO_INICIAL;
		notificaMudanca(evento);
	}

	public void para() {
		this.estado = PARADO;
	}
	
	private void solicitaRealizaDeposito() {
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setOperacaoHardware(TipoOperacaoHardware.ABRE_BANDEJA_DEPOSITO);
		this.estado = REALIZANDO_DEPOSITO;
		notificaMudanca(evento);
	}

	public void teclaNum01Digitada() {
		if (this.estado.equals(ESTADO_INICIAL)) {
			solicitaRealizaDeposito();
		}else if(this.estado.equals(ESCOLHENDO_BANCO)){
			MaquinaDeEstadosEvent e = new MaquinaDeEstadosEvent();
			e.setTrocaMaquinaDeEstados("Banco do Brasil");
			notificaMudanca(e);
		
		}
	}

	public void teclaNum02Digitada() {
		if (estado.equals(ESTADO_INICIAL)) {
			MaquinaDeEstadosEvent e = new MaquinaDeEstadosEvent();
			e.setNovaTela("Escolha uma opcao: \n"
					+ "1) Banco do Brasil \n"
					+ "2) Santander \n"
					+ "3) Caixa Economica \n"
					+ "4) Bradesco \n"
					+ "5) Itau ");
			this.estado = ESCOLHENDO_BANCO;
			notificaMudanca(e);
		} else if (this.estado == ESCOLHENDO_BANCO) {
			MaquinaDeEstadosEvent e = new MaquinaDeEstadosEvent();
			e.setTrocaMaquinaDeEstados("Santander");
			notificaMudanca(e);
		
		}
	}

	public void teclaNum03Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}else if (this.estado == ESCOLHENDO_BANCO) {
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Economica");
			notificaMudanca(evento);
		}	
	}

	public void teclaNum04Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaNum05Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaNum06Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaNum07Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaNum08Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaNum09Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaNum00Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaConfirmaDigitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaCorrigeDigitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaCancelarDigitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaEsquerda01Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaEsquerda02Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaEsquerda03Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaEsquerda04Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaDireita01Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaDireita02Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaDireita03Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void teclaDireita04Digitada() {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void codigoBarraLido(String codigo) {
		if(this.estado == ESTADO_INICIAL){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Opcao Invalida -");
			notificaMudanca(evento);
		}
	}

	public void envelopeInserido(Envelope informacoes) {
		if (this.estado.equals(REALIZANDO_DEPOSITO)) {
			
		}
 
	}

}
