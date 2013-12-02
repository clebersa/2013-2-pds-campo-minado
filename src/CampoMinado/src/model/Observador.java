/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Define uma interface para as classes que podem assumir o papel de obervador,
 * seguindo o Padrão Observer.
 *
 * @author cleber
 */
public interface Observador {

	/**
	 * Atualiza um observador.
	 */
	public abstract void update(Quadrado observado);
}
