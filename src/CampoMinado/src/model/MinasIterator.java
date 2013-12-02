package model;

import java.util.Iterator;

/**
 * Define um iterador para todos os quadrados com minas do tabuleiro.
 * @author cleber
 */

public class MinasIterator implements Iterator<Quadrado> {

	private Quadrado quadrados[][];
	private int linha;
	private int coluna;

	MinasIterator(Quadrado quadrados[][]) {
		this.quadrados = quadrados;
		linha = 0;
		coluna = 0;
	}

	@Override
	public boolean hasNext() {
		while (true) {
			if (coluna < quadrados[linha].length) {
				if (quadrados[linha][coluna].contemMina()) {
					return true;
				}
			} else {
				if (linha + 1 < quadrados.length) {
					linha++;
					coluna = 0;
					if (quadrados[linha][coluna].contemMina()) {
						return true;
					}
				} else {
					return false;
				}
			}
			coluna++;
		}
	}

	public Quadrado next() {
		return quadrados[linha][coluna++];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not supported.");
	}
}
