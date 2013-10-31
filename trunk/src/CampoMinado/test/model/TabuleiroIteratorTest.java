/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author almeida
 */
public class TabuleiroIteratorTest {

	Quadrado quadrados[][];
	int linhas;
	int colunas;

    /**
     * Iniciliza as variáveis linhas e colunas para o teste.
     */
    public TabuleiroIteratorTest() {
		linhas = 3;
		colunas = 3;
	}

    /**
     *
     * @throws Exception
     */
    @BeforeClass
	public static void setUpClass() throws Exception {
	}

    /**
     *
     * @throws Exception
     */
    @AfterClass
	public static void tearDownClass() throws Exception {
	}

    /**
     * Inicia a matriz de quadrados.
     */
    @Before
	public void setUp() {
		quadrados = new Quadrado[linhas][colunas];
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				quadrados[linha][coluna] = new Quadrado(linha, coluna);
			}
		}
	}

    /**
     *
     */
    @After
	public void tearDown() {
	}

	/**
	 * Test of hasNext method, of class TabuleiroIterator.
	 */
	@Test
	public void testHasNext() {
		System.out.println("hasNext");
		TabuleiroIterator instance = new TabuleiroIterator(quadrados);
		int quantidadeDeQuadrados = 0;
		do {
			quantidadeDeQuadrados++;
			instance.next();
		} while (instance.hasNext());

		assertEquals(linhas * colunas, quantidadeDeQuadrados);

	}

	/**
	 * Test of next method, of class TabuleiroIterator.
	 */
	@Test
	public void testNext() {
		System.out.println("next");
		TabuleiroIterator instance = new TabuleiroIterator(quadrados);
		while (instance.hasNext()) {
			assertTrue(instance.next() instanceof Quadrado);
		}
	}

	/**
	 * Test of remove method, of class TabuleiroIterator.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testRemove() {
		System.out.println("remove");
		TabuleiroIterator instance = new TabuleiroIterator(quadrados);
		instance.remove();
	}
}
