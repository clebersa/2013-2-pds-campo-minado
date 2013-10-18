package model;

/**
 * Define os atributos e métodos para uma marcação de um quadrado.
 *
 * @author Cleber, Samuel
 */
public class Marcacao {

	/**
	 * Representação de uma marcação. Os possíveis valores que esta variável
	 * pode assumir são:<br/>
	 * '
	 * <code>&nbsp;</code>' - Ícone que representa nenhuma marcação.<br/>
	 * '
	 * <code>B</code>' - Ícone que representa a marcação com bandeira, indicando
	 * que naquele quadrado há uma mina.<br/>
	 * '
	 * <code>?</code>' - Ícone que representa a marcação com dúvida, quando não
	 * se tem certeza sobre o que existe dentro do quadrado.
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
	 * Obtém o ícone da marcação.
	 *
	 * @return Ícone da marcação.
	 */
	public String getIcone() {
		return icone;
	}

	/**
	 * Define o ícone e o tipo da marcação. Quando se marca um quadrado pela
	 * primeira vez, ele é marcado com uma Bandeira. Quando marcado novamente,
	 * ele é marcado com interrogação. Se marcado novamente, ele é desmarcado,
	 * assumindo uma marcação vazia.
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
	 * Limpa a marcação, fazendo com que ela tenha o ícone '<code>&nbsp;</code>'
	 * e tipo <code>TipoMarcacao.NENHUMA</code>.
	 */
	public void limpar(){
		if(tipoMarcacao.isBANDEIRA()){
			marcar();
			marcar();
		}else if(tipoMarcacao.isDUVIDA()){
			marcar();
		}
	}
}
