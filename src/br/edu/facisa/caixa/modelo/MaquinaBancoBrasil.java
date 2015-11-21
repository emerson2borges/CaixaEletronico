package br.edu.facisa.caixa.modelo;

import java.util.LinkedList;
import java.util.List;
import br.edu.facisa.caixa.interfac.GerenciaContaBBSingleton;
import br.edu.facisa.caixa.interfac.MaquinaDeEstadosListener;
import br.edu.facisa.caixa.modelo.Conta;
import br.edu.facisa.caixa.modelo.Envelope;
import br.edu.facisa.caixa.modelo.MaquinaAdapter;
import br.edu.facisa.caixa.modelo.MaquinaDeEstadosEvent;

public class MaquinaBancoBrasil extends MaquinaAdapter {

	private static final int TOTAL_TENTATIVAS = 3;
	private int contaDigitada;
	private int senhaDigitada;
	private String senhaDigitadaBB;
	private int valorDigitado;
	private String asteriscos = "";
	private int opcao = 0;
	private Conta contaAtual;
	private GerenciaContaBBSingleton gerenciaConta;
	private int tentativa;
	private Conta contaTransferencia;

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
		evento.setNovaTela("BEM-VINDO AO BANCO DO BRASIL\n" + " - Informe a sua conta:");
		notificaMudanca(evento);

	}

	public void para() {
		this.senhaDigitada = 0;
		this.asteriscos = "";
		this.contaDigitada = 0;
		this.valorDigitado = 0;
		this.tentativa = 0;

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
		evento.setNovaTela("Digite 1 para q w e\n"
						 + "Digite 2 para r t y\n"
						 + "Digite 3 para u i o\n"
						 + "Digite 4 para p a s\n"
						 + "Digite 5 para d f g\n"
						 + "Digite 6 para h j k\n"
						 + "Digite 7 para k l z\n"
						 + "Digite 8 para x c v\n"
						 + "digite 9 para b n m\n"
						 + " - Continue a digitar a senha ou digite CONFIRMA\n - Senha atual: " + asteriscos);
		notificaMudanca(evento);
	}
	
	private void processaValorDigitado(int i) {
		this.valorDigitado *= 10;
		this.valorDigitado += i;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela(" - Continue a digitar a conta ou digite CONFIRMA\n - Valor atual: " + this.valorDigitado);
		notificaMudanca(evento);
	}

	public void teclaNum01Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(1);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(1);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(1);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(1);
		}
	}

	public void teclaNum02Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(2);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(2);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(2);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(2);
		}

	}

	public void teclaNum03Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(3);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(3);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(3);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(3);
		}

	}

	public void teclaNum04Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(4);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(4);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(4);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(4);
		}

	}

	public void teclaNum05Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(5);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(5);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(5);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(5);
		}

	}

	public void teclaNum06Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(6);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(6);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(6);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(6);
		}
	}

	public void teclaNum07Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(7);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(7);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(7);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(7);
		}

	}

	public void teclaNum08Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(8);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(8);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(8);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(8);
		}

	}

	public void teclaNum09Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(9);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(9);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(9);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(9);
		}

	}

	public void teclaNum00Digitada() {
		if (this.estado == DIGITANDO_CONTA) {
			processaConta(0);
		} else if (this.estado == DIGITANDO_SENHA) {
			processaSenha(0);
		} else if (this.estado == SACANDO) {
			processaValorDigitado(0);
		}else if (this.estado == TRANSFERENCIA) {
			processaValorDigitado(0);
		}

	}

	public void teclaConfirmaDigitada() {
		if (this.estado == DIGITANDO_CONTA) {
			contaAtual = GerenciaContaBBSingleton.getInstancia().getConta(contaDigitada);
			if (contaAtual.getNumeroConta() == contaDigitada && tentativa < TOTAL_TENTATIVAS) {
				this.estado = DIGITANDO_OPCAO;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Saldo\nB) Saque\nC) Transferência");
				//opcao = 1;
				notificaMudanca(evento);
			} else if (tentativa == 3) {
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("- Conta Bloqueada -\n Procure a Agencia mais proxima!");
				notificaMudanca(evento);
			} else {
				this.estado = DIGITANDO_CONTA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela(" - Conta Invalida -\n" + "Digite a conta novamente");
				tentativa += 1;
				this.contaAtual.setTentativa(tentativa);
				this.contaDigitada = 0;
				notificaMudanca(evento);
			}

		} else if (this.estado == DIGITANDO_SENHA && opcao == 1) {
			if(contaAtual.getSenha() == senhaDigitada){
				this.estado = VENDO_SALDO;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("SALDO\n" + "Saldo Hoje: R$ " + contaAtual.getSaldo());
				notificaMudanca(evento);
			} else if(this.contaAtual.getTentativa() < TOTAL_TENTATIVAS){
				this.estado = DIGITANDO_SENHA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Senha Inválida.\n Digite a senha novamente");
				this.senhaDigitada = 0;
				this.asteriscos = "";
				notificaMudanca(evento);
				this.contaAtual.setTentativa(contaAtual.getTentativa() + 1);
			} else{
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("Caixa Padrao");
				this.contaDigitada = 0;
				this.senhaDigitada = 0;
				this.asteriscos = "";
				notificaMudanca(evento);
			}
		} else if (this.estado == DIGITANDO_SENHA && opcao == 2) {
			if (contaAtual.getSenha() == senhaDigitada){
				this.estado = SACANDO;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("SAQUE:\n" + "Seu saldo atual: " + contaAtual.getSaldo() + "\nDigite o valor a ser sacado e digite CONFIRMA: ");
				notificaMudanca(evento);
				
				if(contaAtual.getSaldo() >= valorDigitado){
					this.estado = DIGITANDO_VALOR;
					contaAtual.setSaldo(contaAtual.getSaldo() - valorDigitado);
					evento.setNovaTela(" - Saque Realizado com Sucesso. Liberando Cédulas\n Seu novo saldo é: R$" + contaAtual.getSaldo() + "\nDigite CONFIRMA");
					notificaMudanca(evento);
				} else{
					this.estado = DIGITANDO_OPCAO;
					evento.setNovaTela("SAQUE:\n Saldo insuficiente. Digite CONFIRMA");
					notificaMudanca(evento);
				}
			} else if(this.contaAtual.getTentativa() < TOTAL_TENTATIVAS){
				this.estado = DIGITANDO_SENHA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Senha Invalida\n"+"Digite a senha novamente");
				this.senhaDigitada = 0;
				this.asteriscos="";
				notificaMudanca(evento);
				this.contaAtual.setTentativa(contaAtual.getTentativa()+1);
			} else{
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("Caixa Padrao");
				this.contaDigitada = 0;
				this.senhaDigitada = 0;
				this.asteriscos = "";
				notificaMudanca(evento);
			}

		} else if (this.estado == DIGITANDO_SENHA && opcao == 3){
			if (contaAtual.getSenha() == senhaDigitada){
				this.estado = TRANSFERENCIA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("TRANSFERÊNCIA:\n" + "Seu saldo atual: " + contaAtual.getSaldo() + "\nDigite o valor a ser transferido e digite CONFIRMA: ");
				notificaMudanca(evento);
				
				if(GerenciaContaBBSingleton.getInstancia().getConta(contaDigitada).getNumeroConta() == contaDigitada){
					this.estado = DIGITANDO_VALOR;
					this.contaTransferencia = GerenciaContaBBSingleton.getInstancia().getConta(contaDigitada);
					//evento.setNovaTela(" - Digite o valor a ser transferido e digite CONFIRMA:");
					//notificaMudanca(evento);
					if(contaAtual.getSaldo() >= valorDigitado){
						contaAtual.setSaldo(contaAtual.getSaldo()-valorDigitado);
						contaTransferencia.setSaldo(contaTransferencia.getSaldo()+valorDigitado);
						evento.setNovaTela("-Tranferencia Realizada-\n"
								         + "Conta: " + contaTransferencia.getNumeroConta()
								         + "\nBanco: " + contaTransferencia.getBanco()
								         + "\nValor: R$" + valorDigitado
								         + "\nDigite CANCELA para finalizar");
						notificaMudanca(evento);
					}
				} else{
					this.estado = DIGITANDO_OPCAO;
					evento.setNovaTela("TRANSFERêNCIA:\n Saldo insuficiente para realizar a transferência. Digite CONFIRMA");
					notificaMudanca(evento);
				}
				this.estado = TRANSFERENCIA;
			} else if(this.contaAtual.getTentativa() < TOTAL_TENTATIVAS){
				this.estado = DIGITANDO_SENHA;
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setNovaTela("Senha Invalida\n"+"Digite a senha novamente");
				this.senhaDigitada = 0;
				this.asteriscos="";
				notificaMudanca(evento);
				this.contaAtual.setTentativa(contaAtual.getTentativa()+1);
			} else{
				MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
				evento.setTrocaMaquinaDeEstados("Caixa Padrao");
				this.contaDigitada = 0;
				this.senhaDigitada = 0;
				this.asteriscos = "";
				notificaMudanca(evento);
			}
		}
	}

	public void teclaCorrigeDigitada() {
		if(this.estado == DIGITANDO_CONTA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite conta");
			this.contaDigitada = 0;
			notificaMudanca(evento);
		} if(this.estado == DIGITANDO_SENHA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite a senha");
			this.senhaDigitada = 0;
			notificaMudanca(evento);
		} else if(this.estado == SACANDO){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite o valor");
			this.valorDigitado = 0;
			notificaMudanca(evento);
		} else if(this.estado == TRANSFERENCIA){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite o valor");
			this.valorDigitado = 0;
			notificaMudanca(evento);
		} else if(this.estado == DIGITANDO_VALOR){
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Digite o valor");
			this.valorDigitado = 0;
			notificaMudanca(evento);
		}

	}

	public void teclaCancelarDigitada() {
		if (this.estado == VENDO_SALDO) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Saldo\nB) Saque\nC) Transferência");
			this.senhaDigitada = 0;
			this.asteriscos = "";
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_OPCAO) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Saldo\nB) Saque\nC) Transferência");
			this.senhaDigitada = 0;
			this.asteriscos = "";
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_SENHA) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Saldo\nB) Saque\nC) Transferência");
			this.senhaDigitada = 0;
			this.asteriscos = "";
			notificaMudanca(evento);
		} else if (this.estado == DIGITANDO_CONTA) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Saldo\nB) Saque\nC) Transferência");
			this.senhaDigitada = 0;
			this.asteriscos = "";
			notificaMudanca(evento);
		}else if (this.estado == (DIGITANDO_VALOR)) {
			this.estado = DIGITANDO_OPCAO;
			MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
			evento.setNovaTela(" - Escolha uma OPCAO\n" + "A) Saldo\nB) Saque\nC) Transferência");
			this.senhaDigitada = 0;
			this.asteriscos = "";
			notificaMudanca(evento);
		}
		/*
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
		}
		*/
		

	}

	public void teclaEsquerda01Digitada() {
		opcao = 1;
		this.estado = DIGITANDO_SENHA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("Digite 1 para q w e\n"
						 + "Digite 2 para r t y\n"
						 + "Digite 3 para u i o\n"
						 + "Digite 4 para p a s\n"
						 + "Digite 5 para d f g\n"
						 + "Digite 6 para h j k\n"
						 + "Digite 7 para k l z\n"
						 + "Digite 8 para x c v\n"
						 + "Digite 9 para b n m\n"
						 + " - Continue a digitar a senha ou digite CONFIRMA\n");
		notificaMudanca(evento);

	}

	public void teclaEsquerda02Digitada() {
		opcao = 2;
		this.estado = DIGITANDO_SENHA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("Digite 1 para q w e\n"
						 + "Digite 2 para r t y\n"
						 + "Digite 3 para u i o\n"
						 + "Digite 4 para p a s\n"
						 + "Digite 5 para d f g\n"
						 + "Digite 6 para h j k\n"
						 + "Digite 7 para k l z\n"
						 + "Digite 8 para x c v\n"
						 + "Digite 9 para b n m\n"
						 + " - Continue a digitar a senha ou digite CONFIRMA\n");
		notificaMudanca(evento);

	}

	public void teclaEsquerda03Digitada() {
		opcao = 3;
		this.estado = DIGITANDO_SENHA;
		MaquinaDeEstadosEvent evento = new MaquinaDeEstadosEvent();
		evento.setNovaTela("Digite 1 para q w e\n"
						 + "Digite 2 para r t y\n"
						 + "Digite 3 para u i o\n"
						 + "Digite 4 para p a s\n"
						 + "Digite 5 para d f g\n"
						 + "Digite 6 para h j k\n"
						 + "Digite 7 para k l z\n"
						 + "Digite 8 para x c v\n"
						 + "Digite 9 para b n m\n"
						 + " - Continue a digitar a senha ou digite CONFIRMA\n");
		notificaMudanca(evento);

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
