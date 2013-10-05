package model;

public enum TipoTabuleiro {

	;

	private TipoTabuleiro.InfoTipoTabuleiro INICIANTE;

	private TipoTabuleiro.InfoTipoTabuleiro INTERMEDIARIO;

	private TipoTabuleiro.InfoTipoTabuleiro AVANCADO;

	private TipoTabuleiro.InfoTipoTabuleiro infoTipoTabuleiro;

	public void getLinhas() {

	}

	public void getColunas() {

	}

	public void getMinas() {

	}

	private class InfoTipoTabuleiro {

		private int linhas;

		private int colunas;

		private int minas;

		public void InfoTipo(int linhas, int colunas, int minas) {

		}

	}

}
