package asint;

import alex.UnidadLexica;
import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import errors.GestionErroresEval;
import java.io.IOException;
import java.io.Reader;
import java.util.EnumSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalizadorSintacticoEval {
   private UnidadLexica anticipo;       // token adelantado
   private AnalizadorLexicoTiny alex;   // analizador léxico 
   private GestionErroresEval errores;  // gestor de errores
   private Set<ClaseLexica> esperados;  // clases léxicas esperadas
   
   public AnalizadorSintacticoEval(Reader input) {
      // se crea el gestor de errores
      errores = new GestionErroresEval();
        
      // se crea el analizador léxico
      try {
		alex = new AnalizadorLexicoTiny(input);
      } catch (IOException e) {
		e.printStackTrace();
      }
      // se fija el gestor de errores en el analizador léxico
      // (debe añadirse el método 'fijaGestionErrores' a
      //  dicho analizador)
      alex.fijaGestionErrores(errores);
      // se crea el conjunto de clases léxicas esperadas
      // (estará incializado a vacío)
      esperados = EnumSet.noneOf(ClaseLexica.class);
      // Se lee el primer token adelantado
      sigToken();                      
   }
   public void analiza() {
      programa();
      empareja(ClaseLexica.EOF);
   }
   private void programa() {
	   // TODO
	   llaveAp();
	   bloque();   		
	   llaveCierre();
	   
	   // ANTIGUO
	   //expresion();
	   //declaraciones();
   }
   
   private void llaveAp() { empareja(ClaseLexica.LLAP); }   
   private void llaveCierre() { empareja(ClaseLexica.LLCIERRE); }   
   private void bloque() {	   
	   declaraciones_opt();
	   instrucciones_opt();

   }
   
   private void declaraciones_opt() {
	   if(anticipo.clase()==ClaseLexica.BOOL || anticipo.clase()==ClaseLexica.REAL || 
			   anticipo.clase()==ClaseLexica.ENT) {
		   declaraciones();
		   empareja(ClaseLexica.SEP);
	   }
	   
	   switch(anticipo.clase()) { 
       case ENT, REAL, BOOL:    	   
           empareja(ClaseLexica.ENT);
           empareja(ClaseLexica.IDEN);
           empareja(ClaseLexica.PYC);
           declaraciones_opt();
       
           break;
       default: //declaraciones_opt → ε
            //esperados(ClaseLexica.ENT,ClaseLexica.REAL,ClaseLexica.BOOL);
    	   break;
	   } 
   }
   
   
   
   
   
   private void instrucciones_opt() {
	   
   }

   
   private void expresion() {
       empareja(ClaseLexica.EVALUA);
       E0();
   }
   
   private void declaraciones() {
       switch(anticipo.clase()) {
           case DONDE: 
                 empareja(ClaseLexica.DONDE);
                 lista_declaraciones();
                 break;
           default:        
                esperados(ClaseLexica.DONDE);
                break;
       } 
   }
   
   private void lista_declaraciones() {
       declaracion();
       rlista_decs();
   }
   
   private void declaracion() {
       empareja(ClaseLexica.IDEN);
       empareja(ClaseLexica.IGUAL);
       E0();
   }    
   
   private void rlista_decs() {
       switch(anticipo.clase()) {
           case COMA: 
               empareja(ClaseLexica.COMA);
               declaracion();
               rlista_decs();
               break;
           default:
              esperados(ClaseLexica.COMA);
              break;
       }
   }
   
   private void E0() {
       E1();
       RE0();
   }
   
   private void RE0() {
       switch(anticipo.clase()) {
           case MAS, MENOS: 
               OP0();
               E1();
               RE0();
               break;
           default: 
              esperados(ClaseLexica.MAS,ClaseLexica.MENOS);
              break;
       }    
    }
   

   private void E1() {
       E2();
       RE1();
   }
   
   private void RE1() {
       switch(anticipo.clase()) {
           case POR, DIV: 
               OP1();
               E2();
               RE1();
               break;
           default: 
              esperados(ClaseLexica.POR,ClaseLexica.DIV);
              break;
       }    
    }
   
   private void E2() {
      switch(anticipo.clase()) {
          case ENT: empareja(ClaseLexica.ENT); break;
          case REAL: empareja(ClaseLexica.REAL); break; 
          case IDEN: empareja(ClaseLexica.IDEN); break;
          case PAP: 
               empareja(ClaseLexica.PAP); 
               E0(); 
               empareja(ClaseLexica.PCIERRE); 
               break;
          default:
              esperados(ClaseLexica.ENT,ClaseLexica.REAL,ClaseLexica.IDEN,ClaseLexica.PAP);
              error();
   }   
   }
   
   private void OP0() {
     switch(anticipo.clase()) {
         case MAS: empareja(ClaseLexica.MAS); break;  
         case MENOS: empareja(ClaseLexica.MENOS); break;  
         default:    
              esperados(ClaseLexica.MAS,ClaseLexica.MENOS);             
              error();
     }  
   }
   private void OP1() {
     switch(anticipo.clase()) {
         case POR: empareja(ClaseLexica.POR); break;  
         case DIV: empareja(ClaseLexica.DIV); break;  
         default:    
             esperados(ClaseLexica.POR,ClaseLexica.DIV);             
             error();
     }  
   }
       

   private void esperados(ClaseLexica ... esperadas) {
       for(ClaseLexica c: esperadas) {
           esperados.add(c);
       }
   }
   
   
   private void empareja(ClaseLexica claseEsperada) {
      if (anticipo.clase() == claseEsperada)
          sigToken();
      else {
          esperados(claseEsperada);
          error();
      }
   }
   private void sigToken() {
      try {
        //anticipo = alex.yylex();    	
    	anticipo = alex.sigToken();
        System.out.println(anticipo); // TODO AÑADIDO
        esperados.clear();
      }
      catch(IOException e) {
        errores.errorFatal(e);
      }
   }
   
    private void error() {
        errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), esperados);
    }
  
}
