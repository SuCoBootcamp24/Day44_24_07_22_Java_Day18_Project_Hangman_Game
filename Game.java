import java.util.Scanner;

public class Game {

    public static long lastID = 0;

    private final long ID;
    private final GameLogic gameLogic;
    private final UserInput userInput;
    private boolean gameEnd = false;

    public Game() {
        this.ID = lastID++;
        this.gameLogic = new GameLogic();
        this.userInput = new UserInput();
        startGame(this);
    }

    public long getID() {
        return ID;
    }

    private GameLogic getGameLogic() {
        return gameLogic;
    }

    private UserInput getUserInput() {
        return userInput;
    }

    public static void startGame(Game game) {
        GameLogic logic = game.getGameLogic();
        UserInput userInput = game.getUserInput();
        System.out.println("Game ID: " + game.getID());
        System.out.println(logic.getCurrentlySolved());

        while (!game.getGameLogic().isSolved()) {
            System.out.println("Gib einen Buchstaben ein:");
            logic.updateSolved(userInput.getUserInput());
            System.out.println(logic.getCurrentlySolved());
            if (logic.getWrongGuesses() >= GameLogic.MAX_WRONG_GUESSES) {
                break;
            }
        }

        if (logic.isSolved() && logic.getWrongGuesses() < GameLogic.MAX_WRONG_GUESSES) {
            System.out.println("Herzlichen Glückwunsch! Sie haben das richtige Wort erraten: " + game.getGameLogic().getCorrectWord());
        } else {
            System.out.println("Game Ende! Richtige Wort: " + game.getGameLogic().getCorrectWord());
        }
    }
}
