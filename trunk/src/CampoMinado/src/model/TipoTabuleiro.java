package model;

public enum TipoTabuleiro {

    INICIANTE(new InfoTipoTabuleiro(9, 9, 10)),
    INTERMEDIARIO(new InfoTipoTabuleiro(16, 16, 40)),
    AVANCADO(new InfoTipoTabuleiro(20, 24, 99));
    private final InfoTipoTabuleiro infoTipoTabuleiro;

    TipoTabuleiro(InfoTipoTabuleiro infoTipoTabuleiro) {
        this.infoTipoTabuleiro = infoTipoTabuleiro;
    }

    /**
     * Obtém o número de linhas do tipo do tabuleiro.
     */
    public int getLinhas() {
        //retornar as linhas
        return infoTipoTabuleiro.linhas;
    }

    /**
     * Obtém o número de colunas do tipo do tabuleiro.
     */
    public int getColunas() {
        //retornar as colunas
    }

    /**
     * Obtém o número de minas do tipo do tabuleiro.
     */
    public int getMinas() {
        //retornar as minas
    }

    private static class InfoTipoTabuleiro {

        private int linhas;
        private int colunas;
        private int minas;

        public InfoTipoTabuleiro(int linhas, int colunas, int minas) {
        }
    }
}
