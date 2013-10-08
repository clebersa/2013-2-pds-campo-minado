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
public class MarcacaoTest {

	public MarcacaoTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of marcar method, of class Marcacao.
	 */
	@Test
	public void testMarcar() {
		System.out.println("marcar");
		Marcacao instance = new Marcacao();
		instance.marcar();
		assertEquals("B", instance.getIcone());
		instance.marcar();
		assertEquals("?", instance.getIcone());
		instance.marcar();
		assertEquals(" ", instance.getIcone());
		instance.marcar();
		assertEquals("B", instance.getIcone());
	}

	/**
	 * Test of getIcone method, of class Marcacao.
	 */
	@Test
	public void testGetIcone() {
		System.out.println("getIcone");
		Marcacao instance = new Marcacao();
		String expResult = " ";
		String result = instance.getIcone();
		assertEquals(expResult, result);
	}
}