package c_ast_descendenteR;
import java.io.FileReader;
public class Main{
   public static void main(String[] args) throws Exception {
      //ConstructorASTsEval asint = new ConstructorASTsEval(new FileReader(args[0]));
      ConstructorASTsTiny asint = new ConstructorASTsTiny(new FileReader(args[0]));
      asint.disable_tracing();
      System.out.println(asint.inicial());
      //asint.analiza();
   }
}