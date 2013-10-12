package model;

/**
 * Define os atributos e métodos de um quadrado.
 *
 * @author Cleber, Samuel
 */
public class Quadrado implements Exibivel {

	/**
	 * Indicador se o quadrado está aberto (
	 * <code>TRUE</code>) ou vazio (
	 * <code>FALSE</code>).
	 */
	private boolean aberto;
	private int minasVizinhas;
	private Conteudo conteudo;
	private Marcacao marcacao;

	/**
	 * Cria um quadrado. Na criação, o quadrado é criado fechado, com nenhuma
	 * mina vizinha contabilizada e com conteúdo e marcação padrões.
	 */
	Quadrado() {
		conteudo = new Conteudo();
		marcacao = new Marcacao();
		aberto = false;
		minasVizinhas = 0;
	}

	/**
	 * Abre o quadrado.
	 *
	 * @return Tipo do conteúdo do quadrado.
	 */
	public TipoConteudo abrir() {
		aberto = true;
		return conteudo.getTipo();
	}

	/**
	 * Marca o quadrado.
	 */
	public void marcar() {
		marcacao.marcar();
	}

	/**
	 * Adiciona uma mina ao quadrado.
	 */
	public void adicionarMina() {
		conteudo.adicionarMina();
	}

	/**
	 * Contabiliza o número de minas que estão presentes na vizinhança do
	 * quadrado, incrementando esse número em 1 (uma) unidade.
	 */
	public void contabilizarMinaVizinha() {
		conteudo.setIcone(++minasVizinhas);
	}

	/**
	 * Indica se o quadrado está aberto ou não.
	 *
	 * @return <code>TRUE</code> se o quadrado está aberto
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isAberto() {
		return aberto;
	}

	/**
	 * Indica se o quadrado contém uma mina ou não.
	 *
	 * @return <code>TRUE</code> se o quadrado contém uma mina
	 * ou <code>FALSE</code>, caso contrário.
	 */
	public boolean contemMina() {
		return conteudo.isMINA();
	}

	/**
	 * Exibe o quadrado.
	 *
	 * @see model.Exibivel#exibir()
	 */
	@Override
	public void exibir() {
		if (isAberto()) {
			System.out.print("[" + conteudo.getIcone() + "]");
		} else {
			System.out.print("[" + marcacao.getIcone() + "]");
		}
	}
}