package br.edu.facisa.caixa.testes;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.facisa.caixa.modelo.MaquinaDeEstadosFactory;

public class MaquinaEstadosFactoryTeste {

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
	public void testSantander() {
		assertNotNull(MaquinaDeEstadosFactory.criaMaquinaSatander());
	}

	@Test
	public void testBB() {
		assertNull(MaquinaDeEstadosFactory.criaMaquinaBancoDoBrasil());
		//assertNotNull(MaquinaDeEstadosFactory.criaMaquinaBancoDoBrasil());
	}
}
