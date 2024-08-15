package asint;


import c_ast_descendente.Token;

public class SintaxisAbstractaTiny {
	
	// Default (No hay que tocar)
    public static abstract class Nodo  {
       public Nodo() {
		   fila=col=-1;
       }   
	   private int fila;
	   private int col;
	   public Nodo ponFila(int fila) {
		    this.fila = fila;
            return this;			
	   }
	   public Nodo ponCol(int col) {
		    this.col = col;
            return this;			
	   }
	   public int leeFila() {
		  return fila; 
	   }
	   public int leeCol() {
		  return col; 
	   }
    }
    
    // Expresiones
    public static abstract class Exp  extends  Nodo {
       public Exp() {
		   super();
       }   
       public String iden() {throw new UnsupportedOperationException();}
       public String valor() {throw new UnsupportedOperationException();}
       public Exp opnd0() {throw new UnsupportedOperationException();}
       public Exp opnd1() {throw new UnsupportedOperationException();}
    }
    private static abstract class ExpBin extends Exp {
        protected Exp opnd0;
        protected Exp opnd1;
        public ExpBin(Exp opnd0, Exp opnd1) {
            super();
            this.opnd0 = opnd0;
            this.opnd1 = opnd1;
        }
        public Exp opnd0() {return opnd0;}
        public Exp opnd1() {return opnd1;}

    }
     
    
    public static class Prog extends Nodo {
 	   private Bloq bloq;
        public Prog(Bloq bloq) {
 		   super();
 		   this.bloq = bloq;
        }   
        public Bloq decs() {return bloq;}
        public String toString() {
             return "prog("+bloq+")";
         } 
     }  
    public static class Bloq extends Nodo { 
 	   	private DecsOp decsOp;
 	   	private InstrsOp instrsOp;
        public Bloq(DecsOp decsOp, InstrsOp instrsOp) {
 		   super();
 		   this.decsOp = decsOp;
 		   this.instrsOp = instrsOp;
        }   
        public DecsOp decsOp() {return decsOp;}
        public InstrsOp instrsOp() {return instrsOp;}
        public String toString() {
             return "bloq("+decsOp+","+instrsOp+")";
         } 
    }  
    public static class Si_decs extends DecsOp {
    	private Decs decs; 
        public Si_decs(Decs decs) {
 		   super();
 		   this.decs = decs;
        }   
        public Decs decs() {return decs;}
        public String toString() {
             return "si_decs("+decs+")";
         } 
    }    
    public static class No_decs extends DecsOp {
        public No_decs() {
           super();
        }   
        public String toString() {
             return "no_decs()";
         } 
    }
    public static class Si_instrs extends InstrsOp {
    	private Instrs instrs; 
        public Si_instrs(Instrs  instrs) {
 		   super();
 		   this.instrs = instrs;
        }   
        public Instrs instrs() {return instrs;}
        public String toString() {
             return "si_intrs("+instrs+")";
         } 
    }    
    public static class No_instrs extends InstrsOp {
        public No_instrs() {
           super();
        }   
        public String toString() {
             return "no_intrs()";
         } 
    }
    
    public static class Muchas_decs extends Decs {
        private Decs decs;
        private Dec dec;
        public Muchas_decs(Decs decs, Dec dec) {
           super();
           this.dec = dec;
           this.decs = decs;
        }
        public Decs decs() {return decs;}
        public Dec dec() {return dec;}
        public String toString() {
             return "muchas_decs("+decs+","+dec+")";
         } 
    }
    public static class Una_dec extends Decs {
        private Dec dec;
        public Una_dec(Dec dec) {
           super();
           this.dec = dec;
        }
        public Dec dec() {return dec;}
        public String toString() {
             return "una_dec("+dec+")";
         } 
    }
    public static class Dec_variable extends Dec { // TODO Nodo en vez de Dec?
    	private Tipo tipo;
    	private String id;
        
        public Dec_variable(Tipo tipo, String id) {
            this.tipo=tipo;
        	this.id = id;
            
        }
        public Tipo tipo() {return tipo;}
        public String iden() {return id;}        
        
        public String toString() {
            return "dec_variable("+id+"["+leeFila()+","+leeCol()+"],"+tipo+")";
        } 
    }
    
    public static class Tipo_lista extends Tipo { // TODO extends Tipo?
 	   	private Tipo tipo;
 	    private Token literalEntero;
        public Tipo_lista(Tipo tipo, Token literalEntero) {
 		   super();
 		   this.tipo = tipo;
 		   this.literalEntero = literalEntero;
        }   
        public Tipo tipo() {return tipo;}
        public Token literalEntero() {return literalEntero;}
        public String toString() {
             return "tipo_lista("+tipo+","+literalEntero+")";
         } 
    }
    public static class Tipo_circum extends Tipo { // TODO extends Tipo?
 	   	private Tipo tipo;
        public Tipo_circum(Tipo tipo) {
 		   super();
 		   this.tipo = tipo;
        }   
        public Tipo tipo() {return tipo;}
        public String toString() {
             return "tipo_circum("+tipo+")";
         } 
    }
    public static class Lit_ent extends Exp {
        private String num;
        public Lit_ent(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_ent("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_real extends Exp {
        private String num;
        public Lit_real(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_real("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_bool extends Exp {
        private String num;
        public Lit_bool(String num) {
            super();
            this.num = num;
        }
        public String valor() {return num;}
        public String toString() {
            return "lit_bool("+num+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    public static class Lit_cadena extends Exp {
        private String id;
        public Lit_cadena(String id) {
            super();
            this.id = id;
        }
        public String valor() {return id;}
        public String toString() {
            return "lit_cadena("+id+"["+leeFila()+","+leeCol()+"])";
        } 
    }
    
    
    
    public static abstract class DecsOp extends Nodo {
        public DecsOp() {
        }        
        //public DecsOp decsop() {throw new UnsupportedOperationException();}
        public Decs decs() {throw new UnsupportedOperationException();}
    }
    public static abstract class InstrsOp extends Nodo {
        public InstrsOp() {
        }   
    	
        public Instrs instrs() {throw new UnsupportedOperationException();}
    }
    public static abstract class Decs extends Nodo { // Instrs, ParsF
        public Decs() {
     	   super();
        }
        public Dec dec() {throw new UnsupportedOperationException();}
 	   public Decs ldecs() {throw new UnsupportedOperationException();}
    }
	public static abstract class Instrs extends Nodo { // Decs, ParsF
	       public Instrs() {
	    	   super();
	       }
	       public Instr instr() {throw new UnsupportedOperationException();}
		   public Instrs instrs() {throw new UnsupportedOperationException();}

    }
	public static abstract class Dec extends Nodo { // ParF
        public Dec() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }
    public static abstract class Instr extends Nodo { // Dec, ParF 
        public Instr() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}
    }  
    public static abstract class Tipo extends Nodo { // TODO
        public Tipo() {
        }
        // TODO
        //public LDecs ldecs() {throw new UnsupportedOperationException();}

    }
    
    
    
    public Prog prog(Bloq bloq) { return new Prog(bloq); }
    public Bloq bloq(DecsOp decsop,InstrsOp instrsop) { return new Bloq(decsop,instrsop); }
    public Si_decs si_decs(Decs decs) { return new Si_decs(decs); }
    public No_decs no_decs() { return new No_decs(); }
    public Si_instrs si_instrs(Instrs instrs) { return new Si_instrs(instrs); }
    public No_instrs no_instrs() { return new No_instrs(); }
    
    public Muchas_decs muchas_decs(Decs decs, Dec dec) { return new Muchas_decs(decs, dec); }
    public Una_dec una_dec(Dec dec) { return new Una_dec(dec); }
    public Dec_variable dec_variable(Tipo tipo, String id) { return new Dec_variable(tipo, id); }
    
    public Tipo_lista tipo_lista(Tipo tipo, Token literalEntero) { 
    	return new Tipo_lista(tipo, literalEntero); 
	}
    public Tipo_circum tipo_circum(Tipo tipo) { return new Tipo_circum(tipo); }
    
    
    
    public Exp lit_ent(String num) { return new Lit_ent(num); }
    public Exp lit_real(String num) { return new Lit_real(num); }
    public Exp lit_bool(String num) { return new Lit_bool(num); }
    public Exp lit_cadena(String num) { return new Lit_cadena(num);}
}
