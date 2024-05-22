package views;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    private static Scanner reader = new Scanner(System.in);

    public static int readInt(String msg) {
        int n = 0;

        while (true) {
            try {
                System.out.print(msg + ": ");
                n = reader.nextInt();
                break;
            } catch (InputMismatchException mismatchException) {
                System.out.println("Valor inválido. Digite um inteiro!");
            } finally {
                reader.nextLine();
            }
        }
        return n;
    }

    public static float readFloat(String msg) {
        float n = 0;

        while (true) {
            try {
                System.out.print(msg + ": ");
                n = reader.nextFloat();
                reader.nextLine();
                break;
            } catch (InputMismatchException mismatchException) {
                reader.nextLine();
                System.out.println("Valor inválido. Digite um float!");
            }
        }
        return n;
    }

    public static String readString(String msg) {
        System.out.print(msg + ": ");
        return reader.nextLine();
    }

}
