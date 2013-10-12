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
public class TipoJogadaTest {

	public TipoJogadaTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of values method, of class TipoJogada.
	 */
	@Test
	public void testValues() {
		System.out.println("values");
		TipoJogada[] expResult = {TipoJogada.ABRIR, TipoJogada.MARCAR};
		TipoJogada[] result = TipoJogada.values();
		assertArrayEquals(expResult, result);
	}

	/**
	 * Test of valueOf method, of class TipoJogada.
	 */
	@Test
	public void testValueOf() {
		System.out.println("valueOf");
		assertEquals(TipoJogada.ABRIR, TipoJogada.valueOf("ABRIR"));
		assertEquals(TipoJogada.MARCAR, TipoJogada.valueOf("MARCAR"));
	}

	/**
	 * Test of isABRIR method, of class TipoJogada.
	 */
	@Test
	public void testIsABRIR() {
		System.out.println("isABRIR");
		TipoJogada instance = null;
		try {
			assertFalse(instance.isABRIR());
		} catch (NullPointerException exception) {
		}
		instance = TipoJogada.ABRIR;
		assertTrue(instance.isABRIR());

		instance = TipoJogada.MARCAR;
		assertFalse(instance.isABRIR());
	}

	/**
	 * Test of isMARCAR method, of class TipoJogada.
	 */
	@Test
	public void testIsMARCAR() {
		System.out.println("isMARCAR");
		TipoJogada instance = null;
		try {
			assertFalse(instance.isMARCAR());
		} catch (NullPointerException exception) {
		}
		instance = TipoJogada.ABRIR;
		assertFalse(instance.isMARCAR());

		instance = TipoJogada.MARCAR;
		assertTrue(instance.isMARCAR());
	}
}