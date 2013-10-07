package model;

public class Marcacao {

	/**
	 * Representação de uma marcação. Os possíveis valores que esta variável
	 * pode assumir são:<br/>
	 * '<tt>&nbsp;</tt>' - Ícone que representa nenhuma marcação.<br/>
	 * '<tt>B</tt>' - Ícone que representa a marcação com bandeira, indicando
	 * que naquele quadrado há uma mina.<br/>
	 * '<tt>?</tt>' - Ícone que representa a marcação com dúvida, quando não se
	 * tem certeza sobre o que existe dentro do quadrado.
	 */
	private String icone;
	/**
	 * Tipo da marcação.
	 *
	 * @see model.TipoMarcacao;
	 */
	private TipoMarcacao tipoMarcacao;

	/**
	 * Cria uma nova marcação.
	 * Na criação, a marcação é criada com o ícone '<tt>&nbsp;</tt>' e tipo
	 * <tt>TipoMarcacao.NENHUMA</tt>.
	 */
	public void Marcacao() {
		icone = " ";
		tipoMarcacao = TipoMarcacao.NENHUMA;
	}

	/**
	 * Obtém o ícone da marcação.
	 *
	 * @return Ícone da marcação.
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * Define o ícone e o tipo da marcação.
	 * Quando se marca um quadrado pela primeira vez, ele é marcado com uma
	 * Bandeira. Quando marcado novamente, ele é marcado com interrogação. Se
	 * marcado novamente, ele é desmarcado, assumindo uma marcação vazia.
	 */
	public void marcar() {
		switch(tipoMarcacao){
			case NENHUMA:
				icone = "B";
				tipoMarcacao = TipoMarcacao.BANDEIRA;
				break;
			case BANDEIRA:
				icone = "?";
				tipoMarcacao = TipoMarcacao.DUVIDA;
				break;
			case DUVIDA:
				icone = " ";
				tipoMarcacao = TipoMarcacao.NENHUMA;
				break;
			default:
				icone = " ";
				tipoMarcacao = TipoMarcacao.NENHUMA;
		}
	}
}
