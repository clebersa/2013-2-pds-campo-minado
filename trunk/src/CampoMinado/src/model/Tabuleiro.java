package model;

public class Tabuleiro implements Exibivel {

    private TipoTabuleiro tipoTabuleiro;
    private Quadrado[] quadrado;
    private DistribuidorMinasInterface distribuidorMinasInterface;
    private Jogada jogada;
    private TipoConteudo tipoConteudo;

    /**
     * Constrói um novo tabuleiro com base no tipo recebido.
     *
     * @param tipo Tipo do tabuleiro.
     */
    public void Tabuleiro(TipoTabuleiro tipo) {
        //Após identificar qual é o tipo, inicializa o tabuleiro, insere as minas e, por fim, regula o tabuleiro com os números indicadores de minas na vizinhança.
    }

    /**
     * Executa uma jogada no tabuleiro.
     *
     * @param jogada Jogada a ser executada no tabuleiro.
     * @return FALSE caso a jogada tenha sido abrir e o quadrado tinha uma mina,
     * ou TRUE para jogadas de marcação e/ou com o quadrado que não tinha mina.
     */
    public boolean executarJogada(Jogada jogada) {
        //deixa pra eu, cleber, implementar *-*
        return false;
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
     * Para cada quadrado do tabuleiro, contabiliza o número de minas que há na
     * vizinhança.
     */
    private void contabilizarMinasVizinhas() {
    }

    /**
     * Para um quadrado específico, contabiliza a quantidade de minas que há na
     * vizinhança.
     */
    private void contabilizarMinasVizinhasQuadrado(int linha, int coluna) {
    }

    /**
     * Abre um quadrado.
     *
     * @param linha Número da linha onde o quadrado está localizado no
     * tabuleiro.
     * @param coluna Número da coluna onde o quadrado está localizado no
     * tabuleiro.
     * @return FALSE, caso o quadrado contenha uma mina, ou TRUE, caso
     * contrário.
     */
    private boolean abrirQuadrado(int linha, int coluna) {
        //deixa pra eu, cleber, implementar *-*
        //Se o quadrado conter uma mina, retorna false. Se tiver um número, retorna true, se tiver vazio, chama a mesma função para a abertura de cada um dos vizinhos.
        return false;
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
    }

    /**
     * @see model.Exibivel#exibir()
     */
    public void exibir() {
        //exibe botão por botão até terminar a linha e depois quebra ela.
    }
}
