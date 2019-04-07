import java.util.ArrayList;
import java.util.List;


public class Parser{
    List<Node> tree;
    List<Token> tokens;
    public Parser(List<Token> tokens){
        this.tokens = tokens;
        tree = new ArrayList<>();
        generateTree();
    }
    private void generateTree(){
        try{
        for(int i = 0; i < tokens.size();i++){
            if(tokens.get(i).getType() == TokenType.INTEGER || tokens.get(i).getType() == TokenType.FLOAT && tokens.get(i+1).getType() == TokenType.OPERATION){
                Num tempNum = new Num(tokens.get(i));
                Num tempNum2 = new Num(tokens.get(i+2));
                Op tempOp = new Op(tempNum,tokens.get(i+1), tempNum2);
                tree.add(tempOp);
                i+=2;
            }
        }}catch(IndexOutOfBoundsException e){
            System.out.println("Operations must be entered x + y, not x +y or x+ y");
        }
    }
    List<Node> getTree(){
        return tree;
    }

}


interface Node{
    int execute();

}


class Num{
    Token number;
    Num(Token number){
        this.number = number;
    }
    public Token getToken(){
        return this.number;
    }
}
class Op implements Node{
    Num left;
    Num right;
    Token op;
    Op(Num Left, Token OP,Num Right){
        this.left = Left;
        this.right = Right;
        this.op = OP;
    }
    public int execute(){
        if (op.getValue() == "ADDITION") {
            return Integer.parseInt(left.getToken().getValue()) + Integer.parseInt(right.getToken().getValue());
        }
        else if((op.getValue() == "SUBTRACTION")){
            return Integer.parseInt(left.getToken().getValue()) - Integer.parseInt(right.getToken().getValue());
        }
        else if((op.getValue() == "MULTIPLICATION")){
            return Integer.parseInt(left.getToken().getValue()) * Integer.parseInt(right.getToken().getValue());
        }
        else if((op.getValue() == "DIVISION")){
            return Integer.parseInt(left.getToken().getValue()) / Integer.parseInt(right.getToken().getValue());
        }
        else if((op.getValue() == "MODULUS")){
            return Integer.parseInt(left.getToken().getValue()) % Integer.parseInt(right.getToken().getValue());
        }
        return 0;
    }
}