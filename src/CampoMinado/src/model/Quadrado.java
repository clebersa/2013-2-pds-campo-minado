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
        //implementar conforme a descrição
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
        //marcar o quadrado usando a referência de marcação
    }

    /**
     * Adiciona uma mina a este quadrado, modificando seu conteúdo.
     */
    public void adicionarMina() {
		this.conteudo.adicionarMina();
        //modificar o conteúdo para mina usando a referência de conteúdo
    }

    /**
     * Contabiliza o número de minas que estão presentes na vizinhança do
     * quadrado, incrementando esse número em 1 (uma) unidade.
     */
    public void contabilizarMinaVizinha() {
		this.minasVizinhas++;
        //incrementar +1 no número de minas vizinhas.
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
        //A exibição deve ser feita com System.out.print, segundo o formato [L],
        //onde L representa o q será apresentado. No caso, se o quadrado estiver fechado, exibe a marcação
        // se estiver aberto, exibe o conteúdo.
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
        //verificar conteudo para retornar a informação correta
    }
}
