package model;

/**
 * Define os atributos e métodos para o conteúdo de um quadrado.<br/>Um conteúdo
 * contém o tipo e um ícone, que é o que será exibido por um quadrado, quando
 * este estiver aberto.<br/>Para cada tipo de conteúdo, existe um ícone
 * específico.
 *
 * @see TipoConteudo
 *
 * @author Cleber, Samuel
 */
public class Conteudo {

	/**
	 * Representação de um conteúdo. Os possíveis valores que esta variável pode
	 * assumir são:<br/>
	 * '
	 * <code>M</code>' - Ícone que representa a presença de uma mina. Este ícone
	 * está associado ao tipo {@link model.TipoConteudo#MINA}<br/>
	 * '
	 * <code>&nbsp;</code>' - Ícone que representa um conteúdo vazio. Este ícone
	 * está associado ao tipo {@link model.TipoConteudo#VAZIO}<br/>
	 * '
	 * <code>1</code>' ... '
	 * <code>8</code>' - Ícone que representa a quantidade de minas na
	 * vizinhança do quadrado. Este ícone está associado ao tipo
	 * {@link model.TipoConteudo#NUMERO}
	 */
	private String icone;
	/**
	 * Tipo do conteúdo.
	 *
	 * @see model.TipoTabuleiro
	 */
	private TipoConteudo tipoConteudo;

	/**
	 * Cria um novo conteúdo. Na criação, o conteúdo é criado com o ícone '
	 * <code>&nbsp;</code>' e tipo {@link model.TipoConteudo#VAZIO}.
	 */
	Conteudo() {
		setTipo(TipoConteudo.VAZIO);
		setIcone(0);
	}

	/**
	 * Obtém o ícone do conteúdo.<br/>Este ícone pode ser:<br/>
	 * '
	 * <code>M</code>' - Ícone que representa a presença de uma mina.<br/>
	 * '
	 * <code>&nbsp;</code>' - Ícone que representa um conteúdo vazio.<br/>
	 * '
	 * <code>1</code>' ... '
	 * <code>8</code>' - Ícone que representa a quantidade de minas na
	 * vizinhança do quadrado.
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
	 * definido para {@link model.TipoConteudo#MINA} e o ícone para
	 * '<code>M</code>'.<br/>
	 * Quando <code>minasVizinhas = 0</code>, o tipo do conteúdo será definido
	 * para {@link model.TipoConteudo#VAZIO} e o ícone para
	 * '<code>&nbsp;</code>'.<br/>
	 * Quando <code>minasVizinhas &gt 0</code>, o tipo do conteúdo será definido
	 * para {@link model.TipoConteudo#NUMERO} e o ícone para um número
	 * representando a quantidade de minas, que pode estar entre <code>1</code>
	 * e <code>8</code>.<br/>
	 * Se em algum momento o conteúdo for definido para mina, ele não poderá
	 * mais ser alterado, mesmo passando valores maiores que 0 para este método.
	 */
	public void setIcone(int minasVizinhas) {
		if (minasVizinhas < 0) {
			setTipo(TipoConteudo.MINA);
			icone = "M";
		} else if (minasVizinhas == 0 && !tipoConteudo.isMINA()) {
			setTipo(TipoConteudo.VAZIO);
			icone = " ";
		} else if (!tipoConteudo.isMINA()) {
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
	 * Define o tipo do conteúdo.
	 *
	 * @param tipoConteudo Tipo do conteúdo.
	 * @see model.TipoConteudo
	 */
	private void setTipo(TipoConteudo tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}

	/**
	 * Modifica o conteúdo para mina, mudando assim, seu tipo e ícone. Essas
	 * modificações serão feitas através da chamada do método
	 * {@link model.Conteudo#setIcone(int)}, enviando um número negativo (-1)
	 * para o mesmo.
	 */
	public void adicionarMina() {
		setIcone(-1);
	}

	/**
	 * Verifica se o conteúdo é do tipo {@link model.TipoConteudo#MINA}.
	 *
	 * @return <code>TRUE</code> se o conteúdo é do tipo
	 * {@link model.TipoConteudo#MINA} ou <code>FALSE</code>, caso contrário.
	 */
	public boolean isMINA() {
		return tipoConteudo.isMINA();
	}
}
