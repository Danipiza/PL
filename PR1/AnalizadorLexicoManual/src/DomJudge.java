import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class DomJudge {

	public static void main(String[] args) {		
		AnalizadorLexicoTiny al = null;
		
		try {
			Reader input = new InputStreamReader(new FileInputStream("input.txt"));
			al = new AnalizadorLexicoTiny(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		UnidadLexica unidad = null;
		
		do {
			try {
				unidad = al.sigToken();
				System.out.println(unidad);
				//System.out.println(unidad.print());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		while (unidad.clase() != ClaseLexica.EOF);
	}

}
