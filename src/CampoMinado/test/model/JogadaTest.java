/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleber
 */
public class JogadaTest {
	
	public JogadaTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getLinha method, of class Jogada.
	 */
	@Test
	public void testGetLinha() {
		System.out.println("getLinha");
		Jogada instance;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertEquals(1, instance.getLinha());
	}

	/**
	 * Test of getColuna method, of class Jogada.
	 */
	@Test
	public void testGetColuna() {
		System.out.println("getColuna");
		Jogada instance;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertEquals(2, instance.getColuna());
	}

	/**
	 * Test of isABRIR method, of class Jogada.
	 */
	@Test
	public void testIsABRIR() {
		System.out.println("isABRIR");
		Jogada instance;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertTrue(instance.isABRIR());
		instance = new Jogada(1, 2, TipoJogada.MARCAR);
		assertFalse(instance.isABRIR());
	}

	/**
	 * Test of isMARCAR method, of class Jogada.
	 */
	@Test
	public void testIsMARCAR() {
		System.out.println("isMARCAR");
		Jogada instance;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertFalse(instance.isMARCAR());
		instance = new Jogada(1, 2, TipoJogada.MARCAR);
		assertTrue(instance.isMARCAR());
	}

	
}