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

    public static ArrayList<Pintura> listarPinturas() throws Exception{
        ArrayList<Pintura> temp = new ArrayList<>();

        for (ObraDeArte obraDeArte: listarObras()) {
            if (obraDeArte instanceof Pintura) {
                temp.add((Pintura) obraDeArte);
            }
        }
        if (temp.isEmpty()) {
            throw new Exception("Não há pinturas cadastradas!");
        }
        return  temp;
    }

    public static ArrayList<Escultura> listarEsculturas() throws Exception{
        ArrayList<Escultura> temp = new ArrayList<>();

        for (ObraDeArte obraDeArte: listarObras()) {
            if (obraDeArte instanceof Escultura) {
                temp.add((Escultura) obraDeArte);
            }
        }
        if (temp.isEmpty()) {
            throw new Exception("Não há esculturas cadastradas!");
        }
        return  temp;
    }

    public static ArrayList<Fotografia> listarFotografias() throws Exception {
        ArrayList<Fotografia> temp = new ArrayList<>();

        for (ObraDeArte obraDeArte: listarObras()) {
            if (obraDeArte instanceof Fotografia) {
                temp.add((Fotografia) obraDeArte);
            }
        }
        if (temp.isEmpty()) {
            throw new Exception("Não há fotografias cadastradas!");
        }
        return  temp;
    }

    public static ObraDeArte buscarObra(int id) throws Exception{
        for(ObraDeArte obra: listaObras) {
            if (obra.getId() == id) {
                return obra;
            }
        }
        throw new Exception("Obra não encontrada");
    }

    public static ObraDeArte buscarObra(String titulo) throws Exception{
        for (ObraDeArte obraDeArte: listarObras()) {
            if (obraDeArte.getTitulo().equals(titulo)) {
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

    public static void atualizarObra(Pintura pintura, String titulo,
                                     String artista, int anoCriacao, String localizacaoMuseu,
                                     String tipoTinta, String movimentoArtistico) {
        pintura.setTitulo(titulo);
        pintura.setArtista(artista);
        pintura.setAnoCriacao(anoCriacao);
        pintura.setLocalizacaoMuseu(localizacaoMuseu);
        pintura.setTipoTinta(tipoTinta);
        pintura.setMovimentoArtistico(movimentoArtistico);
    }

    public static void atualizarObra(Escultura escultura, String titulo,
                                     String artista, int anoCriacao, String localizacaoMuseu,
                                     String material) {
        escultura.setTitulo(titulo);
        escultura.setArtista(artista);
        escultura.setAnoCriacao(anoCriacao);
        escultura.setLocalizacaoMuseu(localizacaoMuseu);
        escultura.setMaterial(material);
    }

    public static void atualizarObra(Fotografia fotografia, String titulo,
                                     String artista, int anoCriacao, String localizacaoMuseu,
                                     String tecnica) {
        fotografia.setTitulo(titulo);
        fotografia.setArtista(artista);
        fotografia.setAnoCriacao(anoCriacao);
        fotografia.setLocalizacaoMuseu(localizacaoMuseu);
        fotografia.setTecnica(tecnica);
    }

}
