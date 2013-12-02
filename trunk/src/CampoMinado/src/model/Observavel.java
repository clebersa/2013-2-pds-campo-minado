/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Define uma interface para as classes que podem assumir o papel de observável,
 * seguindo o Padrão Observer.
 *
 * @author cleber
 */
public interface Observavel {

	/**
	 * Adiciona um quadrado à lista de observadores da classe observável.
	 * @param observador Quadrado observador do observável.
	 */
	public abstract void adicionarObservador(Quadrado observador);

	/**
	 * Remove um quadrado da lista de observadores da classe observável.
	 * @param observador Quadrado observador do observável.
	 */
	public abstract void removerObservador(Quadrado observador);

	/**
	 * Notifica os observadores cadastrados na lista de observadores da classe
	 * observável.
	 */
	public abstract void notificarObservadores();
}
