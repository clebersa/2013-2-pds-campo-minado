package model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Define os atributos e métodos para a execução da aplicação Campo Minado.
 *
 * @author Cleber, Samuel
 */
public class CampoMinado {

	private static Tabuleiro tabuleiro;
	private static ArrayList<Jogada> jogadas;

	/**
	 * Executa o fluxo principal da aplicação Campo Minado
     * @param args
	 */
	public static void main(String args[]) {
		int opcao;
		boolean jogoCriado;

		Scanner leitor = new Scanner(System.in);

		System.out.println("############### CAMPO MINADO ###############");
		do {
			System.out.print("Selecione uma ação:\n"
					+ "\t1 - Novo jogo\n\n"
					+ "\t0 - Sair\n"
					+ "Opção: ");
			opcao = leitor.nextInt();
			switch (opcao) {
				case 1:
					jogoCriado = iniciarNovoJogo();
					if (jogoCriado) {
						jogar();
					}
					break;
				case 0:
					System.out.println("Você saiu do jogo!");
					break;
				default:
					System.out.println("Tipo de tabuleiro inválido!");
			}
		} while (opcao != 0);
	}

	/**
	 * Inicia um novo jogo.
	 */
	private static boolean iniciarNovoJogo() {
		int opcao;

		Scanner leitor = new Scanner(System.in);

		do {
			System.out.print("Selecione o tipo de tabuleiro:\n"
					+ "\t1 - Iniciante\n"
					+ "\t2 - Intermediário\n"
					+ "\t3 - Avançado\n\n"
					+ "\t0 - Cancelar novo jogo\n"
					+ "Opção: ");
			opcao = leitor.nextInt();
			switch (opcao) {
				case 1:
					tabuleiro = new Tabuleiro(TipoTabuleiro.INICIANTE);
					tabuleiro.distribuirMinas(new DistribuiAleatorio());
					break;
				case 2:
					tabuleiro = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
					tabuleiro.distribuirMinas(new DistribuiAleatorio());
					break;
				case 3:
					tabuleiro = new Tabuleiro(TipoTabuleiro.AVANCADO);
					tabuleiro.distribuirMinas(new DistribuiAleatorio());
					break;
				case 0:
					break;
				default:
					System.out.println("Tipo de tabuleiro inválido!");
			}
		} while (opcao < 0 || opcao > 3);

		if (opcao != 0) {
			jogadas = new ArrayList<>();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lê uma jogada do usuário e executa a mesma.
	 *
	 * @return O resultado da jogada.
	 */
	private static void jogar() {
		int opcao, linha, coluna;
		Jogada jogada;
		ResultadoJogada resultadoJogada;

		Scanner leitor = new Scanner(System.in);

		tabuleiro.exibir();

		do {
			System.out.print("Selecione um tipo de jogada:\n"
					+ "\t1 - Abrir\n"
					+ "\t2 - Marcar\n\n"
					+ "\t0 - Parar de jogar\n"
					+ "Opção: ");
			opcao = leitor.nextInt();
			switch (opcao) {
				case 1:
				case 2:
					do {
						System.out.print("Informe a linha do quadrado: (0 - "
								+ (tabuleiro.getLinhas() - 1) + "): ");
						linha = leitor.nextInt();
						if(linha < 0 || linha > tabuleiro.getLinhas() - 1){
							System.out.println("Valor de linha inválido!");
						}
					} while (linha < 0 || linha > tabuleiro.getLinhas() - 1);
					do {
						System.out.print("Informe a coluna do quadrado: (0 - "
								+ (tabuleiro.getColunas() - 1) + "): ");
						coluna = leitor.nextInt();
						if(coluna < 0 || coluna > tabuleiro.getColunas() -1){
							System.out.println("Valor de coluna inválido!");
						}
					} while (coluna < 0 || coluna > tabuleiro.getColunas() - 1);
					
					if(opcao == 1){
						jogada = new Jogada(linha, coluna, TipoJogada.ABRIR);
					}else{
						jogada = new Jogada(linha, coluna, TipoJogada.MARCAR);
					}
					jogadas.add(jogada);
					
					resultadoJogada = tabuleiro.executarJogada(jogada);
					
					if(resultadoJogada.isVITORIA()){
						System.out.println("Parabéns! Você venceu!");
						opcao = 0;
					}else if(resultadoJogada.isDERROTA()){
						System.out.println("Pow! Você atingiu uma mina! Você perdeu!");
						opcao = 0;
					}else{
						System.out.println("Continue jogando...");
					}
					tabuleiro.exibir();
					break;
				case 0:
					break;
				default:
					System.out.println("Jogada inválida!");
			}
		}while(opcao != 0);
	}
}
