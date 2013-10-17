/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author cleber
 */
public class VizinhosIteratorTest {

	public VizinhosIteratorTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test of hasNext method, of class VizinhosIterator.
	 */
	@Test
	public void testHasNext() {
		System.out.println("hasNext");
		int cadaQuantidadeVizinhos[] = {3, 5, 3, 5, 8, 5, 3, 5, 3};
		int quantidadeVizinhos;
		Quadrado quadrados[][] = new Quadrado[3][3];
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				quadrados[linha][coluna] = new Quadrado();
			}
		}
		VizinhosIterator instance;

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				quantidadeVizinhos = 0;
				instance = new VizinhosIterator(quadrados, linha, coluna);
				while (instance.hasNext()) {
					instance.next();
					quantidadeVizinhos++;
				}
				assertEquals(cadaQuantidadeVizinhos[linha * 3 + coluna], quantidadeVizinhos);
			}
		}

	}

	/**
	 * Test of next method, of class VizinhosIterator.
	 */
	@Test
	public void testNext() {
		System.out.println("next");
		Quadrado quadrados[][] = new Quadrado[3][3];
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				quadrados[linha][coluna] = new Quadrado();
			}
		}
		VizinhosIterator instance;
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				instance = new VizinhosIterator(quadrados, linha, coluna);
				System.out.println("Vizinhos de (" + linha + "," + coluna + "):");
				while (instance.hasNext()) {
					System.out.println("\t(" + instance.getLinhaVizinho() + "," + instance.
					getColunaVizinho() + ")");
					instance.next();
				}
			}
		}
	}

	/**
	 * Test of remove method, of class VizinhosIterator.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testRemove() {
		System.out.println("remove");
		Quadrado quadrados[][] = new Quadrado[1][1];
		quadrados[0][0] = new Quadrado();
		
		VizinhosIterator instance;
		instance = new VizinhosIterator(quadrados, 0, 0);
		instance.remove();
	}

	/**
	 * Test of getLinhaVizinho method, of class VizinhosIterator.
	 */
	@Test
	public void testGetLinhaVizinho() {
		System.out.println("getLinhaVizinho");
		Quadrado quadrados[][] = new Quadrado[1][1];
		quadrados[0][0] = new Quadrado();
		
		VizinhosIterator instance;
		instance = new VizinhosIterator(quadrados, 0, 0);
		
		int linhaVizinho = instance.getLinhaVizinho();
		assertEquals(-1, linhaVizinho);
	}
	
	/**
	 * Test of getColunaVizinho method, of class VizinhosIterator.
	 */
	@Test
	public void testGetColunaVizinho() {
		System.out.println("getColunaVizinho");
		Quadrado quadrados[][] = new Quadrado[1][1];
		quadrados[0][0] = new Quadrado();
		
		VizinhosIterator instance;
		instance = new VizinhosIterator(quadrados, 0, 0);
		
		int colunaVizinho = instance.getColunaVizinho();
		assertEquals(-1, colunaVizinho);
	}
}