package model;

/**
 * Define os tipos de resultado de jogada possíveis. Esses resultados podem
 * ser de 3 tipos:<br/>
 * <code>VITORIA</code> - Indica que a jogada permitiu ao jogador vencer a partida.<br/>
 * <code>DERROTA</code> - Indica que a jogada fez com que o jogador perdesse.<br/>
 * <code>CONTINUA</code> - Indica que a jogada não foi decisica, e o jogar pode
 * continuar jogando.<br/>
 *
 * @author Cleber
 */

public enum ResultadoJogada {
	
	VITORIA,
	DERROTA,
	CONTINUA;

	/**
	 * Verifica se o resultado da jogada é do tipo <code>VITORIA</code>.
	 *
	 * @return <code>TRUE</code> se o resultado da jogada é do tipo
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
