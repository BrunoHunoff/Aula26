import controllers.ObraDeArteController;

public class Main {
    public static void main(String[] args) {
        try{
            ObraDeArteController.buscarObraId(1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}