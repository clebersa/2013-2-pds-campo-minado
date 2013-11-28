package model;

import java.util.Iterator;

public class VizinhosIterator implements Iterator<Quadrado> {

    private Quadrado quadrados[][];
    private Quadrado quadrado;
    private int linha;
    private int coluna;

    VizinhosIterator(Quadrado quadrados[][], Quadrado quadrado) {
		this.quadrados = quadrados;
		this.quadrado = quadrado;
		linha = quadrado.getLinha() - 1;
		coluna = quadrado.getColuna() - 1;
	}

	@Override
	public boolean hasNext() {
		while (linha <= quadrado.getLinha() + 1) {
			if (linha < 0) {
				linha = 0;
			} else if (coluna < 0) {
				coluna = 0;
			} else if (linha >= quadrados.length) {
				break;
			} else if (coluna >= quadrados[linha].length || coluna > quadrado.getColuna() + 1) {
				coluna = quadrado.getColuna() - 1;
				linha++;
			} else if (linha == quadrado.getLinha() && coluna == quadrado.getColuna()) {
				coluna++;
			} else {
				return true;
			}
		}
		return false;
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
