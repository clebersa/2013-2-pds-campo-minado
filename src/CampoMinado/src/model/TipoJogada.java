package model;

/**
 * Define os tipos possíveis para uma jogada. As jogadas podem ser de 2 tipos:
 * <code>ABRIR</code> - Indica que a jogada é de abertura.
 * <code>MARCAR</code> - Indica que a jogada é de marcação.
 *
 * @author Cleber
 */
public enum TipoJogada {

	/**
	 * Indica que a jogada é de abertura.
	 */
	ABRIR,
	/**
	 * Indica que a jogada é de marcação.
	 */
	MARCAR;

	/**
	 * Verifica se a jogada é do tipo
	 * <code>ABRIR</code>.
	 *
	 * @return <code>TRUE</code> se a jogada é do tipo <code>ABRIR</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isABRIR() {
		return (this == ABRIR);
	}

	/**
	 * Verifica se a jogada é do tipo
	 * <code>MARCAR</code>.
	 *
	 * @return <code>TRUE</code> se a joagada é do tipo <code>MARCAR</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isMARCAR() {
		return (this == MARCAR);
	}
}
