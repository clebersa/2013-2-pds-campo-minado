package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Define os atributos e métodos de um quadrado.
 *
 * @author Cleber, Samuel
 */
public class Quadrado implements Exibivel, Observavel, Observador {

	/**
	 * Indica se o quadrado está aberto (
	 * <code>TRUE</code>) ou vazio (
	 * <code>FALSE</code>).
	 */
	private boolean aberto;
	
	/**
	 * Indica a quantidadede minas existentes na vizinhança do quadrado.
	 */
	private int minasVizinhas;
	
	/**
	 * Conteúdo do quadrado.
	 */
	private Conteudo conteudo;
	
	/**
	 * Marcação do quadrado.
	 */
	private Marcacao marcacao;
	
	/**
	 * Linha do quadrado no tabuleiro.
	 */
	private int linha;
	
	/**
	 * Coluna do quadrado no tabuleiro.
	 */
	private int coluna;
	
	/**
	 * Lista de observadores do quadrado.
	 */
	private List<Quadrado> observadores;
	
	/**
	 * Lista de quadrados que este quadrado observa.
	 */
	private List<Quadrado> observados;

	/**
	 * Cria um quadrado. Na criação, o quadrado é criado fechado, com nenhuma
	 * mina vizinha contabilizada e com conteúdo e marcação padrões.
	 */
	Quadrado(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		conteudo = new Conteudo();
		marcacao = new Marcacao();
		aberto = false;
		minasVizinhas = 0;
		observadores = new ArrayList<>();
		observados = new ArrayList<>();
	}

	/**
	 * Obtém a linha do quadrado.
	 *
	 * @return Linha do quadrado.
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * Obtém a coluna do quadrado.
	 *
	 * @return Coluna do quadrado.
	 */
	public int getColuna() {
		return coluna;
	}

	/**
	 * Abre o quadrado.
	 *
	 * @return Tipo do conteúdo do quadrado.
	 */
	public TipoConteudo abrir() {
		marcacao.limpar();
		if(!aberto){
			aberto = true;
			if (conteudo.getTipo().isVAZIO()) {
				notificarObservadores();
			}
		}
		
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
	 * Obtém o tipo da marcação.
	 */
	public TipoMarcacao getTipoMarcacao() {
		return marcacao.getTipo();
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

	@Override
	public void adicionarObservador(Quadrado observador) {
		observadores.add(observador);
	}

	@Override
	public void removerObservador(Quadrado observador) {
		observadores.remove(observador);
	}

	@Override
	public void notificarObservadores() {
		Iterator iterator = observadores.iterator();
		Quadrado observador;
		while (iterator.hasNext()) {
			observador = (Quadrado) iterator.next();
			observador.update(this);
		}
	}

	/**
	 * Atualiza um quadrado quando o quadrado que ele observa tiver uma 
	 * mina adicionada ou for aberto e não contiver nada.
	 */
	@Override
	public void update(Quadrado observado) {
		abrir();
	}

	@Override
	public boolean equals(Object obj) {
		Quadrado outro = (Quadrado) obj;
		if(outro.linha == this.linha && outro.coluna == this.coluna){
			return true;
		}else{
			return false;
		}
	}
	
	
}