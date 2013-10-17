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
        /*
         * Após identificar qual é o tipo, inicializa o tabuleiro, 
         * distribui as minas e, por fim, regula o tabuleiro com os números 
         * indicadores de minas na vizinhança.
         */
        this.distribuidorMinasInterface = new DistribuiAleatorio(); // Somente p/ testes
        this.tipoTabuleiro = tipo;
        this.inicializarTabuleiro();
        this.distribuirMinas();
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
     * <code>linha</code> e <code>coluna</code>.
     * @param linha Linha do quadrado.
     * @param coluna Coluna do quadrado.
     * @return <code>TRUE</code> caso a mina seja adicionada com sucesso ou
     * <code>FALSE</code> caso o quadrado já contenha uma mina.
     */
    public boolean adicionarMina(int linha, int coluna) {
        if (!quadrados[linha][coluna].contemMina()) {
            quadrados[linha][coluna].adicionarMina();
            return true;
        }
        return false;
    }

    /**
     * Inicializa o tabuleiro com quadrados vazios.
     */
    private void inicializarTabuleiro() {
        this.quadrados = new Quadrado[this.getLinhas()][this.getColunas()];
        for (int linha = 0; linha < this.getLinhas(); linha++) {
            for (int coluna = 0; coluna < this.getColunas(); coluna++) {
                this.quadrados[linha][coluna] = new Quadrado();
            }
        }
    }

    /**
     * Distribui as minas pelo tabuleiro.
     */
    private void distribuirMinas() {
        this.distribuidorMinasInterface.distribuirMinas(this);
    }

    /**
     * Para todos os quadrados do tabuleiro, contabiliza o número de minas que
     * há na vizinhança.
     */
    private void contabilizarMinasVizinhas() {
        /*for (int linha = 0; linha < getLinhas(); linha++) {
            for (int coluna = 0; coluna < getLinhas(); coluna++) {
                contabilizarMinasVizinhasQuadrado(linha, coluna);
            }
        }*/
        
        VizinhosIterator interadorVizinhos;

        for (int cont = 0; cont < quadrados.length; cont++) {
            for (int cont2 = 0; cont2 < quadrados.length; cont2++) {
                
                interadorVizinhos = new VizinhosIterator(quadrados, cont, cont2);

                while (interadorVizinhos.hasNext()) {
                    Quadrado tempQuadrado = interadorVizinhos.next();
                    if (tempQuadrado.contemMina()) {
                        quadrados[cont][cont2].contabilizarMinaVizinha();
                    }
                }
                
            }

        }
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
    /*private void contabilizarMinasVizinhasQuadrado(int linha, int coluna) {
        VizinhosIterator interadorVizinhos;

        for (int cont = 0; cont < quadrados.length; cont++) {
            for (int cont2 = 0; cont2 < quadrados.length; cont2++) {
                
                interadorVizinhos = new VizinhosIterator(quadrados, cont, cont2);

                while (interadorVizinhos.hasNext()) {
                    Quadrado tempQuadrado = interadorVizinhos.next();
                    if (tempQuadrado.contemMina()) {
                        quadrados[cont][cont2].contabilizarMinaVizinha();
                    }
                }
            }

        }
        //contabilizar os vizinhos
    }*/

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
        boolean resultado = false;
        try {
            if (quadrados[linha][coluna].isAberto()) {
                resultado = true;
            }
        } catch (IndexOutOfBoundsException excecao) {
            resultado = true;
        }
        if (!resultado) {
            TipoConteudo tipoConteudo;
            tipoConteudo = quadrados[linha][coluna].abrir();
            if (tipoConteudo.isMINA()) {
                resultado = false;
            } else if (tipoConteudo.isNUMERO()) {
                resultado = true;
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
        quadrados[linha][coluna].marcar();
    }

    public BandeirasIterator createBandeirasIterator() {
        return new BandeirasIterator(quadrados);
    }

    public VizinhosIterator createVizinhosIterator(int linhaQuadrado,
            int colunaQuadrado) {
        return new VizinhosIterator(quadrados, linhaQuadrado, colunaQuadrado);
    }

    public MinasIterator createMinasIterator() {
        return new MinasIterator(quadrados);
    }

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
        for (int cont = 0; cont < this.getLinhas(); cont++) {
            for (int cont2 = 0; cont2 < this.getColunas(); cont2++) {
                this.quadrados[cont][cont2].exibir();
            }
            System.out.println("");
        }
        //exibe quadrado por quadrado, até terminar a linha e depois quebra ela.
        //executa isso até terminar de imprimir toda a matriz.
    }
}
