public class Token{
    TokenType type;
    String value;

    //Token(Intenger, "2") or Token(Float, "1.2")
    Token(TokenType Type, String Value){
        this.type = Type;
        this.value = Value;
    }

    public TokenType getType(){
        return this.type;
    }
    public String getValue(){
        return this.value;
    }
    /*
    public Token getToken(){
        return this;
    }
    */

    @Override
    public String toString() {
        return getValue();
    }
}
