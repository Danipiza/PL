import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import c_ast_ascendente.ALexOperations.ECaracterInesperado;
import c_ast_ascendente.GestionErroresTiny.ErrorSintactico;

public class DomJudge {
	
	public static void main(String[] args) throws Exception {
			
		//Reader input = new InputStreamReader(new FileInputStream("input.txt"));
		Reader input = new InputStreamReader(System.in);		
		
		String parser="";
		try { 
			if(parser.equals("a")) { // ASCENDENTE 
				// CONSTRUYE
				
				
				// IMPRIME SALIDA AST (lexico)
				System.out.println("CONSTRUCCION AST ASCENDENTE");
				
				
				// Imprime patrones
				System.out.println("IMPRESION RECURSIVA");
				
				System.out.println("IMPRESION INTERPRETE");
				
				System.out.println("IMPRESION VISITANTE");
			}
			else { // DESCENDENTE
				// CONSTRUYE
				
				
				// IMPRIME SALIDA AST (lexico)
				System.out.println("CONSTRUCCION AST ASCENDENTE");
				
				
				// Imprime patrones
				System.out.println("IMPRESION RECURSIVA");
				
				System.out.println("IMPRESION INTERPRETE");
				
				System.out.println("IMPRESION VISITANTE");
			}
		}
		catch(ECaracterInesperado e) {
			System.out.println("ERROR_LEXICO"); 
		}
		catch(ErrorSintactico e) {
			System.out.println("ERROR_SINTACTICO"); 
		}
		catch(ClassCastException e) {
			 
		}
			
		/*//Reader input = new InputStreamReader(System.in);		
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTinyDJ(alex);
		//asint.setScanner(alex);
		   
			asint.debug_parse();
		}
			catch(ECaracterInesperado e) {
			System.out.println("ERROR_LEXICO"); 
		}
		catch(ErrorSintactico e) {
			System.out.println("ERROR_SINTACTICO"); 
		}
		catch(ClassCastException e) {
			
		}*/
	}
}
