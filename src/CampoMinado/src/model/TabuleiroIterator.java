package model;

public class TabuleiroIterator implements Iterator<Quadrado> {

	private Tabuleiro tabuleiro;
	private int linha;
	private int coluna;

	public void TabuleiroIterator(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		linha = 0;
		coluna = 0;
	}


	/**
	 * @see model.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return false;
	}


	/**
	 * @see model.Iterator#next()
	 */
	public Quadrado next() {
		return null;
	}

}
