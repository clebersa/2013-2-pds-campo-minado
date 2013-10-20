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
        int linhaRandom, colunaRandom;

        Random geradorNumerosRandomico = new Random();

        for (int mina = 0; mina < tabuleiro.getMinas(); mina++) {
            linhaRandom = geradorNumerosRandomico.nextInt(tabuleiro.getLinhas());
            colunaRandom = geradorNumerosRandomico.nextInt(tabuleiro.getColunas());
            
            while (tabuleiro.adicionarMina(linhaRandom, colunaRandom) == false) {
                linhaRandom = geradorNumerosRandomico.nextInt(tabuleiro.getLinhas());
                colunaRandom = geradorNumerosRandomico.nextInt(tabuleiro.getColunas());
            }
            //adicionar tratamento 
        }
    }
}
