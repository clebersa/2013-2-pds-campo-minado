package model;

/**
 * Define os tipos de marcação possíveis para um quadrado. Essas marcações podem
 * ser de 3 tipos:<br/>
 * <code>BANDEIRA</code> - Indica que se julga que em um quadrado haja uma mina.<br/>
 * <code>DUVIDA</code> - Indica que não se tem certeza se em um quadrado existe
 * uma mina.<br/>
 * <code>NENHUMA</code> - Indica que um quadrado não está marcado.<br/>
 *
 * @author Cleber
 */
public enum TipoMarcacao {

	/**
	 * Indica que se julga que em um quadrado haja uma mina.
	 */
	BANDEIRA,
	/**
	 * Indica que não se tem certeza se em um quadrado existe uma mina.
	 */
	DUVIDA,
	/**
	 * Indica que um quadrado não está marcado.
	 */
	NENHUMA;

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
	 * <code>NENHUMA</code>.
	 *
	 * @return <code>TRUE</code> se a marcação é do tipo <code>NENHUMA</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isNENHUMA() {
		return (this == NENHUMA);
	}
}
