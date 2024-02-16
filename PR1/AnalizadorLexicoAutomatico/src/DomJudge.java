import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import alex.*;

public class DomJudge {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		AnalizadorLexicoTiny al = null;
		
		
	
		// INPUT
		Reader input = new InputStreamReader(new FileInputStream("input.txt"));
		// DOMJUDGE
		// Reader input = new InputStreamReader(System.in);
		al = new AnalizadorLexicoTiny(input);
		

		UnidadLexica unidad = null;
		
		do {
			unidad = al.yylex();
			System.out.println(unidad);
		}
		while (unidad.clase() != ClaseLexica.EOF);
	}        
} 
 