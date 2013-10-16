package model;

import java.util.Iterator;

public class BandeirasIterator implements Iterator<Quadrado> {

	private Quadrado quadrados[][];
	private int linha;
	private int coluna;

	public void BandeirasIterator(Quadrado quadrados[][]) {
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Quadrado next() {
		return null;
	}

	@Override
	public void remove() {
	}
}
