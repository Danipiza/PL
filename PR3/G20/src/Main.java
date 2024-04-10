import java.io.FileNotFoundException;
import java.io.Reader;

import asint.Impresion;
import asint.SintaxisAbstractaTiny.Prog;

import java.io.FileInputStream;
import java.io.InputStreamReader;

import c_ast_ascendente.AnalizadorLexicoTiny;
import c_ast_ascendente.ConstructorAST;
import c_ast_descendente.ConstructorASTsTiny;
import c_ast_descendente.ParseException;

public class Main {

	public static void main(String[] args) {
		
		if (args.length != 3) {
            System.out.println("Uso: java Main.java <archivo.txt> opc opp");
            System.out.println("- Constructor AST 'opc':\n'desc': descendente\n'asc': ascendente.");
            System.out.println("- Patron 'opp':\n'rec': recursivo\n'int': interprete\n'vis': visitante");
            return;
		}
		
		String archivo=args[0];
        String constructor=args[1];
        String patron=args[2];
        
        
		
	    //
		//ConstructorAST asint = null;
		try {		
			Reader input = new InputStreamReader(new FileInputStream(archivo));
			if(constructor.equals("asc")) {				
				AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
				ConstructorAST asint = new ConstructorAST(alex);
				Prog prog = (Prog)asint.parse().value;
				switch (patron) {
				case "rec":
					System.out.println(prog);
					break;
				case "int":					
					prog.imprime();
					break;
				case "vis":					
		        	prog.procesa(new Impresion());
					break;
				default:
					System.out.println("El patron tiene que ser 'rec', 'int' o 'vis'");
					return;
				}
				
				
			}
			else {
				ConstructorASTsTiny asint = new ConstructorASTsTiny(input);
	            asint.disable_tracing();
	            switch (patron) {
				case "rec":
					System.out.print(asint.inicial());
					break;
				case "int":					
					asint.inicial().imprime();
					break;
				case "vis":					
					asint.inicial().procesa(new Impresion());   
					break;
				default:
					System.out.println("El patron tiene que ser 'rec', 'int' o 'vis'");
					return;
				}	            	            
			}			
			
			
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); } 
		catch (ParseException e) { e.printStackTrace(); } 
		catch (Exception e) { e.printStackTrace(); }
		  
		   
	      

	}

}
