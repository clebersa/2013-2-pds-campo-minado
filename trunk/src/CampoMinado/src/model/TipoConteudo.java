package model;

/**
 * Define os tipos de conteúdo possíveis para um quadrado. Esses conteúdos podem
 * ser de 3 tipos:<br/>
 * <code>NUMERO</code> - Indica que o conteúdo de um quadrado é um número,
 * diferente de zero, que indica a quantidade de minas na vizinhança do
 * quadrado<br/>
 * <code>MINA</code> - Indica que o conteúdo de um quadrado é uma mina.<br/>
 * <code>VAZIO</code> - Indica que o conteúdo de um quadrado é vazio, ou seja, o
 * quadrado não contém mina e não tem nenhuma mina na vizinhança.<br/>
 *
 * @author Cleber
 */
public enum TipoConteudo {

	/**
	 * Indica que o conteúdo de um quadrado é um número, diferente de zero, que
	 * indica a quantidade de minas na vizinhança do quadrado.
	 */
	NUMERO,
	/**
	 * Indica que o conteúdo de um quadrado é uma mina.
	 */
	MINA,
	/**
	 * Indica que o conteúdo de um quadrado é vazio, ou seja, o quadrado não
	 * contém mina e não tem nenhuma mina na vizinhança.
	 */
	VAZIO;

	/**
	 * Verifica se o conteúdo é do tipo
	 * <code>NUMERO</code>.
	 *
	 * @return <code>TRUE</code> se o conteúdo é do tipo <code>NUMERO</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isNUMERO() {
		return (this == NUMERO);
	}

	/**
	 * Verifica se o conteúdo é do tipo
	 * <code>MINA</code>.
	 *
	 * @return <code>TRUE</code> se o conteúdo é do tipo <code>MINA</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isMINA() {
		return (this == MINA);
	}

	/**
	 * Verifica se o conteúdo é do tipo
	 * <code>VAZIO</code>.
	 *
	 * @return <code>TRUE</code> se o conteúdo é do tipo <code>VAZIO</code>
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isVAZIO() {
		return (this == VAZIO);
	}
}
