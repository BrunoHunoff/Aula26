package Repository;

import controllers.ObraDeArteController;
import models.ObraDeArte;

import java.io.*;

public abstract class ObraDeArteRepository {
    private static final String FILE = "obras.txt";

    public static void salvarObras() throws Exception {
        try (FileWriter fileWriter = new FileWriter(FILE);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (ObraDeArte obraDeArte : ObraDeArteController.listarObras()) {
                bufferedWriter.write(obraDeArte + "\n");
            }
        }
    }

    public static void carregarObras() throws Exception {

        try (FileReader fileReader = new FileReader(FILE);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                ObraDeArteController.adicionarObra(ObraDeArte.fromString(linha));
            }
        }
    }
}
