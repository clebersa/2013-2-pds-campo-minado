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
		Jogada instance = null;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertEquals(1, instance.getLinha());
	}

	/**
	 * Test of getColuna method, of class Jogada.
	 */
	@Test
	public void testGetColuna() {
		System.out.println("getColuna");
		Jogada instance = null;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertEquals(2, instance.getColuna());
	}

	/**
	 * Test of getTipo method, of class Jogada.
	 */
	@Test
	public void testGetTipo() {
		System.out.println("getTipo");
		Jogada instance = null;
		instance = new Jogada(1, 2, TipoJogada.ABRIR);
		assertEquals(TipoJogada.ABRIR, instance.getTipo());
		instance = new Jogada(1, 2, TipoJogada.MARCAR);
		assertEquals(TipoJogada.MARCAR, instance.getTipo());
	}
}