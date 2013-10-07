package model;

public class Tabuleiro implements Exibivel {

	/**
	 * Tipo do tabuleiro.
	 *
	 * @see model.TipoTabuleiro
	 */
	private TipoTabuleiro tipoTabuleiro;
	/**
	 * Matriz de quadrados que formam o tabuleiro.
	 */
	private Quadrado[][] quadrados;
	/**
	 * Distribuidor de minas.
	 */
	private DistribuidorMinasInterface distribuidorMinasInterface;

	/**
	 * Constrói um novo tabuleiro com base no tipo recebido.
	 *
	 * @param tipo Tipo do tabuleiro.
	 */
	public void Tabuleiro(TipoTabuleiro tipo) {
		/*
		 * Após identificar qual é o tipo, inicializa o tabuleiro, 
		 * distribui as minas e, por fim, regula o tabuleiro com os números 
		 * indicadores de minas na vizinhança.
		 */
	}

	/**
	 * Executa uma jogada no tabuleiro.
	 *
	 * @param jogada Jogada a ser executada no tabuleiro.
	 * @return <tt>FALSE</tt> caso a jogada seja <tt>TipoJogada.ABRIR</tt> e o
	 * quadrado continha uma mina, ou <tt>TRUE</tt> para jogadas do tipo
	 * <tt>TipoJogada.MARCAR</tt> e/ou com o quadrado não continha mina.
	 */
	public boolean executarJogada(Jogada jogada) {
		boolean resultado;
		switch(jogada.getTipo()){
			case ABRIR:
				resultado = abrirQuadrado(jogada.getLinha(), jogada.getColuna());
				break;
			case MARCAR:
				marcarQuadrado(jogada.getLinha(), jogada.getColuna());
				resultado = true;
				break;
			default:
				resultado = false;
		}
		return resultado;
	}

	/**
	 * Inicializa o tabuleiro com quadrados vazios.
	 */
	private void inicializarTabuleiro() {
		//com base nas dimensões, criar quadrados e colocá-los na matriz
	}

	/**
	 * Distribui as minas pelo tabuleiro.
	 */
	private void distribuirMinas() {
		//usar a distribuição pela interface.
	}

	/**
	 * Para todos os quadrados do tabuleiro, contabiliza o número de minas que
	 * há na vizinhança.
	 */
	private void contabilizarMinasVizinhas() {
		//criar um laço de repetição e, para cada quadrado, chamar o método abaixo
	}

	/**
	 * Para um quadrado específico, contabiliza a quantidade de minas que há na
	 * vizinhança.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 */
	private void contabilizarMinasVizinhasQuadrado(int linha, int coluna) {
		//contabilizar os vizinhos
	}

	/**
	 * Abre um quadrado.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 * @return <tt>FALSE</tt>, caso o quadrado contenha uma mina; ou
	 * <tt>TRUE</tt>, caso contrário.
	 */
	private boolean abrirQuadrado(int linha, int coluna) {
		boolean resultado = false;
		try {
			if (quadrados[linha][coluna].estaAberto()) {
				resultado = true;
			}
		} catch (IndexOutOfBoundsException excecao) {
			resultado = true;
		}
		if (!resultado) {
			TipoConteudo tipoConteudo;
			tipoConteudo = quadrados[linha][coluna].abrir();
			if (tipoConteudo == TipoConteudo.MINA) {
				resultado = false;
			} else {
				linha -= 1;
				coluna -= 1;
				for (int counter = 0; counter < 3; counter++, coluna++) {
					abrirQuadrado(linha, coluna);
				}
				linha++;
				coluna--;
				for (int counter = 0; counter < 2; counter++, linha++) {
					abrirQuadrado(linha, coluna);
				}
				linha--;
				coluna--;
				for (int counter = 0; counter < 2; counter++, coluna--) {
					abrirQuadrado(linha, coluna);
				}
				linha--;
				coluna++;
				for (int counter = 0; counter < 1; counter++, linha--) {
					abrirQuadrado(linha, coluna);
				}
				resultado = true;
			}
		}

		return resultado;
	}

	/**
	 * Marca um quadrado.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 */
	private void marcarQuadrado(int linha, int coluna) {
		//marcar o quadrado.
	}

	/**
	 * Exibe o tabuleiro.
	 *
	 * @see model.Exibivel#exibir()
	 */
	@Override
	public void exibir() {
		//exibe quadrado por quadrado, até terminar a linha e depois quebra ela.
		//executa isso até terminar de imprimir toda a matriz.
	}
}
