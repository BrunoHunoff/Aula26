import controllers.ObraDeArteController;
import models.ObraDeArte;
import models.Pintura;

public class Main {
    public static void main(String[] args) {
        try{
            ObraDeArteController.buscarObra(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}