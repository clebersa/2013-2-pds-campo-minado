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
public class TipoMarcacaoTest {

	public TipoMarcacaoTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of values method, of class TipoMarcacao.
	 */
	@Test
	public void testValues() {
		System.out.println("values");
		TipoMarcacao[] expResult = {TipoMarcacao.BANDEIRA, TipoMarcacao.DUVIDA,
			TipoMarcacao.NENHUMA};
		TipoMarcacao[] result = TipoMarcacao.values();
		assertArrayEquals(expResult, result);
	}

	/**
	 * Test of valueOf method, of class TipoMarcacao.
	 */
	@Test
	public void testValueOf() {
		System.out.println("valueOf");
		assertEquals(TipoMarcacao.DUVIDA, TipoMarcacao.valueOf("DUVIDA"));
		assertEquals(TipoMarcacao.BANDEIRA, TipoMarcacao.valueOf("BANDEIRA"));
		assertEquals(TipoMarcacao.NENHUMA, TipoMarcacao.valueOf("NENHUMA"));
	}

	/**
	 * Test of isBANDEIRA method, of class TipoMarcacao.
	 */
	@Test
	public void testIsBANDEIRA() {
		System.out.println("isBANDEIRA");
		TipoMarcacao instance;

		instance = TipoMarcacao.DUVIDA;
		assertFalse(instance.isBANDEIRA());

		instance = TipoMarcacao.BANDEIRA;
		assertTrue(instance.isBANDEIRA());

		instance = TipoMarcacao.NENHUMA;
		assertFalse(instance.isBANDEIRA());
	}

	/**
	 * Test of isDUVIDA method, of class TipoMarcacao.
	 */
	@Test
	public void testIsDUVIDA() {
		System.out.println("isDUVIDA");
		TipoMarcacao instance;

		instance = TipoMarcacao.DUVIDA;
		assertTrue(instance.isDUVIDA());

		instance = TipoMarcacao.BANDEIRA;
		assertFalse(instance.isDUVIDA());

		instance = TipoMarcacao.NENHUMA;
		assertFalse(instance.isDUVIDA());
	}

	/**
	 * Test of isNENHUMA method, of class TipoMarcacao.
	 */
	@Test
	public void testIsNENHUMA() {
		System.out.println("isNENHUMA");
		TipoMarcacao instance;

		instance = TipoMarcacao.DUVIDA;
		assertFalse(instance.isNENHUMA());

		instance = TipoMarcacao.BANDEIRA;
		assertFalse(instance.isNENHUMA());

		instance = TipoMarcacao.NENHUMA;
		assertTrue(instance.isNENHUMA());
	}
}