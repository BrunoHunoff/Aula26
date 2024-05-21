package controllers;

import models.Escultura;
import models.Fotografia;
import models.ObraDeArte;
import models.Pintura;

import java.util.ArrayList;

public abstract class ObraDeArteController {
    private static ArrayList<ObraDeArte> listaObras = new ArrayList<>();

    public static void adicionarObra(ObraDeArte obra) {
        listaObras.add(obra);
    }

    public static ArrayList<ObraDeArte> listarObras() throws Exception{
        if (listaObras.isEmpty()) {
            throw new Exception("Não há obras cadastradas!");
        }
        return listaObras;
    }

    public static ObraDeArte buscarObraId(int id) throws Exception{
        for(ObraDeArte obra: listaObras) {
            if (obra.getId() == id) {
                return obra;
            }
        }
        throw new Exception("Obra não encontrada");
    }

    public static ObraDeArte buscarObraTitulo(String titulo) throws Exception{
        for (ObraDeArte obraDeArte: listarObras()) {
            if (obraDeArte.getTitulo() == titulo) {
                return obraDeArte;
            }
        }
        throw new Exception("Obra não encontrada!");
    }

    public static void excluirObra(int id) throws Exception{
        for (ObraDeArte obraDeArte : listaObras) {
            if (obraDeArte.getId() == id) {
                listaObras.remove(obraDeArte);
                return;
            }
        }
        throw new Exception("Obra não encontrada!");
    }

    public static void atualizarObra(Pintura pintura, int id, String titulo,
                                     String artista, int anoCriacao, String localizacaoMuseu,
                                     String tipoTinta, String movimentoArtistico) {
        pintura.setId(id);
        pintura.setTitulo(titulo);
        pintura.setArtista(artista);
        pintura.setAnoCriacao(anoCriacao);
        pintura.setLocalizacaoMuseu(localizacaoMuseu);
        pintura.setTipoTinta(tipoTinta);
        pintura.setMovimentoArtistico(movimentoArtistico);
    }

    public static void atualizarObra(Escultura escultura, int id, String titulo,
                                     String artista, int anoCriacao, String localizacaoMuseu,
                                     String material) {
        escultura.setId(id);
        escultura.setTitulo(titulo);
        escultura.setArtista(artista);
        escultura.setAnoCriacao(anoCriacao);
        escultura.setLocalizacaoMuseu(localizacaoMuseu);
        escultura.setMaterial(material);
    }

    public static void atualizarObra(Fotografia fotografia, int id, String titulo,
                                     String artista, int anoCriacao, String localizacaoMuseu,
                                     String tecnica) {
        fotografia.setId(id);
        fotografia.setTitulo(titulo);
        fotografia.setArtista(artista);
        fotografia.setAnoCriacao(anoCriacao);
        fotografia.setLocalizacaoMuseu(localizacaoMuseu);
        fotografia.setTecnica(tecnica);
    }
}
