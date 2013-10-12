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
public class ConteudoTest {

	public ConteudoTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getIcone method, of class Conteudo.
	 */
	@Test
	public void testGetIcone() {
		System.out.println("getIcone");
		Conteudo instance = new Conteudo();
		String expResult = " ";
		String result = instance.getIcone();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setIcone method, of class Conteudo.
	 */
	@Test
	public void testSetIcone() {
		System.out.println("setIcone");
		Conteudo instance;

		instance = new Conteudo();
		assertEquals(" ", instance.getIcone());

		instance.setIcone(-1);
		assertEquals("M", instance.getIcone());

		for (int icone = 0; icone < 9; icone++) {
			instance.setIcone(icone);
			assertEquals("M", instance.getIcone());
		}

		instance = new Conteudo();
		for (int icone = 1; icone < 9; icone++) {
			instance.setIcone(icone);
			assertEquals(String.format("%d", icone), instance.getIcone());
		}
	}

	/**
	 * Test of getTipo method, of class Conteudo.
	 */
	@Test
	public void testGetTipo() {
		System.out.println("getTipo");
		Conteudo instance;

		instance = new Conteudo();
		assertEquals(TipoConteudo.VAZIO, instance.getTipo());

		instance.setIcone(-1);
		assertEquals(TipoConteudo.MINA, instance.getTipo());

		for (int icone = 0; icone < 9; icone++) {
			instance.setIcone(icone);
			assertEquals(TipoConteudo.MINA, instance.getTipo());
		}

		instance = new Conteudo();
		for (int icone = 1; icone < 9; icone++) {
			instance.setIcone(icone);
			assertEquals(TipoConteudo.NUMERO, instance.getTipo());
		}
	}

	/**
	 * Test of adicionarMina method, of class Conteudo.
	 */
	@Test
	public void testAdicionarMina() {
		System.out.println("adicionarMina");
		Conteudo instance = new Conteudo();
		instance.adicionarMina();
		assertEquals("M", instance.getIcone());
		assertEquals(TipoConteudo.MINA, instance.getTipo());
	}

	/**
	 * Test of isMINA method, of class Conteudo.
	 */
	@Test
	public void testIsMINA() {
		System.out.println("isMINA");
		Conteudo instance = new Conteudo();
		
		assertFalse(instance.isMINA());
		
		instance.adicionarMina();
		assertTrue(instance.isMINA());
		
	}
}