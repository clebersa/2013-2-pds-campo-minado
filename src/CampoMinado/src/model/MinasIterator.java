package model;

import java.util.Iterator;

public class MinasIterator implements Iterator<Quadrado> {

    private Quadrado quadrados[][];
    private int linha;
    private int coluna;

    MinasIterator(Quadrado quadrados[][]) {
        this.quadrados = quadrados;
        linha = 0;
        coluna = 0;
    }

    @Override
    public boolean hasNext() {
        // Procura a partir de uma dada linha e coluna por minas. Caso encontre retorna True.
        for (int cont_1 = linha; cont_1 < quadrados.length; cont_1++) {
            for (int cont_2 = coluna; cont_2 < quadrados.length; cont_2++) {
                if (quadrados[cont_1][cont_2].contemMina()) {
                    linha = cont_1;
                    coluna = cont_2;
                    return true;
                }
            }
        }
        return false;
    }

    public Quadrado next() {
        // Dados que você executa o hasNext() antes de executar o next(). Caso o hasNext() retorne OK
        // os valores da linha e da coluna ficarão salvos, então é só retornar o quadrado para a linha e a coluna.
        return quadrados[linha][coluna];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
