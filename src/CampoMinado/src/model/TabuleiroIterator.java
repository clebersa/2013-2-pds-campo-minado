package model;

import java.util.Iterator;

/**
 * Define um iterador para todos os quadrados do tabuleiro.
 * @author cleber
 */

public class TabuleiroIterator implements Iterator<Quadrado> {

	private Quadrado quadrados[][];
	private int linha;
	private int coluna;

	TabuleiroIterator(Quadrado quadrados[][]) {
		this.quadrados = quadrados;
		linha = 0;
		coluna = 0;
	}

	@Override
	public boolean hasNext() {
		if (coluna < quadrados[linha].length) {
			return true;
		} else {
			if (linha + 1 < quadrados.length) {
				linha++;
				coluna = 0;
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public Quadrado next() {
		return quadrados[linha][coluna++];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not supported.");
	}
}
