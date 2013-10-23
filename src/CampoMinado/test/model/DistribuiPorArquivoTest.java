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
public class DistribuiPorArquivoTest {

    public DistribuiPorArquivoTest() {
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
     * Test of distribuirMinas method, of class DistribuiPorArquivo.
     */
    @Test
    public void testDistribuirMinas() {
        System.out.println("distribuirMinas");
            
        Tabuleiro tabuleiro = new Tabuleiro(TipoTabuleiro.INICIANTE);
        DistribuiPorArquivo instance = new DistribuiPorArquivo();
        instance.distribuirMinas(tabuleiro);

        tabuleiro = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        instance.distribuirMinas(tabuleiro);

        tabuleiro = new Tabuleiro(TipoTabuleiro.AVANCADO);
        instance.distribuirMinas(tabuleiro);
    }
}
