package controllers;

import models.ObraDeArte;

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
}
