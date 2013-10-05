package model;

public interface DistribuidorMinas extends DistribuidorMinasInterface {

    private Tabuleiro tabuleiro;

    public abstract void distribuirMinas(Tabuleiro tabuleiro);
}
