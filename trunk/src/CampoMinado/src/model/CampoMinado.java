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
     */
    public static void main(String args[]) {
        Scanner leitor = new Scanner(System.in);
        int tipoJogada, linha, coluna;
        iniciarNovoJogo();
        tabuleiro.exibir();

        while (true) {
            System.out.println("Jogadas: 1 - Marcar | 2 - Abrir");
            tipoJogada = leitor.nextInt();

            if (tipoJogada == 1) {
                System.out.print("Quadrado: ");
                int temp = leitor.nextInt();
                linha = temp / 10;
                coluna = temp % 10;

                if (linha <= tabuleiro.getLinhas() || coluna <= tabuleiro.getColunas()) {
                    linha--;
                    coluna--;

                    Jogada novaJogada = new Jogada(linha, coluna, TipoJogada.MARCAR);
                    jogadas.add(novaJogada);

                    tabuleiro.executarJogada(novaJogada);

                } else {
                    System.out.println("Quadrado inválido!");
                }
                
                tabuleiro.exibir();

            } else if (tipoJogada == 2) {
                System.out.print("Quadrado: ");
                int temp = leitor.nextInt();
                linha = temp / 10;
                coluna = temp % 10;

                if (linha <= tabuleiro.getLinhas() || coluna <= tabuleiro.getColunas()) {
                    linha--;
                    coluna--;

                    Jogada novaJogada = new Jogada(linha, coluna, TipoJogada.ABRIR);
                    jogadas.add(novaJogada);

                    tabuleiro.executarJogada(novaJogada);

                } else {
                    System.out.println("Quadrado inválido!");
                }
                tabuleiro.exibir();
            } else {
                System.out.println("Tipo de jogada inválida!");
            }
        }

        //fluxo principal do jogo.
    }

    /**
     * Inicia um novo jogo.
     */
    public static void iniciarNovoJogo() {
        Scanner leitor = new Scanner(System.in);
        /*
         * Solicita ao usuário qual o tipo de tabuleiro que ele deseja. Em
         * seguida, cria um tabuleiro de acordo com a escolha do usuário e então
         * retorna este novo tabuleiro para o fluxo principal do programa.
         */
        jogadas = new ArrayList<>();
        System.out.println("Tabuleiro: 1 - Iniciante | 2 - Intermediário | 3 - Avançado");
        while (true) {
            System.out.print("Tipo: ");
            int tipo = leitor.nextInt();
            if (tipo == 1) {
                tabuleiro = new Tabuleiro(TipoTabuleiro.INICIANTE);
                break;
            } else if (tipo == 2) {
                tabuleiro = new Tabuleiro(TipoTabuleiro.INTERMEDIARIO);
                break;
            } else if (tipo == 3) {
                tabuleiro = new Tabuleiro(TipoTabuleiro.AVANCADO);
                break;
            } else {
                System.out.println("Tabuleiro inválido!");
            }
        }

    }

    /**
     * Lê uma jogada do usuário e executa a mesma.
     *
     * @return O resultado da jogada.
     */
    private boolean jogar() {
        return false;
    }
}
