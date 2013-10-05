package model;

public class Jogada {

    private int linha;
    private int coluna;
    private TipoJogada tipoJogada;

    /**
     * Cria uma nova jogada.
     *
     * @param linha Número da linha do quadrado.
     * @param coluna Número da coluna do quadrado.
     * @param tipo Tipo da jogada que será realizada sobre o quadrado.
     */
    public void Jogada(int linha, int coluna, TipoJogada tipo) {
		this.linha = linha;
		this.coluna = coluna;
		this.tipoJogada = tipo;
    }

    /**
     * Obtém o número da linha do quadrado.
     *
     * @return Número da linha do quadrado.
     */
    public int getLinha() {
        return linha;
    }

    /**
     * Obtém o número da coluna do quadrado.
     *
     * @return Número da coluna do quadrado.
     */
    public int getColuna() {
        return coluna;
    }

    /**
     * Obtém o tipo da jogada.
     *
     * @return Tipo da jogada.
     */
    public TipoJogada getTipo() {
        return this.tipoJogada;
    }
}