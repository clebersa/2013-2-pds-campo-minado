package model;

public class Conteudo {

	/**
	 * Representação de um conteúdo. Os possíveis valores que esta variável pode
	 * assumir são:<br/>
	 * 'M' - Ícone que representa a presença de uma mina.<br/>
	 * '&nbsp' - Ícone que representa um conteúdo vazio.<br/>
	 * '1' ... '8' - Ícone que presenta a quantidade de minas vizinhas.
	 */
	private String icone;
	/**
	 * Tipo do conteúdo.
	 *
	 * @see model.TipoTabuleiro
	 */
	private TipoConteudo tipoConteudo;

	/**
	 * Cria um novo conteúdo.
	 */
	public void Conteudo() {
		setIcone(0);
	}

	/**
	 * Obtém o ícone do conteúdo.
	 *
	 * @return Ícone do conteúdo.
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * Define o ícone do conteúdo.
	 *
	 * @param minasVizinhas A quantidade de minas presentes na vizinhança do
	 * quadrado.<br/>
	 * Quando <tt>minasVizinhas &lt; 0</tt>, o tipo do conteúdo será definido
	 * para <tt>TipoConteudo.MINA</tt> e o ícone para '<tt>M</tt>'.<br/>
	 * Quando <tt>minasVizinhas = 0</tt>, o tipo do conteúdo será definido para
	 * <tt>TipoConteudo.VAZIO</tt> e o ícone para '<tt>&nbsp;</tt>'.<br/>
	 * Quando <tt>minasVizinhas &gt 0</tt>, o tipo do conteúdo será definido
	 * para <tt>TipoConteudo.NUMERO</tt> e o ícone para um número representando
	 * a quantidade de minas, que pode ir de <tt>1</tt> a <tt>8</tt>.
	 */
	public void setIcone(int minasVizinhas) {
		if (minasVizinhas > 0) {
			setTipo(TipoConteudo.NUMERO);
			icone = String.format("%d", minasVizinhas);
		} else if (minasVizinhas == 0) {
			setTipo(TipoConteudo.VAZIO);
			icone = " ";
		} else {
			setTipo(TipoConteudo.MINA);
			icone = "M";
		}
	}

	/**
	 * Obtém o tipo do conteúdo.
	 *
	 * @return Tipo do conteúdo.
	 * @see model.TipoConteudo
	 */
	public TipoConteudo getTipo() {
		return tipoConteudo;
	}

	/**
	 * Define o tipo da mina.
	 *
	 * @see model.TipoConteudo
	 */
	private void setTipo(TipoConteudo tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

	/**
	 * Adiciona uma mina ao conteúdo, mudando assim, seu tipo e ícone.
	 */
	public void adicionarMina() {
		setIcone(-1);
	}
}
