package model;

import java.util.Iterator;

public class MinasIterator implements Iterator<Quadrado> {

	private Quadrado quadrados[][];
	private int linha;
	private int coluna;

	public void Tabuleiro(Quadrado quadrados[][]) {
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	public Quadrado next() {
		return null;
	}

	@Override
	public void remove() {
	}
}
