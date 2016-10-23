import java.util.Scanner;

/**
 * Created by mariusz on 23.10.16.
 */
public class Main {

    public static void main(String[] args) {

        String fileName;
        String successString;
        String failureString;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku:");
        fileName = scanner.nextLine();
        System.out.println("Podaj poprawny:");
        successString = scanner.nextLine();
        System.out.println("Podaj niepoprawny:");
        failureString = scanner.nextLine();
    }
}
