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
}
