package br.edu.facisa.caixa.caixaeconomica;

import br.edu.facisa.caixa.interfac.GerenciaContaSingleton;
import br.edu.facisa.caixa.modelo.Conta;
import br.edu.facisa.caixa.modelo.Envelope;
import br.edu.facisa.caixa.modelo.MaquinaAdapter;
import br.edu.facisa.caixa.modelo.MaquinaDeEstadosEvent;



public class MaquinaCaixaEconomica extends MaquinaAdapter {
	private int contaDigitada;
	private int senhaDigitada;
	private String asteriscos = "";
	private String opcao;
	private Conta contaAtual;
	private GerenciaContaSingleton gerenciaConta;
	private int tentativa;
	
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
	
	@Override
	public void inicia() {
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
		
	}

	@Override
	public void teclaNum01Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(1);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(1);
		}
	}

	@Override
	public void teclaNum02Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(2);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(2);
		}
	}

	@Override
	public void teclaNum03Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(3);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(3);
		}
	}

	@Override
	public void teclaNum04Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(4);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(4);
		}
	}

	@Override
	public void teclaNum05Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(5);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(5);
		}		
	}

	@Override
	public void teclaNum06Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(6);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(6);
		}
		
	}

	@Override
	public void teclaNum07Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(7);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(7);
		}
	}

	@Override
	public void teclaNum08Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(8);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(8);
		}
	}

	@Override
	public void teclaNum09Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(9);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(9);
		}
	}

	@Override
	public void teclaNum00Digitada() {
		if(this.estado == DIGITANDO_CONTA){
			processaConta(0);
		}else if(this.estado == DIGITANDO_SENHA){
			processaSenha(0);
		}
	}

	@Override
	public void teclaConfirmaDigitada() {
		if(this.estado == DIGITANDO_CONTA){
			contaAtual = GerenciaContaSingleton.getInstancia().getConta(contaDigitada);
			if(contaAtual.getNumeroConta() == contaDigitada && tentativa < 3){
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
			System.out.println(contaAtual.getSenha());
			if(contaAtual.getSenha() == senhaDigitada){
				this.estado = DIGITANDO_OPCAO;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Escolha uma opção\n"
						+"A - Saldo    B - Saque\n"
						+ "C - Creditos");
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
		}else if(this.estado == DIGITANDO_OPCAO){
			if(this.opcao.equals("A")){
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Saldo: R$"+ contaAtual.getSaldo());
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
			this.senhaDigitada = 0;
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
		}
		
	}

	@Override
	public void teclaEsquerda01Digitada() {
		if(this.estado == DIGITANDO_OPCAO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela("Digite confirma para acessar esta opção");
			opcao = "A";
			notificaMudanca(evento);
		}
		
	}

	@Override
	public void teclaEsquerda02Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaEsquerda03Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaEsquerda04Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaDireita01Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaDireita02Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaDireita03Digitada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void teclaDireita04Digitada() {
		// TODO Auto-generated method stub
		
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