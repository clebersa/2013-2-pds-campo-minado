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
public class DistribuiAleatorioTest {

    public DistribuiAleatorioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of distribuirMinas method, of class DistribuiAleatorio.
     */
    @Test
    public void testDistribuirMinas() {
        System.out.println("distribuirMinas");

        Tabuleiro tabuleiro;

        tabuleiro = new Tabuleiro(TipoTabuleiro.INICIANTE);
        tabuleiro.distribuirMinas(new DistribuiAleatorio());
        assertEquals(tabuleiro.getMinas(), contabilizarMinasDistribuidas(tabuleiro));

        tabuleiro = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        tabuleiro.distribuirMinas(new DistribuiAleatorio());
        assertEquals(tabuleiro.getMinas(), contabilizarMinasDistribuidas(tabuleiro));

        tabuleiro = new Tabuleiro(TipoTabuleiro.AVANCADO);
        tabuleiro.distribuirMinas(new DistribuiAleatorio());
        assertEquals(tabuleiro.getMinas(), contabilizarMinasDistribuidas(tabuleiro));
    }

    /**
     * Contabiliza a quantidade de minas distribuídas num tabuleiro.
     *
     * @param tabuleiro Tabuleiro no qual deseja se contabilizar as minas.
     * @return Quantidade de minas distribuídas no tabuleiro.
     */
    public int contabilizarMinasDistribuidas(Tabuleiro tabuleiro) {
        int quantidadeMinasDistribuidas;

        MinasIterator minasIterator = tabuleiro.createMinasIterator();

        quantidadeMinasDistribuidas = 0;
        while (minasIterator.hasNext()) {
            quantidadeMinasDistribuidas++;
            minasIterator.next();
        }

        return quantidadeMinasDistribuidas;
    }
}
