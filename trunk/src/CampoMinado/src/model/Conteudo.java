package model;

public class Conteudo {

    /**
     * Representação de um conteúdo.
     */
    private String icone;
    /**
     * Tipo do conteúdo.
     */
    private TipoConteudo tipoConteudo;

    /**
     * Cria um novo conteúdo com tipo VAZIO.
     */
    public void Conteudo() {
        //fazer o que está descrito no comentário.
        this.Conteudo = TipoConteudo.VAZIO;
    }

    /**
     * Obtém o ícone (representação) do conteúdo.
     *
     * @return Ícone (representação) do conteúdo.
     */
    public String getIcone() {
        return icone;
    }

    /**
     * Define o ícone (representação) do conteúdo.
     *
     * @param minasVizinhas A quantidade de minas presentes na vizinhança do
     * botão. Esse número será utilizado como ícone do conteúdo do quadrado,
     * exceto quando o quadrado contiver uma mina.
     */
    public void setIcone(int minasVizinhas) {
		String.format(this.icone,minasVizinhas);
        //converter o int para string usando o String.format
    }

    /**
     * Obtém o tipo do conteúdo.
     *
     * @return Tipo do conteúdo.
     */
    public TipoConteudo getTipo() {
        return tipoConteudo;
    }

    /**
     * Adiciona uma mina ao conteúdo, mudando assim, seu tipo e seu ícone.
     */
    public void adicionarMina() {
		this.tipoConteudo = TipoConteudo.MINA;
		String.format(this.icone,"M");
        //mudar o tipo do conteúdo
        //mudar o ícone para "M"
    }
}
