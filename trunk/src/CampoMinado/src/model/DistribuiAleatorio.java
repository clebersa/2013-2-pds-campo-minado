package model;

import java.util.Random;

/**
 * Define a implementação da distribuição de minas de forma aleatória.
 *
 * @author Cleber, Samuel
 */
public class DistribuiAleatorio implements DistribuidorMinas {

    /**
     * Distribui as minas de modo aleatório sobre o tabuleiro.
     *
     * @see model.DistribuidorMinas#distribuirMinas(model.Tabuleiro)
     */
    @Override
    public void distribuirMinas(Tabuleiro tabuleiro) {
        int quantidadeDeMinas = tabuleiro.getMinas();
        int linhaRandom, colunaRandom;
        Random tempRandom = new Random();
        for (int counter = 0; counter < quantidadeDeMinas; counter++) {
            linhaRandom = tempRandom.nextInt(tabuleiro.getLinhas());
            colunaRandom = tempRandom.nextInt(tabuleiro.getColunas());
            tabuleiro.adicionarMina(linhaRandom, colunaRandom);
        }
    }
}
