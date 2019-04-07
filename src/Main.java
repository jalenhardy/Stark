import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String code;
        System.out.println("\t\t\t\t\t\tStark v 0.0.1");
        System.out.println("//////////Current only operations with integers in the format of x + y work\\\\\\\\\\\\\\\\\\\\");
        while(true){
            System.out.print(">>>");
            code = scan.nextLine();
            Lexer Lex = new Lexer(code,1);
            Parser parse = new Parser(Lex.getTokens());
            Interpreter.run(parse.getTree());
        }
    }
}
