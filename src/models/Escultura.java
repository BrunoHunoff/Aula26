package models;

public class Escultura extends ObraDeArte{

    private String material;

    public Escultura() {}

    public Escultura(String titulo, String artista, int anoCriacao, String localizacaoMuseu, String material) {
        super(titulo, artista, anoCriacao, localizacaoMuseu);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public Escultura setMaterial(String material) {
        this.material = material;
        return this;
    }

    @Override
    public String toString() {
        return "Escultura: " + super.toString() + ", " + material;
    }
}
