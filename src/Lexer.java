import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lexer {
    private Scanner scanner;

    // To be updated
    public Lexer(String filepath){
        File file = new File(filepath);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("File: %s not found", filepath);
        }

        run();
    }

    private void run(){
        String word;
        while (scanner.hasNext()){
            word = scanner.next();

            // Integer
            if (word.matches("^[0-9]*$")){
                Token token = new Token(TokenType.INTEGER, word);
                System.out.printf("Found integer: %s\n", token.getValue());
            }
        }
    }
}
