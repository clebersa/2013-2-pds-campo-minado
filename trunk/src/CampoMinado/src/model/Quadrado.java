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
		this.conteudo = new Conteudo();
		this.marcacao = new Marcacao();
		this.aberto = false;
		this.minasVizinhas = 0;
    }

    /**
     * Abre o quadrado, mudando o valor de aberto para true.
     *
     * @return Tipo do conteúdo do quadrado.
     */
    public TipoConteudo abrir() {
		this.aberto = true;
        return conteudo.getTipo();
    }

    /**
     * Marca o quadrado.
     */
    public void marcar() {
		this.marcacao.marcar();
    }

    /**
     * Adiciona uma mina a este quadrado, modificando seu conteúdo.
     */
    public void adicionarMina() {
		this.conteudo.adicionarMina();
    }

    /**
     * Contabiliza o número de minas que estão presentes na vizinhança do
     * quadrado, incrementando esse número em 1 (uma) unidade.
     */
    public void contabilizarMinaVizinha() {
		this.minasVizinhas++;
    }

    /**
     * Exibe um quadrado.
     */
    public void exibir() {
    
		if(this.aberto == true){
			System.out.print("[" + this.conteudo + "]");
		}else{
			System.out.print("[" + this.marcacao + "]");
		}
    }

    /**
     * Indica se o quadrado contém uma mina ou não.
     * @return TRUE se o quadrado contém uma mina ou FALSE, caso contrário.
     */
    public boolean contemMina() {
		if(this.conteudo.getTipo() == TipoConteudo.MINA){
			return true;
		else
			return false;
    }
}
