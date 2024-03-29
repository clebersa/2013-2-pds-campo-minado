/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cleber
 */
public class QuadradoTest extends TestCase{
	
	public QuadradoTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getLinha method, of class Quadrado.
	 */
	@Test
	public void testGetLinha() {
		System.out.println("getLinha");
		Quadrado instance = new Quadrado(0, 0);
		int expResult = 0;
		int result = instance.getLinha();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getColuna method, of class Quadrado.
	 */
	@Test
	public void testGetColuna() {
		System.out.println("getColuna");
		Quadrado instance = new Quadrado(0, 0);
		int expResult = 0;
		int result = instance.getColuna();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of abrir method, of class Quadrado.
	 */
	@Test
	public void testAbrir() {
		System.out.println("abrir");
		Quadrado instance = new Quadrado(0, 0);
		
		assertFalse(instance.isAberto());
		assertEquals(TipoConteudo.VAZIO, instance.abrir());
		assertTrue(instance.isAberto());
		
		instance = new Quadrado(0, 0);
		instance.contabilizarMinaVizinha();
		assertFalse(instance.isAberto());
		assertEquals(TipoConteudo.NUMERO, instance.abrir());
		assertTrue(instance.isAberto());
		
		instance = new Quadrado(0, 0);
		instance.adicionarMina();
		assertFalse(instance.isAberto());
		assertEquals(TipoConteudo.MINA, instance.abrir());
		assertTrue(instance.isAberto());
	}

	/**
	 * Test of marcar method, of class Quadrado.
	 */
	@Test
	public void testMarcar() {
		System.out.println("marcar");
		Quadrado instance = new Quadrado(0, 0);
		
		System.out.println("\tEsperado: \"[ ]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
		
		instance.marcar();
		System.out.println("\tEsperado: \"[B]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
		
		instance.marcar();
		System.out.println("\tEsperado: \"[?]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
		
		instance.marcar();
		System.out.println("\tEsperado: \"[ ]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
	}

	/**
	 * Test of adicionarMina method, of class Quadrado.
	 */
	@Test
	public void testAdicionarMina() {
		System.out.println("adicionarMina");
		Quadrado instance = new Quadrado(0, 0);
		
		instance.abrir();
		System.out.println("\tEsperado: \"[ ]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
		
		instance.adicionarMina();
		System.out.println("\tEsperado: \"[M]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
	}

	/**
	 * Test of contabilizarMinaVizinha method, of class Quadrado.
	 */
	@Test
	public void testContabilizarMinaVizinha() {
		System.out.println("contabilizarMinaVizinha");
		Quadrado instance = new Quadrado(0, 0);
		
		instance.abrir();
		System.out.println("\tEsperado: \"[ ]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
		
		for(int minasVizinhas = 0; minasVizinhas < 8; minasVizinhas++){
			instance.contabilizarMinaVizinha();
			System.out.println(String.format("\tEsperado: \"[%d]\"", minasVizinhas+1));
			System.out.print("\tObtido:   \"");
			instance.exibir();
			System.out.println("\"");
		}
	}

	/**
	 * Test of isAberto method, of class Quadrado.
	 */
	@Test
	public void testIsAberto() {
		System.out.println("isAberto");
		Quadrado instance = new Quadrado(0, 0);
		assertFalse(instance.isAberto());
		instance.abrir();
		assertTrue(instance.isAberto());
	}

	/**
	 * Test of contemMina method, of class Quadrado.
	 */
	@Test
	public void testContemMina() {
		System.out.println("contemMina");
		Quadrado instance = new Quadrado(0, 0);
		assertFalse(instance.contemMina());
		instance.adicionarMina();
		assertTrue(instance.contemMina());
	}

	/**
	 * Test of exibir method, of class Quadrado.
	 */
	@Test
	public void testExibir() {
		System.out.println("exibir");
		Quadrado instance = new Quadrado(0, 0);
		
		System.out.println("\tEsperado: \"[ ]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
		
		instance.abrir();
		System.out.println("\tEsperado: \"[ ]\"");
		System.out.print("\tObtido:   \"");
		instance.exibir();
		System.out.println("\"");
	}

	/**
	 * Test of getTipoMarcacao method, of class Quadrado.
	 */
	@Test
	public void testGetTipoMarcacao() {
		System.out.println("getTipoMarcacao");
		Quadrado instance = new Quadrado(0, 0);
		
		assertEquals(TipoMarcacao.NENHUMA, instance.getTipoMarcacao());
		instance.marcar();
		assertEquals(TipoMarcacao.BANDEIRA, instance.getTipoMarcacao());
		instance.marcar();
		assertEquals(TipoMarcacao.DUVIDA, instance.getTipoMarcacao());
		instance.marcar();
		assertEquals(TipoMarcacao.NENHUMA, instance.getTipoMarcacao());

	}
}