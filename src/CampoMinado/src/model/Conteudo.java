package model;

/**
 * Define os atributos e métodos para um conteúdo de um quadrado.
 *
 * @author Cleber, Samuel
 */
public class Conteudo {

	/**
	 * Representação de um conteúdo. Os possíveis valores que esta variável pode
	 * assumir são:<br/>
	 * '
	 * <code>M</code>' - Ícone que representa a presença de uma mina.<br/>
	 * '
	 * <code>&nbsp;</code>' - Ícone que representa um conteúdo vazio.<br/>
	 * '
	 * <code>1</code>' ... '
	 * <code>8</code>' - Ícone que representa a quantidade de minas vizinhas.
	 */
	private String icone;
	/**
	 * Tipo do conteúdo.
	 *
	 * @see model.TipoTabuleiro
	 */
	private TipoConteudo tipoConteudo;

	/**
	 * Cria um novo conteúdo. Na criação, o conteúdo é criado com o ícone
	 * <code>'&nbsp;'</code> e conteúdo
	 * <code>TipoConteudo.VAZIO</code>.
	 */
	public void Conteudo() {
		setTipo(TipoConteudo.VAZIO);
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
	 * Quando <code>minasVizinhas &lt; 0</code>, o tipo do conteúdo será
	 * definido para <code>TipoConteudo.MINA</code> e o ícone para
	 * '<code>M</code>'.<br/>
	 * Quando <code>minasVizinhas = 0</code>, o tipo do conteúdo será definido
	 * para <code>TipoConteudo.VAZIO</code> e o ícone para
	 * '<code>&nbsp;</code>'.<br/>
	 * Quando <code>minasVizinhas &gt 0</code>, o tipo do conteúdo será definido
	 * para <code>TipoConteudo.NUMERO</code> e o ícone para um número
	 * representando a quantidade de minas, que pode ir de <code>1</code>
	 * a <code>8</code>.
	 */
	public void setIcone(int minasVizinhas) {
		if (minasVizinhas < 0) {
			setTipo(TipoConteudo.MINA);
			icone = "M";
		} else if (minasVizinhas == 0 && getTipo() != TipoConteudo.MINA) {
			setTipo(TipoConteudo.VAZIO);
			icone = " ";
		} else if (getTipo() != TipoConteudo.MINA) {
			setTipo(TipoConteudo.NUMERO);
			icone = String.format("%d", minasVizinhas);
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
