import java.util.List;
import java.util.ArrayList;
//Naming Choices are confusing

public class Parser{
    private List<Token> tokens;
    private List<Node> tree;
    Parser(List<Token> Tokens){
        tokens = new ArrayList<>();
        this.tokens = Tokens;
        tree = new ArrayList<>();
    }
    private void run(){
        for(int i = 0; i < tokens.size(); i++){
            if((tokens.get(i).getType == TokenType.INTEGER || tokens.get(i).getType == TokenType.FLOAT) && tokens.get(i+1).getType == TokenType.OPERATION){
                Operation oper = new Operation(tokens.get(i), tokens.get(i+1), tokens.get(i+2));
                Tree.add(oper);
                i += 3;
            }
            else if(tokens.get(i).getType == TokenType.PRINT && tokens.get(i+1).getType == TokenType.PAROPEN){
                if(token.get(i+2)).getType == TokenType.PARCLOSE){
                    System.print("Err You Stupid piece of....");
                }
                else{
                    Content toPrintOut = new Content();
                    Int pI = i+1;
                    do{
                        pI++;
                        toPrintOut.addToken(tokens.get(pI));
                    }while(tokens.get(pI).getType != TokenType.PARCLOSE);
                    PrintOut outPut = new PrintOut(toPrintOut);
                    tree.add(outPut);
                }
            }
        }
    }

}
interface Node{
}
class Num implements Node{
    Token number;
    Num(Token Number){
        this.number = Number;
    }
}
class Operation implements Node{
    Node left;
    Left right;
    Token op;
    Operation(Token Left, Token OP, Token Right){
        this.left = Term1;
        this.right = Term2;
        this.op = OP;
    }

}
class Content{
    List<Token> in;
    Content(){
        in = new ArrayList<>();
    }
    void addToken(Token tok){
        in.add(tok);
    }
}
class PrintOut implements Node{
    Content contents;
    PrintOut(Content Contents){
        this.contents = Contents;
    }
}