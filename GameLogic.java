public class GameLogic {
    private static final String[] WORD_LIST = {
            "Apfelbaum", "Schulbuch", "Wohnzimmer", "Autobahn", "Buerostuhl",
            "Kuechentisch", "Zahnarzttermin", "Apfel", "Haus", "Baum",
            "Hund", "Katze", "Buch", "Auto", "Straße",
            "Tisch", "Stuhl", "Fenster", "Tuer", "Lampe",
            "Brot", "Milch", "Wasser", "Schule", "Lehrer",
            "Kind", "Spiel", "Enzyklopaedie", "Xylophon"
    };

    public static final int MAX_WRONG_GUESSES = 6;

    private final String correctWord;
    private String currentlySolved;
    private boolean solved = false;
    private int wrongGuesses = 0;

    public GameLogic() {
        this.correctWord = randomWord().toUpperCase();
        setCurrentlySolved(hidingWord(correctWord));
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public String getCurrentlySolved() {
        return currentlySolved;
    }

    private void setCurrentlySolved(String currentlySolved) {
        this.currentlySolved = currentlySolved;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    private static String randomWord() {
        return WORD_LIST[(int) (Math.random() * WORD_LIST.length)];
    }

    private static String hidingWord(String correctWord) {
        return "_ ".repeat(correctWord.length());
    }

    private boolean checkUserChoice(String input) {
        return getCorrectWord().contains(input) && !getCurrentlySolved().contains(input);
    }

    public void updateSolved(String input) {
        if (!checkUserChoice(input)) {
            wrongGuesses++;
            System.out.println("Falsch! Versuchen Sie es erneut.");
            System.out.println("Falsche Versuche: " + wrongGuesses + " von " + MAX_WRONG_GUESSES);
            HangmanPrinter.printHangman(wrongGuesses);
            if (wrongGuesses >= MAX_WRONG_GUESSES) {
                System.out.println("Maximale Anzahl falscher Versuche erreicht! Spiel vorbei.");
                setSolved(true);
            }
            return;
        }

        String correctWord = getCorrectWord();
        String currentlySolved = getCurrentlySolved();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < correctWord.length(); i++) {
            if (correctWord.charAt(i) == input.charAt(0)) {
                result.append(input).append(" ");
            } else {
                result.append(currentlySolved.charAt(i * 2)).append(" ");
            }
        }

        setCurrentlySolved(result.toString());

        if (!result.toString().contains("_")) {
            setSolved(true);
        }
    }
}
