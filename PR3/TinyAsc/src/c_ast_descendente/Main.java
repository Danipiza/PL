package c_ast_descendente;
import java.io.FileReader;

public class Main{
   public static void main(String[] args) throws Exception {
      ConstructorASTsTiny asint = new ConstructorASTsTiny(new FileReader(args[0]));
      //ConstructorASTsTiny asint = new ConstructorASTsTiny(new FileReader(args[0]));
      asint.disable_tracing();
      asint.programa();
   }
}