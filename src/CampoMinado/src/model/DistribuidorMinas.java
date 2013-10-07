package model;

public interface DistribuidorMinas extends DistribuidorMinasInterface {

	/**
	 * Distribui as minas sobre um tabuleiro.
	 * @param tabuleiro Tabuleiro sobre o qual as minas serão distribuídas.
	 */
    public abstract void distribuirMinas(Tabuleiro tabuleiro);
}
