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
	 * Test of Marcacao method, of class Marcacao.
	 */
	@Test
	public void testMarcacao() {
		System.out.println("Marcacao");
		Marcacao instance = new Marcacao();
		assertEquals(" ", instance.getIcone());
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
}