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
	model.TipoConteudoTest.class, 
	model.ConteudoTest.class, 
	model.QuadradoTest.class, 
	model.TipoTabuleiroTest.class, 
	model.JogadaTest.class, 
	model.TipoJogadaTest.class, 
	model.TipoMarcacaoTest.class, 
	model.MarcacaoTest.class
})
public class ModelTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
}