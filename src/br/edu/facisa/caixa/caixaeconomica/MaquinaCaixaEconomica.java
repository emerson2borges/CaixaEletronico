package br.edu.facisa.caixa.caixaeconomica;

import br.edu.facisa.caixa.modelo.Conta;
import br.edu.facisa.caixa.modelo.Envelope;
import br.edu.facisa.caixa.interfac.GerenciaContaSingleton;
import br.edu.facisa.caixa.modelo.MaquinaAdapter;
import br.edu.facisa.caixa.modelo.MaquinaDeEstadosEvent;



public class MaquinaCaixaEconomica extends MaquinaAdapter {
	private static final String OPCAO_INVALIDA = "Opção invalida";
	private int contaDigitada;
	private int senhaDigitada;
	private String asteriscos = "";
	private Conta contaAtual;
	private GerenciaContaSingleton gerenciaConta;
	private int tentativa;
	private int valor;
	private Conta contaTransferencia;
	private String numeroDigitado;
	
	private void processaConta(int i) {
		this.contaDigitada *= 10;
		this.contaDigitada += i;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a conta ou digite CONFIRMA\n - Conta atual : " + this.contaDigitada);
		notificaMudanca(evento);
	}
	private void processaNumero(int i) {
		this.numeroDigitado+=""+i;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar o numero ou digite CONFIRMA\n - Numero : " + this.numeroDigitado);
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
	private void processaValor(int i){
		this.valor*=10;
		this.valor+=i;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar o valor ou digite CONFIRMA\n - Valor : R$" + this.valor);
		notificaMudanca(evento);
	}
	
	@Override
	public void inicia() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		this.contaDigitada = 0;
		this.valor = 0;
		this.tentativa = 0;
		this.numeroDigitado="";
		this.estado = DIGITANDO_CONTA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("Bem-vindo a Caixa Economica\n"
				+"- Informe sua conta: ");
		notificaMudanca(evento);
		
	}

	@Override
	public void para() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		this.contaDigitada = 0;
		this.valor = 0;
		this.tentativa = 0;
		
	}

	@Override
	public void teclaNum01Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(1);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(1);
		}else if(this.estado == SACANDO){
			processaValor(1);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(1);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(1);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(1);
		}
	}

	@Override
	public void teclaNum02Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(2);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(2);
		}else if(this.estado == SACANDO){
			processaValor(2);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(2);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(2);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(2);
		}
	}

	@Override
	public void teclaNum03Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(3);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(3);
		}else if(this.estado == SACANDO){
			processaValor(3);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(3);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(3);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(3);
		}
	}

	@Override
	public void teclaNum04Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(4);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(4);
		}else if(this.estado == SACANDO){
			processaValor(4);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(4);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(4);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(4);
		}
	}

	@Override
	public void teclaNum05Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(5);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(5);
		}else if(this.estado == SACANDO){
			processaValor(5);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(5);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(5);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(5);
		}
	}

	@Override
	public void teclaNum06Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(6);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(6);
		}else if(this.estado == SACANDO){
			processaValor(6);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(6);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(6);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(6);
		}
	}

	@Override
	public void teclaNum07Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(7);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(7);
		}else if(this.estado == SACANDO){
			processaValor(7);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(7);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(7);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(7);
		}
	}

	@Override
	public void teclaNum08Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(8);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(8);
		}else if(this.estado == SACANDO){
			processaValor(8);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(8);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(8);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(8);
		}
	}

	@Override
	public void teclaNum09Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(9);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(9);
		}else if(this.estado == SACANDO){
			processaValor(9);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(9);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(9);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(9);
		}
	}

	@Override
	public void teclaNum00Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(0);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(0);
		}else if(this.estado == SACANDO){
			processaValor(0);
		}else if(this.estado == TRANSFERENCIA){
			processaConta(0);
		}else if(this.estado == DIGITANDO_VALOR){
			processaValor(0);
		}else if(this.estado == INFORMANDO_NUMERO){
			processaNumero(0);
		}
	}

	@Override
	public void teclaConfirmaDigitada() {
		if(this.estado == DIGITANDO_CONTA){
			contaAtual = gerenciaConta.getInstancia().getConta(contaDigitada);
			if(contaAtual.getNumeroConta() == contaDigitada && contaAtual.getBanco().equals("Caixa Economica") && tentativa < 3){
				this.estado = DIGITANDO_SENHA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(" - Digite a senha ou digite CONFIRMA");
				notificaMudanca(evento);
			}else if(tentativa==3) {
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("- Conta Bloqueada -\n Procure a Agencia mais proxima!");
				notificaMudanca(evento);
			}else{
				this.estado = DIGITANDO_CONTA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(" - Conta Invalida -\n"+"Digite a conta novamente");
				tentativa+=1;
				this.contaAtual.setTentativa(tentativa);
				this.contaDigitada = 0;
				notificaMudanca(evento);
			}
		}else if(this.estado == DIGITANDO_SENHA){
			if(contaAtual.getSenha() == senhaDigitada){
				this.estado = DIGITANDO_OPCAO;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Escolha uma opção\n"
						+"A - SALDO\n"
						+"B - SAQUE\n"
						+"C - TRANSFERENCIA\n"
						+"D - CREDITO");
				notificaMudanca(evento);
			}else if(this.contaAtual.getTentativa() < 3){
				this.estado = DIGITANDO_SENHA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Senha Invalida\n"+"Digite a senha novamente");
				this.senhaDigitada = 0;
				this.asteriscos="";
				notificaMudanca(evento);
				this.contaAtual.setTentativa(contaAtual.getTentativa()+1);
			}else{
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("Caixa Padrao");
				this.contaDigitada = 0;
				this.senhaDigitada = 0;
				this.asteriscos = "";
				notificaMudanca(evento);
			}
		}else if(this.estado == VENDO_SALDO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Saldo: R$"+ contaAtual.getSaldo()
					+" -\n- Digite cancela para finalizar a operação -");
			notificaMudanca(evento);
		}else if(this.estado == SACANDO){
			if(valor <= contaAtual.getSaldo()){
				contaAtual.setSaldo(contaAtual.getSaldo()-valor);
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("- Saque Realizado -"
						+"\n\n- Digite Cancela para finalizar -");
				notificaMudanca(evento);
			}
		}else if(this.estado == TRANSFERENCIA){
			if(gerenciaConta.getInstancia().getConta(contaDigitada).getNumeroConta() == contaDigitada){
				this.estado = DIGITANDO_VALOR;
				this.contaTransferencia = GerenciaContaSingleton.getInstancia().getConta(contaDigitada);
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(" - Digite o valor -");
				notificaMudanca(evento);
			}
		}else if(this.estado == DIGITANDO_VALOR){
			if(valor <= contaAtual.getSaldo()){
				this.contaTransferencia = gerenciaConta.getConta(contaDigitada); 
				contaAtual.setSaldo(contaAtual.getSaldo()-valor);
				contaTransferencia.setSaldo(contaTransferencia.getSaldo()+valor);
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("-Tranferencia Realizada-"+
						"\nBanco: "+contaTransferencia.getBanco()+
						"\nAgencia: "+contaTransferencia.getAgencia()+
						"\nNumero: "+contaTransferencia.getNumeroConta()+
						"\nNome: "+contaTransferencia.getNome()+
						"\nValor: R$"+valor+
						"\n-Digite Cancela para finalizar-");
				notificaMudanca(evento);
			}
		}else if(this.estado == INFORMANDO_NUMERO){
			if(this.valor <= contaAtual.getSaldo()){
				contaAtual.setSaldo(contaAtual.getSaldo()-this.valor);
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("-Creditos inseridos-"+
				"\nNumero: "+this.numeroDigitado+"\nValor: R$"+this.valor);
				notificaMudanca(evento);
			}else{
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("-Saldo Insuficiente-");
				notificaMudanca(evento);
			}
		}
	}

	@Override
	public void teclaCorrigeDigitada() {
		if(this.estado == DIGITANDO_CONTA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite a conta ou digite CONFIRMA");
			this.contaDigitada = 0;
			notificaMudanca(evento);
		}else if(this.estado == DIGITANDO_SENHA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Digite a senha -");
			this.senhaDigitada = 0;
			notificaMudanca(evento);
		}else if(this.estado == SACANDO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Digite o valor -");
			this.valor = 0;
			notificaMudanca(evento);
		}else if(this.estado == TRANSFERENCIA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Informe a conta para Tranferencia-");
			this.contaDigitada = 0;
			notificaMudanca(evento);
		}else if(this.estado == DIGITANDO_VALOR){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Informe o valor-");
			this.valor = 0;
			notificaMudanca(evento);
		}else if(this.estado == DIGITANDO_VALOR){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Informe o numero-");
			this.numeroDigitado = "";
			notificaMudanca(evento);
		}
	}

	@Override
	public void teclaCancelarDigitada() {
		if(this.estado == DIGITANDO_CONTA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Padrao");
			notificaMudanca(evento);
		}else if(this.estado == DIGITANDO_SENHA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Padrao");
			notificaMudanca(evento);
		}else if(this.estado == VENDO_SALDO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Padrao");
			notificaMudanca(evento);
		}else if(this.estado == SACANDO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Padrao");
			notificaMudanca(evento);
		}else if(this.estado == DIGITANDO_VALOR){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Padrao");
			notificaMudanca(evento);
		}else if(this.estado == INFORMANDO_NUMERO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setTrocaMaquinaDeEstados("Caixa Padrao");
			notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaEsquerda01Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			this.estado = VENDO_SALDO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Digite confirma para acessar esta opção -");
			notificaMudanca(evento);
		}else if(this.estado == ESCOLHENDO_OPERADORA){
			this.estado = VALORES_OI;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Escolha o valor-"+
			"\nA - R$1,00\nB - R$20,00\nC - R$30,00\nD - R$60,00");
			notificaMudanca(evento);
		}else if(this.estado == VALORES_OI){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 1;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_TIM){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 15;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_CLARO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 13;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_VIVO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 5;
			notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaEsquerda02Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			this.estado = SACANDO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- Informe o valor de saque -");
			notificaMudanca(evento);
		}else if(this.estado == VALORES_OI){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 20;
			notificaMudanca(evento);
		}else if(this.estado == ESCOLHENDO_OPERADORA){
			this.estado = VALORES_TIM;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Escolha o valor-"+
			"\nA - R$15,00\nB - R$20,00\nC - R$30,00\nD - R$50,00");
			notificaMudanca(evento);
			
		}else if(this.estado == VALORES_TIM){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 20;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_CLARO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 15;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_VIVO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 10;
			notificaMudanca(evento);
		}
	}

	@Override
	public void teclaEsquerda03Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			this.estado = TRANSFERENCIA;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("- informe a conta para a transferencia -");
			contaDigitada=0;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_OI){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 30;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_TIM){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 30;
			notificaMudanca(evento);
		}else if(this.estado == ESCOLHENDO_OPERADORA){
			this.estado = VALORES_CLARO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Escolha o valor-"+
			"\nA - R$13,00\nB - R$15,00\nC - R$20,00\nD - R$30,00");
			notificaMudanca(evento);
		}else if(this.estado == VALORES_CLARO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 20;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_VIVO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 15;
			notificaMudanca(evento);
		}
	}

	@Override
	public void teclaEsquerda04Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			this.estado = ESCOLHENDO_OPERADORA;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Escolha a operadora-"+
								"\nA - OI\nB - TIM\nC - CLARO\nD - VIVO");
			notificaMudanca(evento);
		}else if(this.estado == VALORES_OI){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 60;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_TIM){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 50;
			notificaMudanca(evento);
		}else if(this.estado == VALORES_CLARO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 30;
			notificaMudanca(evento);
		}else if(this.estado == ESCOLHENDO_OPERADORA){
			this.estado = VALORES_VIVO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-Escolha o valor-"+
			"\nA - R$5,00\nB - R$10,00\nC - R$15,00\nD - R$20,00");
			notificaMudanca(evento);
		}else if(this.estado == VALORES_VIVO){
			this.estado = INFORMANDO_NUMERO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("-informe o numero-");
			this.valor = 20;
			notificaMudanca(evento);
		}
	}

	@Override
	public void teclaDireita01Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(this.OPCAO_INVALIDA);
			notificaMudanca(evento);
		}
	}

	@Override
	public void teclaDireita02Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(this.OPCAO_INVALIDA);
			notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaDireita03Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(this.OPCAO_INVALIDA);
			notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaDireita04Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(this.OPCAO_INVALIDA);
			notificaMudanca(evento);
		}
		
	}

	@Override
	public void codigoBarraLido(String codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envelopeInserido(Envelope informacoes) {
		// TODO Auto-generated method stub
		
	}
}