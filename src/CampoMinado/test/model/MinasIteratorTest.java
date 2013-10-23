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
public class MinasIteratorTest {

    Quadrado quadrados[][];
    int linhas;
    int colunas;

    public MinasIteratorTest() {
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

        quadrados[1][2].adicionarMina();
        quadrados[1][1].adicionarMina();
        quadrados[2][2].adicionarMina();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of hasNext method, of class MinasIterator.
     */
    @Test
    public void testHasNext() {
        System.out.println("hasNext");
        MinasIterator instance = new MinasIterator(quadrados);
        int quantidadeDeMinas = 0;
        do {
            quantidadeDeMinas++;

        } while (instance.hasNext());
        assertEquals(3, quantidadeDeMinas);
    }

    /**
     * Test of next method, of class MinasIterator.
     */
    @Test
    public void testNext() {
        System.out.println("next");
        MinasIterator instance = new MinasIterator(quadrados);
        Quadrado quadradoResp;
        int quantidadeDeMinas = 0;

        while (instance.hasNext()) {
            quadradoResp = instance.next();
            if (quadradoResp.contemMina()) {
                quantidadeDeMinas++;
            }
        }
        quadradoResp = instance.next();
        if (quadradoResp.contemMina()) {
            quantidadeDeMinas++;
        }

        assertEquals(3, quantidadeDeMinas);
    }

    /**
     * Test of remove method, of class MinasIterator.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRemove() {
        System.out.println("remove");
        MinasIterator instance = new MinasIterator(quadrados);
        instance.remove();
    }
}
