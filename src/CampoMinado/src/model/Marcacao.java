package model;

public class Marcacao {

    private String icone;
    private TipoMarcacao tipoMarcacao;

    /**
     * Cria uma nova marcação com tipo NENHUMA.
     */
    public void Marcacao() {
		String.format(this.icone,"");
		this.tipoMarcacao = TipoMarcacao.NENHUMA;
    }

    public String getIcone() {
        return this.icone;
    }

    public void marcar() {
		if(this.icone = ""){
			String.format(this.icone,"?");
			this.tipoMarcacao = TipoMarcacao.DUVIDA;
		else{
			String.format(this.icone,"B");
			this.tipoMarcacao = TipoMarcacao.BANDEIRA;
		}
    }
}
