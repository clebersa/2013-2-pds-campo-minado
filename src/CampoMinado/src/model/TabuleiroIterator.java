package model;

import java.util.Iterator;

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
        Quadrado quadrado = quadrados[linha][coluna];
        coluna++;
        return quadrado;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }

    /**
     * Obtém a linha do quadrado atual.
     *
     * @return Linha do quadrado atual.
     */
    public int getLinhaVizinho() {
        return linha;
    }

    /**
     * Obtém a coluna do quadrado atual.
     *
     * @return Coluna do quadrado atual.
     */
    public int getColunaVizinho() {
        return coluna;

    }
}
