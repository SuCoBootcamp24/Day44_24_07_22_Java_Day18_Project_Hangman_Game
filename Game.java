import java.util.ArrayList;

public class Game {

    public static long lastID = 0;

    private final long ID;
    private final GameLogic GAME_LOGIC;
    private final UserInput USER_INPUTS;

    private final ArrayList<String> MISSING_CHARS;
    private boolean gameEnd = false;

    public Game() {
        this.ID = lastID++;
        this.GAME_LOGIC = new GameLogic();
        this.USER_INPUTS = new UserInput();
        this.MISSING_CHARS = new ArrayList<>();
        startGame(this);
    }

    public long getID() {
        return ID;
    }

    private GameLogic getGAME_LOGIC() {
        return GAME_LOGIC;
    }

    private UserInput getUSER_INPUTS() {
        return USER_INPUTS;
    }

    public ArrayList<String> getMISSING_CHARS() {
        return MISSING_CHARS;
    }

    public void addMissingChar(String charToAdd) {
       if(!getMISSING_CHARS().contains(charToAdd)) getMISSING_CHARS().add(charToAdd);
    }


    //-----

    public static void startGame(Game game) {
        GameLogic logic = game.getGAME_LOGIC();
        UserInput userInput = game.getUSER_INPUTS();
        System.out.println("Game ID: " + game.getID());
        System.out.println(logic.getCurrentlySolved());

        while (!game.getGAME_LOGIC().isSolved()) {
            System.out.println("Geratene Buchstaben: " + game.getMISSING_CHARS().toString());
            System.out.println("Gib einen Buchstaben ein:");
            String input = userInput.getUserInput();
            game.addMissingChar(input);
            logic.updateSolved(input);
            System.out.println(logic.getCurrentlySolved());
            if (logic.getWrongGuesses() >= GameLogic.MAX_WRONG_GUESSES) {
                break;
            }
        }

        if (logic.isSolved() && logic.getWrongGuesses() < GameLogic.MAX_WRONG_GUESSES) {
            System.out.println("Herzlichen Glückwunsch! Sie haben das richtige Wort erraten: " + game.getGAME_LOGIC().getCorrectWord());
        } else {
            System.out.println("Game Ende! Richtige Wort: " + game.getGAME_LOGIC().getCorrectWord());
        }
    }
}
