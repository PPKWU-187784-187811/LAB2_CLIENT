import implementations.Callback;
import implementations.SimpleLibrary;
import interfaces.ICallback;
import interfaces.ILibrary;

import java.util.Scanner;

/**
 * Created by mariusz on 23.10.16.
 */
public class Main {

    public static void main(String[] args) {

        String fileName;
        String successString;
        String failureString;
        ICallback callback = new Callback();
        ILibrary library = new SimpleLibrary();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku:");
        fileName = scanner.nextLine();
        System.out.println("Podaj poprawny:");
        successString = scanner.nextLine();
        System.out.println("Podaj niepoprawny:");
        failureString = scanner.nextLine();

        library.saveToFile(fileName, successString, failureString, callback);
        System.out.println("EXIT");
    }
}
