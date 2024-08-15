package c_ast_ascendente;


public class ALexOperations {
    
  private AnalizadorLexicoEval alex;
  public ALexOperations(AnalizadorLexicoEval alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.IDEN,alex.lexema()); 
  } 
  public UnidadLexica unidadEvalua() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.EVALUA,"<evalua>"); 
  } 
  public UnidadLexica unidadDonde() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.DONDE,"<donde>"); 
  } 
  public UnidadLexica unidadEnt() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.ENT,alex.lexema()); 
  } 
  public UnidadLexica unidadReal() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.REAL,alex.lexema()); 
  } 
  public UnidadLexica unidadSuma() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.MAS,"+"); 
  } 
  public UnidadLexica unidadResta() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.MENOS,"-"); 
  } 
  public UnidadLexica unidadMul() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.POR,"*"); 
  } 
  public UnidadLexica unidadDiv() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.DIV,"/"); 
  } 
  public UnidadLexica unidadPAp() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.PAP,"("); 
  } 
  public UnidadLexica unidadPCierre() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.PCIERRE,")"); 
  } 
  public UnidadLexica unidadIgual() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.IGUAL,"="); 
  } 
  public UnidadLexica unidadComa() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.COMA,","); 
  } 
  public UnidadLexica unidadEof() {
     return new UnidadLexica(alex.fila(), alex.columna(),sym.EOF,"<EOF>"); 
  }

}
