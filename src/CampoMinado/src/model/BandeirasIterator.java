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

        /*for (int cont_1 = linha; cont_1 < quadrados.length; cont_1++) {
        for (int cont_2 = coluna + 1; cont_2 < quadrados[linha].length; cont_2++) {
        if (quadrados[cont_1][cont_2].getTipoMarcacao().isBANDEIRA()) {
        linha = cont_1;
        coluna = cont_2;
        return true;
        }
        }
        }
        return false;*/

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
}
