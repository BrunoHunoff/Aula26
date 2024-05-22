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

    public static ObraDeArte fromString(String linha) throws Exception{
        String[] linhaTemp = linha.split(":");
        String[] linhaFinal = linhaTemp[1].split(", ");
        if (linhaTemp[0] == "Pintura:") {
            return new Pintura(
                    Integer.parseInt(linhaFinal[0]),
                    linhaFinal[1], linhaFinal[2], Integer.parseInt(linhaFinal[3]), linhaFinal[4],
                    linhaFinal[5], linhaFinal[6]);
        }
        if (linhaTemp[0] == "Escultura:") {
            return new Escultura(
                    Integer.parseInt(linhaFinal[0]),
                    linhaFinal[1], linhaFinal[2],
                    Integer.parseInt(linhaFinal[3]),
                    linhaFinal[4], linhaFinal[5]);
        }

        if (linhaTemp[0] == "Fotografia:") {
            return new Fotografia(
                    Integer.parseInt(linhaFinal[0]),
                    linhaFinal[1], linhaFinal[2],
                    Integer.parseInt(linhaFinal[3]),
                    linhaFinal[4], linhaFinal[5]);
        }
        throw new Exception("Impossível instanciar objeto!");
    }

    @Override
    public String toString() {
        return titulo + ", " + artista + ", " + anoCriacao + ", " + localizacaoMuseu;
    }
}
