public class HangmanPrinter {
    public static void printHangman(int wrongGuesses) {
        String[] hangmanStages = {
                """
                    
                    
                   O
               
               
               
                 
            """,
                """
                       
                    
                   O
                   |
               
               
                 
            """,
                """
                    
                    
                   O
                  /|\\
               
               
                 
            """,
                """
                    
                    
                   O
                  /|\\
                  /
               
                 
            """,
                """
                    
                    
                   O
                  /|\\
                  / \\
               
                 
            """,
                """
                    
                   |
                   O
                  /|\\
                  / \\
               
                 
            """,
                """
              ------
              |    |
              |    O
              |   /|\\
              |   / \\
              |
            -----
            """
        };

        System.out.println(hangmanStages[wrongGuesses]);
    }
}
