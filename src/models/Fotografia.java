package models;

public class Fotografia extends ObraDeArte{

    private String tecnica;

    public Fotografia(int id, String titulo, String artista, int anoCriacao, String localizacaoMuseu, String tecnica) {
        super(id, titulo, artista, anoCriacao, localizacaoMuseu);
        this.tecnica = tecnica;
    }

    public Fotografia() {}

    public String getTecnica() {
        return tecnica;
    }

    public Fotografia setTecnica(String tecnica) {
        this.tecnica = tecnica;
        return this;
    }

    @Override
    public String toString() {
        return "Fotografia: " + super.toString() + ", " + tecnica;
    }
}
