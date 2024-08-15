package c_ast_descendenteV;
import java.io.FileReader;
public class Main{
   public static void main(String[] args) throws Exception {
      //ConstructorASTsEval asint = new ConstructorASTsEval(new FileReader(args[0]));
      ConstructorASTsTinyJavaccV asint = new ConstructorASTsTinyJavaccV(new FileReader(args[0]));
      asint.disable_tracing();
      //asint.inicial().imprime();
      //asint.analiza();
      asint.inicial().procesa(new Impresion());
   }
}