package model;

import java.util.Iterator;

public class BandeirasIterator implements Iterator<Quadrado> {

	private Quadrado quadrados[][];
	private int linha;
	private int coluna;

	BandeirasIterator(Quadrado quadrados[][]) {
		this.quadrados = quadrados;
		linha = 0;
		coluna = 0;
	}

	@Override
	public boolean hasNext() {
		while (true) {
			if (coluna < quadrados[linha].length) {
				if (quadrados[linha][coluna].getTipoMarcacao().isBANDEIRA()) {
					return true;
				}
			} else {
				if (linha + 1 < quadrados.length) {
					linha++;
					coluna = 0;
					if (quadrados[linha][coluna].getTipoMarcacao().isBANDEIRA()) {
						return true;
					}
				} else {
					return false;
				}
			}
			coluna++;
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
