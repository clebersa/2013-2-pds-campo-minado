package model;

public class Marcacao {

    private String icone;
    private TipoMarcacao tipoMarcacao;

    /**
     * Cria uma nova marcação com tipo NENHUMA.
     */
    public void Marcacao() {
        icone = String.format("%d", " ");
        this.tipoMarcacao = TipoMarcacao.NENHUMA;
    }

    /**
     * Obtém o ícone (representação) da marcação.
     *
     * @return Ícone (representação) da marcação.
     */
    public String getIcone() {
        return this.icone;
    }

    /**
     * Define o ícone (representação) da marcação e o tipo da marcação.
     */
    public void marcar() {
        if (icone == " ") {
            icone = "B";
            tipoMarcacao = TipoMarcacao.BANDEIRA;
        } else if (icone == "B") {
            icone = "?";
            tipoMarcacao = TipoMarcacao.DUVIDA;
        } else {
            icone = " ";
            tipoMarcacao = TipoMarcacao.DUVIDA;
        }
    }
}
