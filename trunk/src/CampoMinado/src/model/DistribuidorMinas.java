package model;

/**
 * Define uma interface para os objetos que podem distribuir minas em um
 * tabuleiro.
 *
 * @author Cleber
 */
public interface DistribuidorMinas {

	/**
	 * Distribui as minas sobre um tabuleiro.
	 *
	 * @param tabuleiro Tabuleiro sobre o qual as minas serão distribuídas.
	 */
	public abstract void distribuirMinas(Tabuleiro tabuleiro);
}
