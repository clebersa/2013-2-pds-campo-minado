/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author cleber
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	model.ConteudoTest.class, 
	model.JogadaTest.class, 
	model.MarcacaoTest.class,
	model.QuadradoTest.class, 
	model.TipoConteudoTest.class, 
	model.TipoJogadaTest.class, 
	model.TipoMarcacaoTest.class, 
	model.TipoTabuleiroTest.class, 
	model.VizinhosIteratorTest.class
})
public class TestSuite {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
}