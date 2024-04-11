import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.Impresion;
import asint.SintaxisAbstractaTiny.Prog;
import c_ast_ascendente.ALexOperations.ECaracterInesperado;
import c_ast_ascendente.AnalizadorLexicoTiny;
import c_ast_ascendente.AnalizadorSintacticoTinyDJAsc;
import c_ast_ascendente.ConstructorAST;
import c_ast_ascendente.GestionErroresTiny.ErrorSintactico;
import c_ast_descendente.AnalizadorSintacticoTinyDJ;
import c_ast_descendente.ConstructorASTsTiny;
import c_ast_descendente.ParseException;
import c_ast_descendente.TokenMgrError;

//import c_ast_ascendente.ALexOperations.ECaracterInesperado;
//import c_ast_ascendente.GestionErroresTiny.ErrorSintactico;

public class Main {
	
	public static void main(String[] args) throws Exception {
			
		if (args.length != 3) {
            System.out.println("Uso: java Main.java <archivo.txt> opc opp");
            System.out.println("- Constructor AST 'opc':\n'desc': descendente\n'asc': ascendente.");
            System.out.println("- Patron 'opp':\n'rec': recursivo\n'int': interprete\n'vis': visitante");
            return;
		}
		
		String archivo=args[0];
		String constructor=args[1];
		String patron=args[2];
		
		Reader input = new InputStreamReader(new FileInputStream(archivo));
		
		//Reader input = new InputStreamReader(new FileInputStream("data/input.txt"));
		
		//Reader input = new InputStreamReader(System.in);	
		BufferedReader bufferedReader = new BufferedReader(input);         
         
		
		try { 
			if(constructor.equals("asc")) { // ASCENDENTE 
				
				System.out.println("CONSTRUCCION AST ASCENDENTE");
				AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(bufferedReader);						
				
				ConstructorAST asint = new AnalizadorSintacticoTinyDJAsc(alex);							
				Prog prog =(Prog) asint.debug_parse().value;		
				
				if(patron.equals("rec")) {
					System.out.println("IMPRESION RECURSIVA");
					System.out.print(prog);
				}
				else if(patron.equals("int")) {
					System.out.println("IMPRESION INTERPRETE");
					prog.imprime();
				}
				else {
					System.out.println("IMPRESION VISITANTE");					
					prog.procesa(new Impresion());
				}				
				
			}
			else { // DESCENDENTE
				System.out.println("CONSTRUCCION AST DESCENDENTE");
				// // CONSTRUYE
				ConstructorASTsTiny asint = new AnalizadorSintacticoTinyDJ(bufferedReader);
				
	            // asint.disable_tracing();
	            
				
				Prog prog=asint.inicial();
				
				if(patron.equals("rec")) {
					System.out.println("IMPRESION RECURSIVA");
					System.out.print(prog);
				}
				else if(patron.equals("int")) {
					System.out.println("IMPRESION INTERPRETE");
					prog.imprime();
				}
				else {
					System.out.println("IMPRESION VISITANTE");					
					prog.procesa(new Impresion());
				}
				
			}
		}
		catch(TokenMgrError e) {
			System.out.println("ERROR_LEXICO"); 
		}		
		catch(ECaracterInesperado e2) {
			System.out.println("ERROR_LEXICO"); 
		}		
		catch(ParseException e) {
			System.out.println("ERROR_SINTACTICO"); 
		}
		catch(ErrorSintactico e) {
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
