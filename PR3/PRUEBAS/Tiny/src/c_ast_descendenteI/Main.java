package c_ast_descendenteI;
import java.io.FileReader;
public class Main{
   public static void main(String[] args) throws Exception {
      //ConstructorASTsEval asint = new ConstructorASTsEval(new FileReader(args[0]));
      ConstructorASTsTinyJavaccI asint = new ConstructorASTsTinyJavaccI(new FileReader(args[0]));
      asint.disable_tracing();
      asint.inicial().imprime();
      //asint.analiza();
   }
}