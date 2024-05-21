package models;

public class Pintura extends ObraDeArte{

    private String tipoTinta;
    private String movimentoArtistico;

    public Pintura() {}

    public Pintura(int id, String titulo, String artista, int anoCriacao, String localizacaoMuseu, String tipoTinta, String movimentoArtistico) {
        super(id, titulo, artista, anoCriacao, localizacaoMuseu);
        this.tipoTinta = tipoTinta;
        this.movimentoArtistico = movimentoArtistico;
    }

    public String getTipoTinta() {
        return tipoTinta;
    }

    public Pintura setTipoTinta(String tipoTinta) {
        this.tipoTinta = tipoTinta;
        return this;
    }

    public String getMovimentoArtistico() {
        return movimentoArtistico;
    }

    public Pintura setMovimentoArtistico(String movimentoArtistico) {
        this.movimentoArtistico = movimentoArtistico;
        return this;
    }

    @Override
    public String toString() {
        return "Pintura: " + super.toString() + ", " + tipoTinta + ", " + movimentoArtistico;
    }
}
