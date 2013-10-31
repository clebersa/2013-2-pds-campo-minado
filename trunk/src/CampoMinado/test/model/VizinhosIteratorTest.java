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

	Quadrado quadrados[][];
	int linhas;
	int colunas;

    /**
     * Inicia as variáveis: linhas e colunas para serem usadas nos testes.
     */
    public VizinhosIteratorTest() {
		linhas = 3;
		colunas = 3;
	}

    /**
     * 
     */
    @BeforeClass
	public static void setUpClass() {
	}

    /**
     *
     */
    @AfterClass
	public static void tearDownClass() {
	}

    /**
     * Inicia a matriz de quadrados.
     * @throws Exception
     */
    @Before
	public void setUp() throws Exception {
		quadrados = new Quadrado[linhas][colunas];
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				quadrados[linha][coluna] = new Quadrado(linha, coluna);
			}
		}
	}

    /**
     *
     * @throws Exception
     */
    @After
	public void tearDown() throws Exception {
	}

	/**
	 * Para cada quadrado e feito um teste de contagem da quantidade de vizinhos, posteriormente é feito a checagem de corretude da contagem dos vizinhos.
	 */
	@Test
	public void testHasNext() {
		System.out.println("hasNext");
		int cadaQuantidadeVizinhos[] = {3, 5, 3, 5, 8, 5, 3, 5, 3};
		int quantidadeVizinhos;
		VizinhosIterator instance;

		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				quantidadeVizinhos = 0;
				instance = new VizinhosIterator(quadrados, quadrados[linha][coluna]);
				while (instance.hasNext()) {
					instance.next();
					quantidadeVizinhos++;
				}
				assertEquals(cadaQuantidadeVizinhos[linha * colunas + coluna], quantidadeVizinhos);
			}
		}

	}

	/**
	 * Testa para cada quadrado da matriz sua respectiva quantidade de vizinhos retornados pelo método next().
	 */
	@Test
	public void testNext() {
		System.out.println("next");
		VizinhosIterator instance;
		for (int linha = 0; linha < linhas; linha++) {
			for (int coluna = 0; coluna < colunas; coluna++) {
				instance = new VizinhosIterator(quadrados, quadrados[linha][coluna]);
				System.out.println("Vizinhos de (" + linha + "," + coluna + "):");
				while (instance.hasNext()) {
					Quadrado vizinho = instance.next();
					System.out.println("\t(" + vizinho.getLinha() + "," + vizinho.getColuna() + ")");
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
		quadrados = new Quadrado[1][1];
		quadrados[0][0] = new Quadrado(0, 0);
		VizinhosIterator instance;
		instance = new VizinhosIterator(quadrados, quadrados[0][0]);
		instance.remove();
	}
}