import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lexer {
    private Scanner scanner;
    private List<Token> tokens;

    // To be updated
    public Lexer(String filepath){
        File file = new File(filepath);
        tokens = new ArrayList<>();

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
                tokens.add(new Token(TokenType.INTEGER, word));
            }
            // Float
            else if (word.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))")){
                tokens.add(new Token(TokenType.FLOAT, word));
            }
            // If word is an Operation
            else{
                switch (word){
                    case "+":{
                        tokens.add(new Token(TokenType.OPERATION, "ADDITION"));
                        break;
                    }
                    case "-":{
                        tokens.add(new Token(TokenType.OPERATION, "SUBTRACTION"));
                        break;
                    }
                    case "*":{
                        tokens.add(new Token(TokenType.OPERATION, "*MULTIPLICATION"));
                        break;
                    }
                    case "/":{
                        tokens.add(new Token(TokenType.OPERATION, "DIVISION"));
                        break;
                    }
                    case "%":{
                        tokens.add(new Token(TokenType.OPERATION, "MODULUS"));
                        break;
                    }
                    default:
                        System.out.println("Invalid");

                }
            }
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
