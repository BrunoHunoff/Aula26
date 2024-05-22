package views;

import Repository.ObraDeArteRepository;
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

            case 8:
                listarObras();
                break;

            case 9:
                salvar();
                break;

            case 0:
                sair();
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void executar() {
        int op;

        try {
            ObraDeArteRepository.carregarObras();
        } catch (Exception e) {}

        do {
            menu();
            op = Console.readInt("Opção");
            gerenciarOp(op);
        } while (op != 0);
    }

    private static void adicionarObra() {

        titulo = Console.readString("Título");
        artista = Console.readString("Artista");
        anoCriacao = Console.readInt("Ano de criação");
        localizacao = Console.readString("Localização no museu");
    }

    private static String[] cadastrarPintura() {
        System.out.println("\nPintura:");
        adicionarObra();
        String tipoTinta = Console.readString("Tipo de tinta");
        String movimentoArtistico = Console.readString("Movimento artístico");
        String[] temp = {tipoTinta, movimentoArtistico};
        return temp;
    }

    private static void gerarId() {
        try {
            for (ObraDeArte obraDeArte : ObraDeArteController.listarObras()) {
                id = obraDeArte.getId();
            }
            id += 1;
        } catch (Exception e) {
            id = 1;
        }
    }

    private static void adicionarPintura() {
        gerarId();
        String[] temp = cadastrarPintura();
        ObraDeArteController.adicionarObra(new Pintura(id, titulo, artista, anoCriacao, localizacao, temp[0], temp[1]));
        System.out.println("Obra cadastrada com sucesso!");
    }

    private static void adicionarEscultura() {
        gerarId();
        System.out.println("\nEscultura:");
        adicionarObra();
        String material = Console.readString("Material");

        ObraDeArteController.adicionarObra(new Escultura(id, titulo, artista, anoCriacao, localizacao, material));
    }

    private static void adicionarFotografia() {
        gerarId();
        System.out.println("\nFotografia:");
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

    private static void atualizarPintura(Pintura obraDeArte) {
        String[] tempCadastro = cadastrarPintura();

        obraDeArte.setId(id);
        obraDeArte.setTitulo(titulo);
        obraDeArte.setArtista(artista);
        obraDeArte.setAnoCriacao(anoCriacao);
        obraDeArte.setLocalizacaoMuseu(localizacao);
        obraDeArte.setTipoTinta(tempCadastro[0]);
        obraDeArte.setMovimentoArtistico(tempCadastro[1]);
    }

    private static void atualizarEscultura(Escultura obraDeArte) {
        System.out.println("\nEscultura:");
        adicionarObra();
        String material = Console.readString("Material");

        obraDeArte.setId(id);
        obraDeArte.setTitulo(titulo);
        obraDeArte.setArtista(artista);
        obraDeArte.setAnoCriacao(anoCriacao);
        obraDeArte.setLocalizacaoMuseu(localizacao);
        obraDeArte.setMaterial(material);
    }

    private static void atualizarFotografia(Fotografia obraDeArte) {
        System.out.println("\nFotografia:");
        adicionarObra();
        String tecnica = Console.readString("Tecnica");
        obraDeArte.setId(id);
        obraDeArte.setTitulo(titulo);
        obraDeArte.setArtista(artista);
        obraDeArte.setAnoCriacao(anoCriacao);
        obraDeArte.setLocalizacaoMuseu(localizacao);
        obraDeArte.setTecnica(tecnica);
    }

    private static void atualizarObra() {
        System.out.println("\nAtualizar Obra:");
        id = Console.readInt("ID");

        try {
            ObraDeArte temp = ObraDeArteController.buscarObra(id);

            if (temp instanceof Pintura) {
                atualizarPintura((Pintura)temp);
                System.out.println("\nRegistro da Pintura atualizado com sucesso!");
            } else if (temp instanceof Escultura) {
                atualizarEscultura((Escultura)temp);
                System.out.println("\nRegistro da Escultura atualizado com sucesso");
            } else if (temp instanceof Fotografia) {
                atualizarFotografia((Fotografia)temp);
                System.out.println("\nRegistro da Fotografia atualizado com sucesso");
            } else {
                throw new Exception("Não foi possível atualizar o registro");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }


    }

    private static void listarObras() {
        System.out.println("\nObras de arte:");
        try {
            for (ObraDeArte obraDeArte : ObraDeArteController.listarObras()) {
                System.out.println(obraDeArte);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void salvar() {
        try {
            ObraDeArteRepository.salvarObras();
            System.out.println("\nAlterações salvas com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void sair() {
        System.out.println("\nSair");
        System.out.println("Deseja salvar as alterações?(s/n)");

        while (true){

            String op = Console.readString("Opção");
            if (op.equals("s") || op.equals("S")) {
                salvar();
                System.out.println("Sistema encerrado!");
                break;
            } else if (op.equals("n") || op.equals("N")) {
                System.out.println("Sistema encerrado!");
                break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
