package model;

/**
 * Define os atributos e métodos para a marcação de um quadrado.<br/>Uma
 * marcação contém um tipo e um ícone, que é o que será exibido por um quadrado,
 * quando este estiver fechado.<br/>Para cada tipo de marcação, existe um ícone
 * específico.
 *
 * @see TipoMarcacao
 *
 * @author Cleber, Samuel
 */
public class Marcacao {

	/**
	 * Representação de uma marcação. Os possíveis valores que esta variável
	 * pode assumir são:<br/>
	 * '
	 * <code>B</code>' - Ícone que representa a marcação com bandeira, indicando
	 * que naquele quadrado há uma mina. Este ícone está associado ao tipo
	 * {@link model.TipoMarcacao#BANDEIRA}.<br/>
	 * '
	 * <code>?</code>' - Ícone que representa a marcação com dúvida, quando não
	 * se tem certeza se existe uma mina no quadrado.Este ícone está associado
	 * ao tipo {@link model.TipoMarcacao#DUVIDA<br/>
	 * '
	 * <code>&nbsp;</code>' - Ícone que representa nenhuma marcação. Este ícone
	 * está associado ao tipo {@link model.TipoMarcacao#NENHUMA}.<br/>
	 */
	private String icone;
	/**
	 * Tipo da marcação.
	 *
	 * @see model.TipoMarcacao;
	 */
	private TipoMarcacao tipoMarcacao;

	/**
	 * Cria uma nova marcação. Na criação, a marcação é criada com o ícone '
	 * <code>&nbsp;</code>' e tipo
	 * <code>TipoMarcacao.NENHUMA</code>.
	 */
	Marcacao() {
		icone = " ";
		tipoMarcacao = TipoMarcacao.NENHUMA;
	}

	/**
	 * Obtém o ícone da marcação.<br/>Este ícone pode ser:<br/>
	 * '
	 * <code>B</code>' - Ícone que representa a marcação com bandeira, indicando
	 * que naquele quadrado há uma mina. Este ícone está associado ao tipo
	 * {@link model.TipoMarcacao#BANDEIRA}.<br/>
	 * '
	 * <code>?</code>' - Ícone que representa a marcação com dúvida, quando não
	 * se tem certeza se existe uma mina no quadrado.Este ícone está associado
	 * ao tipo {@link model.TipoMarcacao#DUVIDA<br/>
	 * '
	 * <code>&nbsp;</code>' - Ícone que representa nenhuma marcação. Este ícone
	 * está associado ao tipo {@link model.TipoMarcacao#NENHUMA}.<br/>
	 *
	 * @return Ícone da marcação.
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * Obtém o tipo da marcação.
	 *
	 * @return Tipo da marcação.
	 * @see model.TipoMarcacao
	 */
	public TipoMarcacao getTipo() {
		return tipoMarcacao;
	}

	/**
	 * Muda a marcação, definindo o ícone e o tipo da marcação.<br/>Quando se
	 * marca um quadrado pela primeira vez, indica-se que nele há uma
	 * mina.<br/>Quando marcado novamente, indica-se que não se tem certeza de
	 * que nele há uma mina.<br/>Se marcado novamente, o quadrado perde a
	 * marcação e fica dermarcado, ou seja, com nenhuma marcação.
	 */
	public void marcar() {
		if (tipoMarcacao.isNENHUMA()) {
			icone = "B";
			tipoMarcacao = TipoMarcacao.BANDEIRA;
		} else if (tipoMarcacao.isBANDEIRA()) {
			icone = "?";
			tipoMarcacao = TipoMarcacao.DUVIDA;
		} else if (tipoMarcacao.isDUVIDA()) {
			icone = " ";
			tipoMarcacao = TipoMarcacao.NENHUMA;
		}
	}

	/**
	 * Limpa a marcação, fazendo com que ela tenha o ícone '
	 * <code>&nbsp;</code>' e tipo
	 * <code>TipoMarcacao.NENHUMA</code>.
	 */
	public void limpar() {
		if (tipoMarcacao.isBANDEIRA()) {
			marcar();
			marcar();
		} else if (tipoMarcacao.isDUVIDA()) {
			marcar();
		}
	}
}
