import controllers.ObraDeArteController;
import models.ObraDeArte;
import models.Pintura;

public class Main {
    public static void main(String[] args) {
        ObraDeArte p1 = new Pintura();

        try{
            ObraDeArteController.adicionarObra(p1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}