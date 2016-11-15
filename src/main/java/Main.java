import implementations.Callback;
import implementations.SimpleLibrary;
import interfaces.ICallback;
import interfaces.IExitCallback;
import interfaces.ILibrary;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by mariusz on 23.10.16.
 */
public class Main {

    public static void main(String[] args) {
        IExitCallback exitCallback = (question) -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println(question);
            return "T".equalsIgnoreCase(scanner.nextLine());
        };

        start(exitCallback);
    }

    private static void start(IExitCallback exitCallback) {
        try {
            init(exitCallback);
        } catch (NoSuchElementException ignored) {
        } finally {
            if (!exitCallback.getResult("Czy chcesz wyjsc z programu?")) {
                start(exitCallback);
            }
        }
    }

    private static void init(IExitCallback exitCallback) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        String successString;
        String failureString;
        ICallback callback = new Callback();
        ILibrary library = new SimpleLibrary();
        System.out.println("Podaj nazwe pliku:");
        fileName = readConsole(scanner);
        System.out.println("Podaj poprawny:");
        successString = readConsole(scanner);
        System.out.println("Podaj niepoprawny:");
        failureString = readConsole(scanner);
        if (fileName != null && successString != null && failureString != null) {
            library.saveToFile(fileName, successString, failureString, callback, exitCallback);
        }
    }

    private static String readConsole(Scanner scanner) {
        String text = scanner.nextLine();
        if (text.equalsIgnoreCase("Q")) {
            return null;
        }
        return text;
    }
}
