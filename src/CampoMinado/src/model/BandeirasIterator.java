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
        
        for (int cont_1 = linha; cont_1 < quadrados.length; cont_1++) {
            for (int cont_2 = coluna; cont_2 < quadrados.length; cont_2++) {
                if (quadrados[cont_1][cont_2].getTipoMarcacao() == TipoMarcacao.BANDEIRA) {
                    linha = cont_1;
                    coluna = cont_2;
                    return true;
                }
            }
        }
        return false;
        
    }

    @Override
    public Quadrado next() {
        return quadrados[linha][coluna];
    }

    @Override
    public void remove() {
    }
}
