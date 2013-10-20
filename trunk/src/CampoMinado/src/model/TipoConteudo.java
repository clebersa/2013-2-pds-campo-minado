package model;

/**
 * Define os tipos possíveis para um conteúdo.
 *
 * @author Cleber
 */
public enum TipoConteudo {

	/**
	 * Indica que o conteúdo é um número.
	 */
	NUMERO,
	/**
	 * Indica que o conteúdo é uma mina.
	 */
	MINA,
	/**
	 * Indica que não existe conteúdo, ou seja, ele é vazio.
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
