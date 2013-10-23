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

    public BandeirasIteratorTest() {
        linhas = 3;
        colunas = 3;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        quadrados = new Quadrado[linhas][colunas];

        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                quadrados[linha][coluna] = new Quadrado(linha, coluna);
            }
        }
        quadrados[0][0].marcar();
        quadrados[1][1].marcar();
        quadrados[2][2].marcar();
    }

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
        do {
            quantidadeBandeirasContadas++;
        } while (instanceHasNext.hasNext());
        assertEquals(3, quantidadeBandeirasContadas);

    }

    /**
     * Test of next method, of class BandeirasIterator.
     */
    @Test
    public void testNext() {
        System.out.println("next");
        BandeirasIterator instanceNext = new BandeirasIterator(quadrados);
        Quadrado quadradoResp;
        int quantidadeBandeirasContadas = 0;
        do {

            if (instanceNext.next().getLinha() == 0 && instanceNext.next().getColuna() == 0) {
                quantidadeBandeirasContadas++;
            } else if (instanceNext.next().getLinha() == 1 && instanceNext.next().getColuna() == 1) {
                quantidadeBandeirasContadas++;
            } else if (instanceNext.next().getLinha() == 2 && instanceNext.next().getColuna() == 2) {
                quantidadeBandeirasContadas++;
            }
        } while (instanceNext.hasNext());
        assertEquals(3, quantidadeBandeirasContadas);
    }

    /**
     * Test of remove method, of class BandeirasIterator.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        System.out.println("remove");
        BandeirasIterator instance = new BandeirasIterator(quadrados);
        instance.remove();
    }
}
