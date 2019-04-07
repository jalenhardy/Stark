import java.util.List;

public class Interpreter {

    public static void run(List<Node> tree){
        for(int i = 0; i < tree.size();i++){
            System.out.println(tree.get(i).execute());
        }
    }
}
