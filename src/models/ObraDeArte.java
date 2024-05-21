package models;

public abstract class ObraDeArte {
    private int id;
    private String titulo;
    private String artista;
    private int anoCriacao;
    private String localizacaoMuseu;

    public ObraDeArte() {}

    public ObraDeArte(int id,String titulo, String artista, int anoCriacao, String localizacaoMuseu) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.anoCriacao = anoCriacao;
        this.localizacaoMuseu = localizacaoMuseu;
    }

    public int getId() {
        return id;
    }

    public ObraDeArte setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public ObraDeArte setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getArtista() {
        return artista;
    }

    public ObraDeArte setArtista(String artista) {
        this.artista = artista;
        return this;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public ObraDeArte setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
        return this;
    }

    public String getLocalizacaoMuseu() {
        return localizacaoMuseu;
    }

    public ObraDeArte setLocalizacaoMuseu(String localizacaoMuseu) {
        this.localizacaoMuseu = localizacaoMuseu;
        return this;
    }



    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoCriacao + ", " + localizacaoMuseu;
    }
}
