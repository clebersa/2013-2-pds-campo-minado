/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author samuel
 */
public class ResultadoJogadaTest {

    /**
     *
     */
    public ResultadoJogadaTest() {
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
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of values method, of class ResultadoJogada.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        ResultadoJogada[] expResult = {ResultadoJogada.VITORIA, ResultadoJogada.DERROTA, ResultadoJogada.CONTINUA};
        ResultadoJogada[] result = ResultadoJogada.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class ResultadoJogada.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        assertEquals(ResultadoJogada.CONTINUA, ResultadoJogada.valueOf("CONTINUA"));
        assertEquals(ResultadoJogada.DERROTA, ResultadoJogada.valueOf("DERROTA"));
        assertEquals(ResultadoJogada.VITORIA, ResultadoJogada.valueOf("VITORIA"));
    }

    /**
     * Test of isVITORIA method, of class ResultadoJogada.
     */
    @Test
    public void testIsVITORIA() {
        System.out.println("isVITORIA");
        ResultadoJogada instance;

        instance = ResultadoJogada.CONTINUA;
        assertFalse(instance.isVITORIA());

        instance = ResultadoJogada.DERROTA;
        assertFalse(instance.isVITORIA());

        instance = ResultadoJogada.VITORIA;
        assertTrue(instance.isVITORIA());
    }

    /**
     * Test of isDERROTA method, of class ResultadoJogada.
     */
    @Test
    public void testIsDERROTA() {
        System.out.println("isDERROTA");
        ResultadoJogada instance;

        instance = ResultadoJogada.CONTINUA;
        assertFalse(instance.isDERROTA());

        instance = ResultadoJogada.DERROTA;
        assertTrue(instance.isDERROTA());

        instance = ResultadoJogada.VITORIA;
        assertFalse(instance.isDERROTA());
    }

    /**
     * Test of isCONTINUA method, of class ResultadoJogada.
     */
    @Test
    public void testIsCONTINUA() {
        System.out.println("isCONTINUA");
        ResultadoJogada instance;

        instance = ResultadoJogada.CONTINUA;
        assertTrue(instance.isCONTINUA());

        instance = ResultadoJogada.DERROTA;
        assertFalse(instance.isCONTINUA());

        instance = ResultadoJogada.VITORIA;
        assertFalse(instance.isCONTINUA());
    }

}
