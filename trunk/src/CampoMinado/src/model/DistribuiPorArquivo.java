package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Define a implementação da distribuição de minas baseada em arquivo.
 *
 * @author Cleber, Samuel
 */
public class DistribuiPorArquivo implements DistribuidorMinas {

	/**
	 * Indica o caminho, absoluto ou relativo, do arquivo que contém a
	 * distribuição das minas.
	 */
	private String caminhoArquivo = ".";
	/**
	 * Indica o nome do arquivo que contém a distribuição das minas.
	 */
	private String nomeArquivo = "distribuicaoMinas.txt";

	/**
	 * Distribui as minas sobre o tabuleiro a partir da leitura de um arquivo. A
	 * primeira linha do arquivo contém a quantidade
	 * <code>n</code> de minas que serão distribuídas no tabuleiro. As
	 * <code>n</code> linhas seguintes contém as posições (linha e coluna) de
	 * cada uma das
	 * <code>n</code> minas do tabuleiro.
	 *
	 * @see model.DistribuidorMinas#distribuirMinas(model.Tabuleiro)
	 */
	@Override
	public void distribuirMinas(Tabuleiro tabuleiro) {
		int linha, coluna;
		String dadosArquivos;

		try {
			File file;
			if (tabuleiro.getTipoTabuleiro() == 0) {
				file = new File("iniciante");
			} else if (tabuleiro.getTipoTabuleiro() == 1) {
				file = new File("intermediario");
			} else {
				file = new File("avancado");
			}

			FileReader fileReader = null;
			fileReader = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileReader);

			try {
				while ((dadosArquivos = reader.readLine()) != null) {
					linha = Integer.parseInt(dadosArquivos) / 10;
					coluna = Integer.parseInt(dadosArquivos) % 10;
					tabuleiro.adicionarMina(linha, coluna);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}

		//Implementar distribuição das minas pora arquivo.
	}
}
