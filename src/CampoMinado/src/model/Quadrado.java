package model;

public class Quadrado implements Exibivel {

	/**
	 * Indicador se o quadrado está aberto (<tt>TRUE</tt>) ou vazio
	 * (<tt>FALSE</tt>).
	 */
	private boolean aberto;
	private int minasVizinhas;
	private Conteudo conteudo;
	private Marcacao marcacao;

	/**
	 * Cria um quadrado. Na criação, o quadrado é criado fechado, com nenhuma
	 * mina vizinha contabilizada e com conteúdo e marcação padrões.
	 */
	public void Quadrado() {
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
	 * Indica se o quadrado contém uma mina ou não.
	 *
	 * @return <tt>TRUE</tt> se o quadrado contém uma mina ou <tt>FALSE</tt>,
	 * caso contrário.
	 */
	public boolean contemMina() {
		if (this.conteudo.getTipo() == TipoConteudo.MINA) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Exibe um quadrado.
	 *
	 * @see model.Exibivel#exibir()
	 */
	@Override
	public void exibir() {
		if (aberto) {
			System.out.print("[" + conteudo + "]");
		} else {
			System.out.print("[" + marcacao + "]");
		}
	}
}