package model;

public enum ResultadoJogada {
	
	VITORIA,
	DERROTA,
	CONTINUA;

	/**
	 * Verifica se o resultado da jogada é do tipo <code>VITORIA</code>.
	 *
	 * @return <code>TRUE</code> se o resultado da joagada é do tipo
	 * <code>VITORIA</code> ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isVITORIA() {
		return (this == VITORIA);
	}

	/**
	 * Verifica se o resultado da jogada é do tipo <code>DERROTA</code>.
	 *
	 * @return <code>TRUE</code> se o resultado da joagada é do tipo
	 * <code>DERROTA</code> ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isDERROTA() {
		return (this == DERROTA);
	}

	/**
	 * Verifica se o resultado da jogada é do tipo <code>CONTINUA</code>.
	 *
	 * @return <code>TRUE</code> se o resultado da joagada é do tipo
	 * <code>CONTINUA</code> ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isCONTINUA() {
		return (this == CONTINUA);
	}

}
