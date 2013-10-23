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
        DistribuiAleatorio instance = new DistribuiAleatorio();
        instance.distribuirMinas(tabuleiro);
        tabuleiro = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
        instance.distribuirMinas(tabuleiro);
        
        tabuleiro = new Tabuleiro(TipoTabuleiro.AVANCADO);
        instance.distribuirMinas(tabuleiro);
            
        // TODO review the generated test code and remove the default call to fail.
    }
}
