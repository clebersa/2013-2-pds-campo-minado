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
    private DistribuidorMinas distribuidorMinas;

    /**
     * Constrói um novo tabuleiro com base no tipo recebido.
     *
     * @param tipo Tipo do tabuleiro.
     */
    Tabuleiro(TipoTabuleiro tipo) {
        tipoTabuleiro = tipo;
		
		quadrados = new Quadrado[getLinhas()][getColunas()];

        for (int linha = 0; linha < getLinhas(); linha++) {
            for (int coluna = 0; coluna < getColunas(); coluna++) {
                quadrados[linha][coluna] = new Quadrado(linha, coluna);
            }
        }
		
		TabuleiroIterator tabuleiroIterator = createTabuleiroIterator();
		VizinhosIterator iteradorVizinhos;
		Quadrado atual, vizinho;
        while (tabuleiroIterator.hasNext()) {
			atual = tabuleiroIterator.next();
			iteradorVizinhos = createVizinhosIterator(atual);
			while (iteradorVizinhos.hasNext()) {
				vizinho = iteradorVizinhos.next();
				atual.adicionarObservador(vizinho);
			}
		}
    }

    /**
     * Distribui as minas pelo tabuleiro.
	 * @param distribuidorMinas Distribuidor de minas que define o modo como as
	 * minas serão distribuídas. Os possíveis distribuidores implementam a
	 * interface {@link model.DistribuidorMinas}.
	 * 
	 * @see model.DistribuidorMinas
     */
    public void distribuirMinas(DistribuidorMinas distribuidorMinas) {
		this.distribuidorMinas = distribuidorMinas;
        this.distribuidorMinas.distribuirMinas(this);
		contabilizarMinasVizinhas();
    }
	
	/**
     * Para todos os quadrados do tabuleiro, contabiliza o número de minas que
     * há na vizinhança.
     */
    private void contabilizarMinasVizinhas() {
        TabuleiroIterator tabuleiroIterator = createTabuleiroIterator();
        while (tabuleiroIterator.hasNext()) {
            contabilizarMinasVizinhas(tabuleiroIterator.next());
        }
    }

    /**
     * Para um quadrado específico, contabiliza a quantidade de minas que há na
     * vizinhança.
     *
     * @param quadrado Quadrado que servirá como base para que as minhas vizinhas
     * sejam contabilizadas.
     */
    private void contabilizarMinasVizinhas(Quadrado quadrado) {
        VizinhosIterator iteradorVizinhos;
        iteradorVizinhos = createVizinhosIterator(quadrado);
        Quadrado vizinho;
        while (iteradorVizinhos.hasNext()) {
            vizinho = iteradorVizinhos.next();
            if (vizinho.contemMina()) {
                quadrado.contabilizarMinaVizinha();
            }
        }
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
    public ResultadoJogada executarJogada(Jogada jogada) {
        ResultadoJogada resultadoJogada;

        Quadrado quadradoJogada = getQuadrado(jogada.getLinha(), jogada.getColuna());

        if (jogada.isABRIR()) {
            if (abrirQuadrado(quadradoJogada)) {
                resultadoJogada = ResultadoJogada.VITORIA;
                TabuleiroIterator tabuleiroIterator = createTabuleiroIterator();
                while (tabuleiroIterator.hasNext()) {
                    Quadrado quadrado = tabuleiroIterator.next();
                    if (!quadrado.isAberto() && !quadrado.contemMina()) {
                        resultadoJogada = ResultadoJogada.CONTINUA;
                        break;
                    }
                }
            } else {
                resultadoJogada = ResultadoJogada.DERROTA;
                MinasIterator minasIterator = createMinasIterator();
                while (minasIterator.hasNext()) {
                    abrirQuadrado(minasIterator.next());
                }
            }
        } else {
            if (!quadradoJogada.isAberto()) {
                marcarQuadrado(quadradoJogada);
            }
            resultadoJogada = ResultadoJogada.CONTINUA;
        }
        return resultadoJogada;
    }

    /**
     * Obtém o número de linhas do tabuleiro.
     *
     * @return Número de linhas do tabuleiro.
     */
    public int getLinhas() {
        return tipoTabuleiro.getLinhas();
    }

    /**
     * Obtém a número de colunas do tabuleiro.
     *
     * @return Número de colunas do tabuleiro.
     */
    public int getColunas() {
        return tipoTabuleiro.getColunas();
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
     * Abre um quadrado.
     *
     * @param quadrado Quadrado que será aberto.
     * @return <code>FALSE</code>, caso o quadrado contenha uma mina; ou
     * <code>TRUE</code>, caso contrário.
     */
    private boolean abrirQuadrado(Quadrado quadrado) {
        boolean resultado = false;

        if (quadrado.isAberto()) {
            resultado = true;
        }
        if (!resultado) {
            TipoConteudo tipoConteudo;
            tipoConteudo = quadrado.abrir();
            if (tipoConteudo.isMINA()) {
                resultado = false;
            } else {
                resultado = true;
            }
        }

        return resultado;
    }

    /**
     * Marca um quadrado.
     *
     * @param quadrado Quadrado que será marcado.
     */
    private void marcarQuadrado(Quadrado quadrado) {
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
     * @param quadrado Quadrado sobre o qual irá se iterar sobre os vizinhos.
     * @return Um iterador para os quadrados vizinhos de <code>quadrado</code>.
     */
    public VizinhosIterator createVizinhosIterator(Quadrado quadrado) {
        return new VizinhosIterator(quadrados, quadrado);
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
        int coluna, linha;
		
		System.out.print("   ");
		for(coluna = 1; coluna<= getColunas(); coluna++){
			System.out.print(String.format("%2d ", coluna-1));
		}
		System.out.println();
		coluna = 0;
		linha = 0;
		System.out.print(String.format("%2d ", linha));
        while (tabuleiroIterator.hasNext()) {
            tabuleiroIterator.next().exibir();
            coluna++;
            if (coluna == tipoTabuleiro.getColunas()) {
                coluna = 0;
				if(linha < getLinhas() - 1){
					linha++;
					System.out.print(String.format("\n%2d ", linha));
				}else{
					System.out.println();
				}
            }
        }

        BandeirasIterator bandeirasIterator = createBandeirasIterator();
        int quantidadeBandeiras = 0;
        while (bandeirasIterator.hasNext()) {
            bandeirasIterator.next();
            quantidadeBandeiras++;
        }
        System.out.println("Bandeiras: " + quantidadeBandeiras + "/"
                + tipoTabuleiro.getMinas());
    }
}
