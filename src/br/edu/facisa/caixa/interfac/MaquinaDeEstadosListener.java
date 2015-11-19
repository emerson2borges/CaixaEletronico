package br.edu.facisa.caixa.interfac;

import br.edu.facisa.caixa.modelo.MaquinaDeEstadosEvent;

public interface MaquinaDeEstadosListener {

	public void houveMudanca(MaquinaDeEstadosEvent mudanca);
	
}
