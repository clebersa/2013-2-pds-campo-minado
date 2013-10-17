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
        linha = this.linhaQuadrado - 1;
        coluna = this.colunaQuadrado - 1;
        contadorVizinhos = 0;
    }

    @Override
    public boolean hasNext() {
        if (linha == linhaQuadrado + 1 && coluna == colunaQuadrado + 1) {
            return false;
        }
        return true;
    }

    @Override
    public Quadrado next() {

        int tempContador = 0;

        for (int cont_1 = linha; cont_1 <= linhaQuadrado + 1; cont_1++) {
            for (int cont_2 = coluna; cont_2 <= colunaQuadrado + 1; cont_2++) {
                if (quadrados[cont_1][cont_2] != quadrados[linhaQuadrado][colunaQuadrado] && tempContador == contadorVizinhos) {

                    contadorVizinhos++;

                    try {
                        return quadrados[cont_1][cont_2];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return new Quadrado();
                    }


                }
                tempContador++;
            }
        }
        return new Quadrado();
    }

    @Override
    public void remove() {
    }
}
