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
public class TipoConteudoTest {
	
	public TipoConteudoTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of values method, of class TipoConteudo.
	 */
	@Test
	public void testValues() {
		System.out.println("values");
		TipoConteudo[] expResult = {TipoConteudo.NUMERO, TipoConteudo.MINA, TipoConteudo.VAZIO};
		TipoConteudo[] result = TipoConteudo.values();
		assertArrayEquals(expResult, result);
	}

	/**
	 * Test of valueOf method, of class TipoConteudo.
	 */
	@Test
	public void testValueOf() {
		System.out.println("valueOf");
		assertEquals(TipoConteudo.NUMERO, TipoConteudo.valueOf("NUMERO"));
		assertEquals(TipoConteudo.MINA, TipoConteudo.valueOf("MINA"));
		assertEquals(TipoConteudo.VAZIO, TipoConteudo.valueOf("VAZIO"));
	}

	/**
	 * Test of isNUMERO method, of class TipoConteudo.
	 */
	@Test
	public void testIsNUMERO() {
		System.out.println("isNUMERO");
		TipoConteudo instance;
		
		instance = TipoConteudo.NUMERO;
		assertTrue(instance.isNUMERO());
		
		instance = TipoConteudo.MINA;
		assertFalse(instance.isNUMERO());
		
		instance = TipoConteudo.VAZIO;
		assertFalse(instance.isNUMERO());
	}

	/**
	 * Test of isMINA method, of class TipoConteudo.
	 */
	@Test
	public void testIsMINA() {
		System.out.println("isMINA");
		TipoConteudo instance;
		
		instance = TipoConteudo.NUMERO;
		assertFalse(instance.isMINA());
		
		instance = TipoConteudo.MINA;
		assertTrue(instance.isMINA());
		
		instance = TipoConteudo.VAZIO;
		assertFalse(instance.isMINA());
	}

	/**
	 * Test of isVAZIO method, of class TipoConteudo.
	 */
	@Test
	public void testIsVAZIO() {
		System.out.println("isVAZIO");
		TipoConteudo instance;
		instance = TipoConteudo.NUMERO;
		assertFalse(instance.isVAZIO());
		
		instance = TipoConteudo.MINA;
		assertFalse(instance.isVAZIO());
		
		instance = TipoConteudo.VAZIO;
		assertTrue(instance.isVAZIO());
	}
}