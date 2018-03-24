public class Token{
    TokenType type;
    String value;
    Token(TokenType Type){//Token(Function)
        this.type = Type;
    }
    Token(TokenType Type, String Value){//Token(Intenger, "2") or Token(Float, "1.2")
        this.type = Type;
        this.value = Value;
    }
    public TokenType getType(){
        return this.type;
    }
    public String getValue(){
        return this.value;
    }
    public Token getToken(){
        return this;
    }
}
