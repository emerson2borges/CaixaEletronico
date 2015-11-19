package br.edu.facisa.caixa.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.facisa.caixa.factory.MaquinaDeEstadosFactory;
import br.edu.facisa.caixa.modelo.DadosFacade;

public class DadosFacadeTeste {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertNotNull(DadosFacade.getInstance());
	}

	@Test
	public void testNull() {
		assertNotNull(DadosFacade.getInstance());
	}


}
