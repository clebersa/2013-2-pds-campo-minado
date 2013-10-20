package model;

/**
 * Define os tipos de marcação possíveis para um quadrado.
 *
 * @author Cleber
 */
public enum TipoMarcacao {

	/**
	 * Indica que a marcação é de dúvida.
	 */
	DUVIDA,
	/**
	 * Indica que a marcação é de bandeira, o que implica mina.
	 */
	BANDEIRA,
	/**
	 * Indica que não existe marcação.
	 */
	NENHUMA;

	/**
	 * Verifica se a marcação é do tipo
	 * <code>DUVIDA</code>.
	 *
	 * @return <code>TRUE</code> se a marcação é do tipo <code>DUVIDA</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isDUVIDA() {
		return (this == DUVIDA);
	}

	/**
	 * Verifica se a marcação é do tipo
	 * <code>BANDEIRA</code>.
	 *
	 * @return <code>TRUE</code> se a marcação é do tipo <code>BANDEIRA</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isBANDEIRA() {
		return (this == BANDEIRA);
	}

	/**
	 * Verifica se a marcação é do tipo
	 * <code>NENHUMA</code>.
	 *
	 * @return <code>TRUE</code> se a marcação é do tipo <code>NENHUMA</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isNENHUMA() {
		return (this == NENHUMA);
	}
}
