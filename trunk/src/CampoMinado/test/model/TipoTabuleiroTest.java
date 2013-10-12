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
public class TipoTabuleiroTest {

	public TipoTabuleiroTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of values method, of class TipoTabuleiro.
	 */
	@Test
	public void testValues() {
		System.out.println("values");
		TipoTabuleiro[] expResult = {TipoTabuleiro.INICIANTE, TipoTabuleiro.INTERMEDIARIO, TipoTabuleiro.AVANCADO};
		TipoTabuleiro[] result = TipoTabuleiro.values();
		assertArrayEquals(expResult, result);
	}

	/**
	 * Test of valueOf method, of class TipoTabuleiro.
	 */
	@Test
	public void testValueOf() {
		System.out.println("valueOf");
		assertEquals(TipoTabuleiro.INICIANTE, TipoTabuleiro.valueOf("INICIANTE"));
		assertEquals(TipoTabuleiro.INTERMEDIARIO, TipoTabuleiro.valueOf("INTERMEDIARIO"));
		assertEquals(TipoTabuleiro.AVANCADO, TipoTabuleiro.valueOf("AVANCADO"));
	}

	/**
	 * Test of getLinhas method, of class TipoTabuleiro.
	 */
	@Test
	public void testGetLinhas() {
		System.out.println("getLinhas");
		TipoTabuleiro instance;

		instance = TipoTabuleiro.INICIANTE;
		assertEquals(9, instance.getLinhas());

		instance = TipoTabuleiro.INTERMEDIARIO;
		assertEquals(16, instance.getLinhas());

		instance = TipoTabuleiro.AVANCADO;
		assertEquals(20, instance.getLinhas());
	}

	/**
	 * Test of getColunas method, of class TipoTabuleiro.
	 */
	@Test
	public void testGetColunas() {
		System.out.println("getColunas");
		TipoTabuleiro instance;
		
		instance = TipoTabuleiro.INICIANTE;
		assertEquals(9, instance.getColunas());

		instance = TipoTabuleiro.INTERMEDIARIO;
		assertEquals(16, instance.getColunas());

		instance = TipoTabuleiro.AVANCADO;
		assertEquals(24, instance.getColunas());
	}

	/**
	 * Test of getMinas method, of class TipoTabuleiro.
	 */
	@Test
	public void testGetMinas() {
		System.out.println("getMinas");
		TipoTabuleiro instance;

		instance = TipoTabuleiro.INICIANTE;
		assertEquals(10, instance.getMinas());

		instance = TipoTabuleiro.INTERMEDIARIO;
		assertEquals(40, instance.getMinas());

		instance = TipoTabuleiro.AVANCADO;
		assertEquals(99, instance.getMinas());
	}
}