import java.util.Scanner;

public class UserInput {

    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    private Scanner getScanner() {
        return scanner;
    }

    public String getUserInput() {
        while (true) {
            String input = getScanner().nextLine();
            input = input.toUpperCase();
            if (checkInput(input)) return input;
            System.out.println("Ungültige Eingabe. Bitte geben Sie einen einzelnen Buchstaben ein.");
        }
    }

    private boolean checkInput(String input) {
        if (input.length() == 1) {
            return input.charAt(0) >= 'A' && input.charAt(0) <= 'Z';
        }
        return false;
    }
}
