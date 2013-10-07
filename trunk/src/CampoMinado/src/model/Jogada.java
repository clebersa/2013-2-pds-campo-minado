package model;

/**
 * Define os atributos e métodos para uma jogada.
 *
 * @author Cleber, Samuel
 */
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
		setLinha(linha);
		setColuna(coluna);
		setTipo(tipo);
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
	 * Define o número da linha do quadrado.
	 *
	 * @param linha Número da linha do quadrado.
	 */
	private void setLinha(int linha) {
		this.linha = linha;
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
	 * Define o número da coluna do quadrado.
	 *
	 * @param coluna Número da coluna do quadrado.
	 */
	private void setColuna(int coluna) {
		this.coluna = coluna;
	}

	/**
	 * Obtém o tipo da jogada.
	 *
	 * @return Tipo da jogada.
	 */
	public TipoJogada getTipo() {
		return this.tipoJogada;
	}

	/**
	 * Define o tipo da jogada.
	 *
	 * @param tipoJogada Tipo da jogada.
	 */
	private void setTipo(TipoJogada tipoJogada) {
		this.tipoJogada = tipoJogada;
	}
}
