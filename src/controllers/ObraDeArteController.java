package controllers;

import models.ObraDeArte;

import java.util.ArrayList;

public abstract class ObraDeArteController {
    private static ArrayList<ObraDeArte> listaObras = new ArrayList<>();

    public static void adicionarObra(ObraDeArte obra) {
        listaObras.add(obra);
    }

    public static ObraDeArte buscarObra(int id) throws Exception{
        for(ObraDeArte obra: listaObras) {
            if (obra.getId() == id) {
                return obra;
            }
        }
        throw new Exception("Obra não encontrada");
    }
}
