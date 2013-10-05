package model;

public class Quadrado implements Exibivel {

    private boolean aberto;
    private int minasVizinhas;
    private Conteudo conteudo;
    private Marcacao marcacao;
    private ExibivelInterface exibivelInterface;

    /**
     * Cria um quadrado padrão, com conteúdo padrão, marcação padrão, fechado e
     * com nenhuma mina vizinha contabilizada.
     */
    public void Quadrado() {
    }

    /**
     * Abre o quadrado, mudando o valor da variável "aberto" para true. Se o
     * quadrado tiver uma mina, o método retorna false. Caso contrário, retorna
     * true.
     */
    public TipoConteudo abrir() {
        return null;
    }

    /**
     * Marca o quadrado
     */
    public void marcar() {
    }

    public void adicionarMina() {
    }

    public void contabilizarMinaVizinha() {
    }

    public void exibir() {
    }

    public boolean contemMina() {
        return false;
    }
}
