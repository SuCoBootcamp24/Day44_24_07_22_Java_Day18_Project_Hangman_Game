# Hangman Game

Welcome to the Hangman Game project! This project is a console-based implementation of the classic Hangman game in Java.

## Description

Hangman is a popular word guessing game. The player has to guess the correct word by suggesting letters within a certain number of guesses. The game will indicate if the guessed letter is correct or not, and display a hangman graphic representing the number of incorrect guesses.

## Features

- Random word selection from a predefined list.
- Case-insensitive letter guessing.
- Display of the current state of the word with underscores for unguessed letters.
- Visual representation of the hangman that updates with each incorrect guess.
- Game ends after a maximum of 6 incorrect guesses.

## Getting Started

### Prerequisites

To run this project, you need to have the following installed on your system:

- Java Development Kit (JDK) 22 or higher

### Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/your-username/hangman-game.git
    ```

2. Navigate to the project directory:

    ```bash
    cd hangman-game
    ```

### Running the Game

To compile and run the game, follow these steps:

1. Compile the Java files:

    ```bash
    javac GameLogic.java HangmanPrinter.java Game.java UserInput.java Hangman.java
    ```

2. Run the Hangman game:

    ```bash
    java Hangman
    ```

### Project Structure

- `Hangman.java`: The main class that initiates the game.
- `Game.java`: Manages the overall game flow.
- `GameLogic.java`: Contains the core logic for the game, including word selection and state updates.
- `UserInput.java`: Handles user input and validation.
- `HangmanPrinter.java`: Prints the hangman graphic to the console.

### Example Gameplay

```plaintext
Game ID: 0
_ _ _ _ 
Geratene Buchstaben: []
Gib einen Buchstaben ein:
e
_ _ E _ 
Geratene Buchstaben: [E]
Gib einen Buchstaben ein:
x
Falsch! Versuchen Sie es erneut.
Falsche Versuche: 1 von 6


       O
       |




_ _ E _ 
Geratene Buchstaben: [E, X]
Gib einen Buchstaben ein:

