package views;

import controllers.ObraDeArteController;
import models.Escultura;
import models.Fotografia;
import models.ObraDeArte;
import models.Pintura;

public class Sistema {

    private static int id;
    private static String titulo;
    private static String artista;
    private static int anoCriacao;
    private static String localizacao;

    private static void menu() {
        System.out.println("\nMenu: ");
        System.out.println("1 - Adicionar Pintura");
        System.out.println("2 - Adicionar Escultura");
        System.out.println("3 - Adicionar Fotografia");
        System.out.println("4 - Buscar obra - ID");
        System.out.println("5 - Buscar obra - Título");
        System.out.println("6 - Remover obra");
        System.out.println("7 - Atualizar obra");
        System.out.println("8 - Listar obras");
        System.out.println("9 - Salvar alterações");
        System.out.println("0 - Sair");

    }

    private static void gerenciarOp(int op) {
        switch (op) {
            case 1:
                adicionarPintura();
                break;

            case 2:
                adicionarEscultura();
                break;

            case 3:
                adicionarFotografia();
                break;

            case 4:
                buscarObraId();
                break;

            case 5:
                buscarObraTitulo();
                break;

            case 6:
                removerObra();
                break;

            case 7:
                atualizarObra();
                break;

            case 0:
                sair();
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private static void adicionarObra() {
        id = Console.readInt("Id");
        titulo = Console.readString("Título");
        artista = Console.readString("Artista");
        anoCriacao = Console.readInt("Ano de criação");
        localizacao = Console.readString("Localização no museu");
    }

    private static String[] cadastrarPintura() {
        System.out.println("\nAdicionar pintura:");
        adicionarObra();
        String tipoTinta = Console.readString("Tipo de tinta");
        String movimentoArtistico = Console.readString("Movimento artístico");
        String[] temp = {tipoTinta, movimentoArtistico};
        return temp;
    }

    private static void adicionarPintura() {
        cadastrarPintura();
        String[] temp = cadastrarPintura();
        ObraDeArteController.adicionarObra(new Pintura(id, titulo, artista, anoCriacao, localizacao, temp[0], temp[1]));
        System.out.println("Obra cadastrada com sucesso!");
    }

    private static void adicionarEscultura() {
        System.out.println("\nAdicionar pintura:");
        adicionarObra();
        String material = Console.readString("Material");

        ObraDeArteController.adicionarObra(new Escultura(id, titulo, artista, anoCriacao, localizacao, material));
    }

    private static void adicionarFotografia() {
        System.out.println("\nAdicionar fotografia:");
        adicionarObra();
        String tecnica = Console.readString("Tecnica");

        ObraDeArteController.adicionarObra(new Fotografia(id, titulo, artista, anoCriacao, localizacao, tecnica));
    }

    private static void buscarObraId() {
        System.out.println("\nBuscar Obra (ID): ");
        id = Console.readInt("ID");
        try {
            System.out.println(ObraDeArteController.buscarObra(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void buscarObraTitulo() {
        System.out.println("\nBuscar Obra (Título):");
        titulo = Console.readString("Título");

        try {
            System.out.println(ObraDeArteController.buscarObra(titulo));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removerObra() {
        System.out.println("\nRemover Obra:");
        id = Console.readInt("ID");
        try {
            ObraDeArteController.excluirObra(id);
            System.out.println("\nObra deletada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void atualizarObra() {
        System.out.println("\nAtualizar Obra:");
        id = Console.readInt("ID");

        try {
            ObraDeArte temp = ObraDeArteController.buscarObra(id);

            if ()

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


    }
}
