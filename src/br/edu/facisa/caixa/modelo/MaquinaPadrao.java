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
		if (this.estado == ESCOLHENDO_BANCO) {
			MaquinaDeEstadosEvent e = new MaquinaDeEstadosEvent();
			e.setTrocaMaquinaDeEstados("Caixa Economica");
			notificaMudanca(e);
		}	
	}

	public void teclaNum04Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaNum05Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaNum06Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaNum07Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaNum08Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaNum09Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaNum00Digitada() {
		// TODO Auto-generated method stub

	}

	public void teclaConfirmaDigitada() {
		// TODO Auto-generated method stub

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
		if (this.estado.equals(REALIZANDO_DEPOSITO)) {
			
		}
 
	}

}
