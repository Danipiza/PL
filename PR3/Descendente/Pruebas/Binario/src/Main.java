import ebin.EvaluadorBin;
import java.io.FileReader;

public class Main{
   public static void main(String[] args) throws Exception {
      EvaluadorBin ev = new EvaluadorBin(new FileReader(args[0]));
      System.out.println(ev.evalua());
   }
}