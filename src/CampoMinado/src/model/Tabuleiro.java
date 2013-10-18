package model;

/**
 * Define os atributos e métodos de um tabuleiro.
 *
 * @author Cleber, Samuel
 */
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
	private DistribuidorMinas distribuidorMinasInterface;

	/**
	 * Constrói um novo tabuleiro com base no tipo recebido.
	 *
	 * @param tipo Tipo do tabuleiro.
	 */
	Tabuleiro(TipoTabuleiro tipo) {
		distribuidorMinasInterface = new DistribuiAleatorio();
		tipoTabuleiro = tipo;
		inicializarTabuleiro();
		distribuirMinas();
		contabilizarMinasVizinhas();
	}

	/**
	 * Executa uma jogada no tabuleiro.
	 *
	 * @param jogada Jogada a ser executada no tabuleiro.
	 * @return <code>FALSE</code> caso a jogada seja
	 * <code>TipoJogada.ABRIR</code> e o quadrado continha uma mina, ou
	 * <code>TRUE</code> para jogadas do tipo <code>TipoJogada.MARCAR</code>
	 * e/ou com o quadrado não continha mina.
	 */
	public boolean executarJogada(Jogada jogada) {
		boolean resultado;
		if (jogada.isABRIR()) {
			resultado = abrirQuadrado(jogada.getLinha(), jogada.getColuna());
		} else if (jogada.isMARCAR()) {
			marcarQuadrado(jogada.getLinha(), jogada.getColuna());
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	/**
	 * Obtém o número de linhas do tabuleiro.
	 *
	 * @return Número de linhas do tabuleiro.
	 */
	public int getLinhas() {
		return this.tipoTabuleiro.getLinhas();
	}

	/**
	 * Obtém a número de colunas do tabuleiro.
	 *
	 * @return Número de colunas do tabuleiro.
	 */
	public int getColunas() {
		return this.tipoTabuleiro.getColunas();
	}

	/**
	 * Obtém a número de minas do tabuleiro.
	 *
	 * @return Número de minas do tabuleiro.
	 */
	public int getMinas() {
		return tipoTabuleiro.getMinas();
	}

	/**
	 * Adiciona uma mina a um determinado quadrado especificado por
	 * <code>linha</code> e
	 * <code>coluna</code>.
	 *
	 * @param linha Linha do quadrado.
	 * @param coluna Coluna do quadrado.
	 * @return <code>TRUE</code> caso a mina seja adicionada com sucesso ou
	 * <code>FALSE</code> caso o quadrado já contenha uma mina.
	 */
	public boolean adicionarMina(int linha, int coluna) {
		Quadrado quadrado;
		quadrado = getQuadrado(linha, coluna);
		if (!quadrado.contemMina()) {
			quadrado.adicionarMina();
			return true;
		}
		return false;
	}

	/**
	 * Obém um quadrado com base na linha e coluna informadas.
	 *
	 * @param linha Linha do quadrado.
	 * @param coluna Coluna do quadrado.
	 * @return O quadrado correspondente à linha e coluna informadas.
	 */
	private Quadrado getQuadrado(int linha, int coluna) throws ArrayIndexOutOfBoundsException {
		return quadrados[linha][coluna];
	}

	/**
	 * Inicializa o tabuleiro com quadrados vazios.
	 */
	private void inicializarTabuleiro() {
		quadrados = new Quadrado[getLinhas()][getColunas()];

		TabuleiroIterator tabuleiroIterator = createTabuleiroIterator();

		Quadrado quadrado;

		while (tabuleiroIterator.hasNext()) {
			quadrado = tabuleiroIterator.next();
			quadrado = new Quadrado();
		}
	}

	/**
	 * Distribui as minas pelo tabuleiro.
	 */
	private void distribuirMinas() {
		distribuidorMinasInterface.distribuirMinas(this);
	}

	/**
	 * Para todos os quadrados do tabuleiro, contabiliza o número de minas que
	 * há na vizinhança.
	 */
	private void contabilizarMinasVizinhas() {
		TabuleiroIterator tabuleiroIterator = createTabuleiroIterator();
		while (tabuleiroIterator.hasNext()) {
			contabilizarMinasVizinhas(tabuleiroIterator.getLinhaVizinho(),
					tabuleiroIterator.getColunaVizinho());
		}
	}

	/**
	 * Para um quadrado específico, contabiliza a quantidade de minas que há na
	 * vizinhança.
	 *
	 * @param linha Linha do quadrado.
	 * @param coluna Coluna do quadrado.
	 */
	private void contabilizarMinasVizinhas(int linha, int coluna) {
		VizinhosIterator interadorVizinhos;
		interadorVizinhos = new VizinhosIterator(quadrados, linha, coluna);
		Quadrado vizinho;
		while (interadorVizinhos.hasNext()) {
			vizinho = interadorVizinhos.next();
			if (vizinho.contemMina()) {
				getQuadrado(linha, coluna).contabilizarMinaVizinha();
			}
		}
	}

	/**
	 * Abre um quadrado.
	 *
	 * @param linha Número da linha onde o quadrado está localizado no
	 * tabuleiro.
	 * @param coluna Número da coluna onde o quadrado está localizado no
	 * tabuleiro.
	 * @return <code>FALSE</code>, caso o quadrado contenha uma mina; ou
	 * <code>TRUE</code>, caso contrário.
	 */
	private boolean abrirQuadrado(int linha, int coluna) {
		Quadrado quadrado;
		boolean resultado = false;

		quadrado = getQuadrado(linha, coluna);
		if (quadrado.isAberto()) {
			resultado = true;
		}
		if (!resultado) {
			TipoConteudo tipoConteudo;
			tipoConteudo = quadrado.abrir();
			if (tipoConteudo.isMINA()) {
				resultado = false;
			} else if (tipoConteudo.isNUMERO()) {
				resultado = true;
			} else {
				VizinhosIterator vizinhosIterator = createVizinhosIterator(linha,
						coluna);
				while (vizinhosIterator.hasNext()) {
					abrirQuadrado(vizinhosIterator.getLinhaVizinho(),
							vizinhosIterator.getColunaVizinho());
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
		Quadrado quadrado = getQuadrado(linha, coluna);
		quadrado.marcar();
	}

	/**
	 * Cria um iterador para os quadrados marcados com bandeira.
	 *
	 * @return Um iterador para os quadrados marcados com bandeira.
	 */
	public BandeirasIterator createBandeirasIterator() {
		return new BandeirasIterator(quadrados);
	}

	/**
	 * Cria um iterador para os quadrados vizinhos de um quadrado.
	 *
	 * @param linha Linha do quadrado sobre o qual vai se iterar sobre
	 * os vizinhos.
	 * @param coluna Coluna do quadrado sobre o qual vai se iterar sobre
	 * os vizinhos.
	 * @return Um iterador para os quadrados vizinhos de <code>quadrado</code>.
	 */
	public VizinhosIterator createVizinhosIterator(int linha, int coluna) {
		return new VizinhosIterator(quadrados, linha, coluna);
	}

	/**
	 * Cria um iterador para os quadrados que contêm minas.
	 *
	 * @return Um iterador para os quadrados que contêm minas.
	 */
	public MinasIterator createMinasIterator() {
		return new MinasIterator(quadrados);
	}

	/**
	 * Cria um iterador para todos os quadrados do tabuleiro.
	 *
	 * @return Um iterador para todos os quadrados do tabuleiro.
	 */
	public TabuleiroIterator createTabuleiroIterator() {
		return new TabuleiroIterator(quadrados);
	}

	/**
	 * Exibe o tabuleiro.
	 *
	 * @see model.Exibivel#exibir()
	 */
	@Override
	public void exibir() {
		TabuleiroIterator tabuleiroIterator = createTabuleiroIterator();
		int coluna = 0;
		while(tabuleiroIterator.hasNext()){
			tabuleiroIterator.next().exibir();
			coluna++;
			if(coluna == tipoTabuleiro.getColunas()){
				coluna = 0;
				System.out.println();
			}
		}
		
		BandeirasIterator bandeirasIterator = createBandeirasIterator();
		int quantidadeBandeiras = 0;
		while(bandeirasIterator.hasNext()){
			bandeirasIterator.next();
			quantidadeBandeiras++;
		}
		System.out.println("Bandeiras: "+quantidadeBandeiras+"/"+
				tipoTabuleiro.getMinas());
	}
}
