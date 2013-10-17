package model;

import java.util.Iterator;

public class VizinhosIterator implements Iterator<Quadrado> {

    private Quadrado quadrados[][];
    private int linha;
    private int coluna;
    private int linhaQuadrado;
    private int colunaQuadrado;
    private int contadorVizinhos;

    VizinhosIterator(Quadrado quadrados[][], int linhaQuadrado, int colunaQuadrado) {
		this.quadrados = quadrados;
		this.linhaQuadrado = linhaQuadrado;
		this.colunaQuadrado = colunaQuadrado;
		linha = linhaQuadrado - 1;
		coluna = colunaQuadrado - 1;
	}

	@Override
	public boolean hasNext() {
		while (linha != linhaQuadrado + 1 || coluna != colunaQuadrado + 2) {
			if (linha < 0) {
				linha = 0;
			} else if (coluna < 0) {
				coluna = 0;
			} else if (linha >= quadrados.length) {
				break;
			} else if (coluna >= quadrados[linha].length || coluna > colunaQuadrado + 1) {
				coluna = colunaQuadrado - 1;
				linha++;
			} else if (linha == linhaQuadrado && coluna == colunaQuadrado) {
				coluna++;
			} else {
				return true;
			}
		}
		return false;

//		//Código de iteração da classe legada
//		for (int counter = 0; counter < 3; counter++, coluna++) {
//			abrirQuadrado(linha, coluna);
//		}
//		linha++;
//		coluna--;
//		for (int counter = 0; counter < 2; counter++, linha++) {
//			abrirQuadrado(linha, coluna);
//		}
//		linha--;
//		coluna--;
//		for (int counter = 0; counter < 2; counter++, coluna--) {
//			abrirQuadrado(linha, coluna);
//		}
//		linha--;
//		coluna++;
//		for (int counter = 0; counter < 1; counter++, linha--) {
//			abrirQuadrado(linha, coluna);
//		}

	}

	@Override
	public Quadrado next() {
		Quadrado quadrado = quadrados[linha][coluna];
		coluna++;
		return quadrado;

	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not supported.");
	}

	/**
	 * Obtém a linha do vizinho (elemento) atual.
	 *
	 * @return Linha do vizinho atual.
	 */
	public int getLinhaVizinho() {
		return linha;
	}

	/**
	 * Obtém a coluna do vizinho (elemento) atual.
	 *
	 * @return Coluna do vizinho atual.
	 */
	public int getColunaVizinho() {
		return coluna;

	}
}
