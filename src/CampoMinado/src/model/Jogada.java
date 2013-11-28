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
	 * @param coluna Númeror da coluna do quadrado.
	 * @param tipo Tipo da jogada que será realizada sobre o quadrado.
	 */
	Jogada(int linha, int coluna, TipoJogada tipo) {
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
	 * Verifica se a jogada é do tipo
	 * <code>ABRIR</code>.
	 *
	 * @return <code>TRUE</code> se a joagada é do tipo <code>ABRIR</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isABRIR() {
		return this.tipoJogada.isABRIR();
	}

	/**
	 * Verifica se a jogada é do tipo
	 * <code>MARCAR</code>.
	 *
	 * @return <code>TRUE</code> se a joagada é do tipo <code>MARCAR</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isMARCAR() {
		return this.tipoJogada.isMARCAR();
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
