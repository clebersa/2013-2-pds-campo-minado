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
public class BandeirasIteratorTest {

	Quadrado quadrados[][];
	int linhas;
	int colunas;

    /**
     * Iniciliza as variáveis linhas e colunas para o teste.
     */
    public BandeirasIteratorTest() {
		linhas = 6;
		colunas = 6;
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
     * Inicia a matriz de quadrados e posteriormente marca alguns quadrados como bandeiras para o teste.
     */
    @Before
	public void setUp() {

		quadrados = new Quadrado[linhas][colunas];

		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				quadrados[linha][coluna] = new Quadrado(linha, coluna);
			}
		}
		quadrados[0][0].marcar();
		quadrados[5][5].marcar();
		quadrados[0][5].marcar();
		quadrados[5][0].marcar();

		quadrados[1][2].marcar();
		quadrados[1][1].marcar();
		quadrados[0][2].marcar();
		quadrados[2][2].marcar();
		quadrados[3][5].marcar();
	}

    /**
     *
     */
    @After
	public void tearDown() {
	}

	/**
	 * Test of hasNext method, of class BandeirasIterator.
	 */
	@Test
	public void testHasNext() {
		System.out.println("hasNext");
		BandeirasIterator instanceHasNext = new BandeirasIterator(quadrados);
		int quantidadeBandeirasContadas = 0;
		while (instanceHasNext.hasNext()) {
			quantidadeBandeirasContadas++;
			instanceHasNext.next();
		}
		assertEquals(9, quantidadeBandeirasContadas);

		quadrados[3][3].marcar();
		quadrados[2][3].marcar();
		quadrados[1][3].marcar();

		instanceHasNext = new BandeirasIterator(quadrados);
		quantidadeBandeirasContadas = 0;

		while (instanceHasNext.hasNext()) {
			quantidadeBandeirasContadas++;
			instanceHasNext.next();
		}

		assertEquals(12, quantidadeBandeirasContadas);

	}

	/**
         * Teste do método next, da classe BandeirasIterator
	 */
	@Test
	public void testNext() {
		System.out.println("next");
		BandeirasIterator instanceNext = new BandeirasIterator(quadrados);
		int quantidadeBandeirasContadas = 0;
		while (instanceNext.hasNext()) {
			if (instanceNext.next().getTipoMarcacao().isBANDEIRA()) {
				quantidadeBandeirasContadas++;
			}
		}
		assertEquals(9, quantidadeBandeirasContadas);

		quadrados[3][3].marcar();
		quadrados[2][3].marcar();
		quadrados[1][3].marcar();

		instanceNext = new BandeirasIterator(quadrados);
		quantidadeBandeirasContadas = 0;
		while (instanceNext.hasNext()) {
			if (instanceNext.next().getTipoMarcacao().isBANDEIRA()) {
				quantidadeBandeirasContadas++;
			}
		}
		assertEquals(12, quantidadeBandeirasContadas);
	}

	/**
         * Teste do método remove da classe BandeirasIterator
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testRemove() {
		System.out.println("remove");
		BandeirasIterator instance = new BandeirasIterator(quadrados);
		instance.remove();
	}
}
