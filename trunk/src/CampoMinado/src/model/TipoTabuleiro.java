package model;

/**
 * Define os tipos de tabuleiro possíveis que existem.
 *
 * @author Cleber, Samuel
 */
public enum TipoTabuleiro {

	/**
	 * Indica que o tabuleiro tem as configurações de iniciante.
	 */
	INICIANTE(new ConfiguracoesTipoTabuleiro(9, 9, 10)),
	/**
	 * Indica que o tabuleiro tem as configurações de intermediário.
	 */
	INTERMEDIARIO(new ConfiguracoesTipoTabuleiro(16, 16, 40)),
	/**
	 * Indica que o tabuleiro tem as configurações de avançado.
	 */
	AVANCADO(new ConfiguracoesTipoTabuleiro(20, 24, 99));
	/**
	 * Configurações do tipo do tabuleiro.
	 */
	private final ConfiguracoesTipoTabuleiro configuracoesTipoTabuleiro;

	/**
	 * Cria um tipo de tabuleiro.
	 *
	 * @param configuracoesTipoTabuleiro Configurações do tipo do tabuleiro.
	 */
	TipoTabuleiro(ConfiguracoesTipoTabuleiro configuracoesTipoTabuleiro) {
		this.configuracoesTipoTabuleiro = configuracoesTipoTabuleiro;
	}

	/**
	 * Obtém o número de linhas do tipo do tabuleiro.
	 *
	 * @return Número de linhas do tipo do tabuleiro.
	 */
	public int getLinhas() {
		return configuracoesTipoTabuleiro.linhas;
	}

	/**
	 * Obtém o número de colunas do tipo do tabuleiro.
	 *
	 * @return Número de colunas do tipo do tabuleiro.
	 */
	public int getColunas() {
		return configuracoesTipoTabuleiro.colunas;
	}

	/**
	 * Obtém o número de minas do tipo do tabuleiro.
	 *
	 * @return Número de minas do tipo do tabuleiro.
	 */
	public int getMinas() {
		return configuracoesTipoTabuleiro.minas;
	}

	private static class ConfiguracoesTipoTabuleiro {

		/**
		 * Número de linhas do tabuleiro.
		 */
		private int linhas;
		/**
		 * Número de colunas do tabuleiro.
		 */
		private int colunas;
		/**
		 * Número de minas do tabuleiro.
		 */
		private int minas;

		/**
		 * Cria uma nova configuração de um tipo de tabuleiro.
		 *
		 * @param linhas Número de linhas do tabuleiro.
		 * @param colunas Número de colunas do tabuleiro.
		 * @param minas Número de minas do tabuleiro.
		 */
		public ConfiguracoesTipoTabuleiro(int linhas, int colunas, int minas) {
			this.linhas = linhas;
			this.colunas = colunas;
			this.minas = minas;
		}
	}
}
