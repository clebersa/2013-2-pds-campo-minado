package model;

public class Tabuleiro implements Exibivel {

    private TipoTabuleiro tipoTabuleiro;
    private Quadrado[] quadrado;
    private ExibivelInterface exibivelInterface;
    private ExibivelInterface exibivelInterface;
    private DistribuidorMinasInterface distribuidorMinasInterface;
    private Jogada jogada;
    private TipoConteudo tipoConteudo;

    /**
     * Constrói um novo tabuleiro com base no tipo recebido. Após identificar
     * qual é o tipo, inicializa o tabuleiro, insere as minas e, por fim, regula
     * o tabuleiro com os números indicadores de minas na vizinhança.
     */
    public void Tabuleiro(TipoTabuleiro tipo) {
    }

    public boolean executarJogada(Jogada jogada) {
        return false;
    }

    public void exibir() {
    }

    /**
     * Inicializa o tabuleiro com quadrados vazios.
     */
    private void inicializarTabuleiro() {
    }

    /**
     * Distribui as minas pelo tabuleiro.
     */
    private void distribuirMinas() {
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
     * Abre um quadrado. Se o quadrado conter uma mina, retorna false. Se tiver
     * um número, retorna true, se tiver vazio, chama a mesma função para a
     * abertura de cada um dos vizinhos.
     */
    private boolean abrirQuadrado(int linha, int coluna) {
        return false;
    }

    private void marcarQuadrado(int linha, int coluna) {
    }
}
