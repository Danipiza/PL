import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.Impresion;
import asint.SintaxisAbstractaTiny.Prog;
import c_ast_ascendente.ALexOperations.ECaracterInesperado;
import c_ast_ascendente.AnalizadorLexicoTiny;
import c_ast_ascendente.ConstructorAST;
import c_ast_ascendente.GestionErroresTiny.ErrorSintactico;
import c_ast_descendente.AnalizadorSintacticoTinyDJ;
import c_ast_descendente.ConstructorASTsTiny;
import c_ast_descendente.ParseException;
import c_ast_descendente.TokenMgrError;

//import c_ast_ascendente.ALexOperations.ECaracterInesperado;
//import c_ast_ascendente.GestionErroresTiny.ErrorSintactico;

public class DomJudge {
	
	public static void main(String[] args) throws Exception {
			
		
		Reader input = new InputStreamReader(new FileInputStream("data/input.txt"));
		
		//Reader input = new InputStreamReader(System.in);	
		BufferedReader bufferedReader = new BufferedReader(input);
         
         
		String parser = bufferedReader.readLine();
		try { 
			if(parser.equals("a")) { // ASCENDENTE 
				System.out.println("CONSTRUCCION AST ASCENDENTE");
				AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(bufferedReader);
				ConstructorAST asint = new ConstructorAST(alex);
				
				//asint.debug_parse();
				

				Prog prog = (Prog)asint.parse().value;
				System.out.println("IMPRESION RECURSIVA");
				System.out.print(prog);
				
				System.out.println("IMPRESION INTERPRETE");
				prog.imprime();
				
				System.out.println("IMPRESION VISITANTE");					
				prog.procesa(new Impresion());
			}
			else { // DESCENDENTE
				System.out.println("CONSTRUCCION AST DESCENDENTE");
				// CONSTRUYE
				ConstructorASTsTiny asint = new AnalizadorSintacticoTinyDJ(bufferedReader);
				//ConstructorASTsTiny asint = new ConstructorASTsTiny(bufferedReader);
	            asint.disable_tracing();
	            
				
				Prog a=asint.inicial();
				
				
				System.out.println("IMPRESION RECURSIVA");
				System.out.print(a);
				System.out.println("IMPRESION INTERPRETE");
				a.imprime();
				System.out.println("IMPRESION VISITANTE");					
				a.procesa(new Impresion());
			}
		}
		catch(TokenMgrError e) {
			System.out.println("ERROR_LEXICO"); 
		}
		catch(ParseException e) {
			System.out.println("ERROR_SINTACTICO"); 
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
